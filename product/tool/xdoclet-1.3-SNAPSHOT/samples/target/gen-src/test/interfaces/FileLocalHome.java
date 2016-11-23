/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Local home interface for File.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface FileLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/FileLocal";
   public static final String JNDI_NAME="blah/File";

   public test.interfaces.FileLocal create(java.lang.String id , java.lang.String contentType , byte[] content)
      throws javax.ejb.CreateException;

   public test.interfaces.FileLocal findByPrimaryKey(java.lang.String id)
      throws javax.ejb.FinderException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public java.util.Collection findRangeOrderById(java.lang.Integer start, java.lang.Integer size)
      throws javax.ejb.FinderException;

   public java.util.Collection findRangeOrderByCreationDate(java.lang.Integer start, java.lang.Integer size)
      throws javax.ejb.FinderException;

   public java.util.Collection findRangeOrderByContentType(java.lang.Integer start, java.lang.Integer size)
      throws javax.ejb.FinderException;

}