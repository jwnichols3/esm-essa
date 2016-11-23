/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2006, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.metadata;

import java.util.Iterator;

import org.w3c.dom.Element;
import org.jboss.deployment.DeploymentException;

/** 
 * Represents one ejb-relation element found in the ejb-jar.xml
 * file's relationships elements.
 *
 * @author <a href="mailto:dain@daingroup.com">Dain Sundstrom</a>
 * @version $Revision: 57209 $
 */
public class RelationMetaData extends MetaData {
   /** Name of the relation. Loaded from the ejb-relation-name element. */
   private String relationName;
   
   /** 
    * The left relationship role. Loaded from an ejb-relationship-role.
    * Left/right assignment is completely arbitrary.
    */
   private RelationshipRoleMetaData left;

   /** 
    * The right relationship role. Loaded from an ejb-relationship-role.
    * Left/right assignment is completely arbitrary.
    */
   private RelationshipRoleMetaData right;      
   
   /** 
    * Gets the relation name. 
    * Relation name is loaded from the ejb-relation-name element.
    */
   public String getRelationName() {
      return relationName;
   }
   
   /** 
    * Gets the left relationship role. 
    * The relationship role is loaded from an ejb-relationship-role.
    * Left/right assignment is completely arbitrary.
    */
   public RelationshipRoleMetaData getLeftRelationshipRole() {
      return left;
   }
   
   /** 
    * Gets the right relationship role.
    * The relationship role is loaded from an ejb-relationship-role.
    * Left/right assignment is completely arbitrary.
    */
   public RelationshipRoleMetaData getRightRelationshipRole() {
      return right;
   }
   
   public RelationshipRoleMetaData getOtherRelationshipRole(
         RelationshipRoleMetaData role) {

      if(left == role) {
         return right;
      } else if(right == role) {
         return left;
      } else {
         throw new IllegalArgumentException("Specified role is not the left " +
               "or right role. role=" + role);
      }
   }

   public void importEjbJarXml (Element element) throws DeploymentException {
      // name - treating empty values as not specified
      relationName = getOptionalChildContent(element, "ejb-relation-name");
      if ("".equals(relationName))
      {
         relationName = null;
      }

      // left role
      Iterator iter = getChildrenByTagName(element, "ejb-relationship-role");
      if(iter.hasNext()) {
         left = new RelationshipRoleMetaData(this);
         left.importEjbJarXml((Element) iter.next());
      } else {
         throw new DeploymentException("Expected 2 ejb-relationship-role " +
               "roles but found none");
      }
      
      // right role
      if(iter.hasNext()) {
         right = new RelationshipRoleMetaData(this);
         right.importEjbJarXml((Element) iter.next());
      } else {
         throw new DeploymentException("Expected 2 ejb-relationship-role " +
               "but only found one");
      }

      // assure there are only two ejb-relationship-role elements
      if(iter.hasNext()) {
         throw new DeploymentException("Expected only 2 ejb-relationship-" +
               "role but found more then 2");
      }

      // JBossCMP needs ejb-relation-name if jbosscmp-jdbc.xml is used to map relationships.
      if(relationName == null)
      {
         // generate unique name, we can't rely on ejb-relationship-role-name being unique
         relationName =
            left.getEntityName() +
            (left.getCMRFieldName() == null ? "" : "_" + left.getCMRFieldName()) +
            "-" +
            right.getEntityName() +
            (right.getCMRFieldName() == null ? "" : "_" + right.getCMRFieldName());
      }

      // assure that the left role and right role do not have the same name
      String leftName = left.getRelationshipRoleName();
      String rightName = right.getRelationshipRoleName();
      if(leftName != null && leftName.equals(rightName)) {
         throw new DeploymentException("ejb-relationship-role-name must be " +
               "unique in ejb-relation: ejb-relationship-role-name is " +
               leftName);
      }
      
      // verify cascade delete
      if(left.isCascadeDelete() && right.isMultiplicityMany()) {
         throw new DeploymentException("cascade-delete is only allowed in " +
               "ejb-relationship-role where the other role has a " +
               "multiplicity One");
      }
      if(right.isCascadeDelete() && left.isMultiplicityMany()) {
         throw new DeploymentException("cascade-delete is only allowed in " +
               "ejb-relationship-role where the other role has a " +
               "multiplicity One");
      }
   }
}
