// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1.3, build R1)
// Generated source version: 1.1.3

package org.jboss.test.wsrp.core;

import java.io.Serializable;


public class PersonName implements Serializable
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -2062865067417488983L;
   protected java.lang.String prefix;
   protected java.lang.String given;
   protected java.lang.String family;
   protected java.lang.String middle;
   protected java.lang.String suffix;
   protected java.lang.String nickname;
   protected Extension[] extensions;

   public PersonName()
   {
   }

   public PersonName(java.lang.String prefix, java.lang.String given, java.lang.String family, java.lang.String middle, java.lang.String suffix, java.lang.String nickname, Extension[] extensions)
   {
      this.prefix = prefix;
      this.given = given;
      this.family = family;
      this.middle = middle;
      this.suffix = suffix;
      this.nickname = nickname;
      this.extensions = extensions;
   }

   public java.lang.String getPrefix()
   {
      return prefix;
   }

   public void setPrefix(java.lang.String prefix)
   {
      this.prefix = prefix;
   }

   public java.lang.String getGiven()
   {
      return given;
   }

   public void setGiven(java.lang.String given)
   {
      this.given = given;
   }

   public java.lang.String getFamily()
   {
      return family;
   }

   public void setFamily(java.lang.String family)
   {
      this.family = family;
   }

   public java.lang.String getMiddle()
   {
      return middle;
   }

   public void setMiddle(java.lang.String middle)
   {
      this.middle = middle;
   }

   public java.lang.String getSuffix()
   {
      return suffix;
   }

   public void setSuffix(java.lang.String suffix)
   {
      this.suffix = suffix;
   }

   public java.lang.String getNickname()
   {
      return nickname;
   }

   public void setNickname(java.lang.String nickname)
   {
      this.nickname = nickname;
   }

   public Extension[] getExtensions()
   {
      return extensions;
   }

   public void setExtensions(Extension[] extensions)
   {
      this.extensions = extensions;
   }
}
