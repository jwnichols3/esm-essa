/*
 * Generated by XDoclet - Do not edit!
 */
package test.interfaces;

/**
 * Value object for Customer.
 *
 * Notice, this object is used to represent the state of an 
 * Customer object. This value object
 * Is not connected to the database in any way, it is just a normal object used 
 * as a container for data from an EJB. 
 *
 * @xdoclet-generated at 16-04-05
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.2.3
 */
public class CustomerLightValue
   extends java.lang.Object
   implements java.io.Serializable, java.lang.Cloneable 
{

   private float credit;
   private boolean creditHasBeenSet = false;

   private java.lang.String[][] array;
   private boolean arrayHasBeenSet = false;

   private byte[] image;
   private boolean imageHasBeenSet = false;

   private java.lang.String id;
   private boolean idHasBeenSet = false;

   private test.interfaces.CustomerPK primaryKey;

   private int _version = 0;

   public CustomerLightValue()
   {
	  primaryKey = new test.interfaces.CustomerPK();
   }

   public CustomerLightValue( float credit,java.lang.String[][] array,byte[] image,java.lang.String id )
   {
       setCredit(credit);
       setArray(array);
       setImage(image);
       setId(id);
       primaryKey = new test.interfaces.CustomerPK(this.getId());
   }

   /**
    * @deprecated use {@link #clone}
    */
   public CustomerLightValue( CustomerLightValue otherValue )
   {
	  this.credit = otherValue.credit;
	  creditHasBeenSet = true;
	  this.array = otherValue.array;
	  arrayHasBeenSet = true;
	  this.image = otherValue.image;
	  imageHasBeenSet = true;
	  this.id = otherValue.id;
	  idHasBeenSet = true;

	  primaryKey = new test.interfaces.CustomerPK(this.getId());
   }

   public test.interfaces.CustomerPK getPrimaryKey()
   {
	  return primaryKey;
   }

   public void setPrimaryKey( test.interfaces.CustomerPK primaryKey)
   {
      // it's also nice to update PK object - just in case
      // somebody would ask for it later...
      this.primaryKey = primaryKey;
	  setId( primaryKey.id );
   }

   public float getCredit()
   {
	  return this.credit;
   }

   public void setCredit( float credit )
   {
	  this.credit = credit;
	  creditHasBeenSet = true;

   }

   public boolean creditHasBeenSet(){
	  return creditHasBeenSet;
   }
   public java.lang.String[][] getArray()
   {
	  return this.array;
   }

   private void setArray( java.lang.String[][] array )
   {
	  this.array = array;
	  arrayHasBeenSet = true;

   }

   public byte[] getImage()
   {
	  return this.image;
   }

   private void setImage( byte[] image )
   {
	  this.image = image;
	  imageHasBeenSet = true;

   }

   public java.lang.String getId()
   {
	  return this.id;
   }

   public void setId( java.lang.String id )
   {
	  this.id = id;
	  idHasBeenSet = true;

      primaryKey.setId(id);
   }

   public boolean idHasBeenSet(){
	  return idHasBeenSet;
   }

   public int getVersion()
   {
	  return _version;
   }
   public void setVersion(int version)
   {
	  this._version = version;
   }

   public String toString()
   {
	  StringBuffer str = new StringBuffer("{");

	  str.append("credit=" + getCredit() + " " + "array=" + getArray() + " " + "image=" + getImage() + " " + "id=" + getId());
	  str.append(",version=");
	  str.append(_version);
	  str.append('}');

	  return(str.toString());
   }

   /**
    * A Value Object has an identity if the attributes making its Primary Key have all been set. An object without identity is never equal to any other object.
    *
    * @return true if this instance has an identity.
    */
   protected boolean hasIdentity()
   {
	  boolean ret = true;
	  ret = ret && idHasBeenSet;
	  return ret;
   }

   /**
    *
    * @deprecated use {@link #equals}
    */
   public boolean isIdentical(Object other)
   {
          if (other instanceof CustomerLightValue)
          {
                 CustomerLightValue that = (CustomerLightValue) other;
                 boolean lEquals = true;
                 lEquals = lEquals && this.credit == that.credit;
                 if( this.array == null )
                 {
                        lEquals = lEquals && ( that.array == null );
                 }
                 else
                 {
                        lEquals = lEquals && this.array.equals( that.array );
                 }
                 lEquals = lEquals && this.image == that.image;

                 return lEquals;
          }
          else
          {
                 return false;
          }
   }

    public boolean equals(Object other) {

        //If it's not the correct type, clearly it isn't equal to this.
        if (!(other instanceof CustomerLightValue)) { 
            return false;
        }

        return equals((CustomerLightValue) other);
    }

    /**
     * This class is not using strict ordering. This means that the object is not Comparable, and
     * each check for equality will test all members for equality. We do not check collections for
     * equality however, so you would be wise to not use this if you have collection typed EJB References.
     */
    public boolean equals(CustomerLightValue that) {

        //try to get lucky.
        if (this == that) {
            return true;
        }
        //this clearly isn't null.
        if(null == that) {
            return false;
        }

        if(this.credit != that.credit) {
            return false;
        }

        if(this.array != that.array) {

            if( this.array == null || that.array == null ) {
                return false;
            }

            if(!this.array.equals(that.array)) {
                return false;
            }

        }

        if(!java.util.Arrays.equals(this.image, that.image)) {
            return false;
        }

        if(this.id != that.id) {

            if( this.id == null || that.id == null ) {
                return false;
            }

            if(!this.id.equals(that.id)) {
                return false;
            }

        }

        return true;

    }

    public Object clone() throws java.lang.CloneNotSupportedException {
        CustomerLightValue other = (CustomerLightValue) super.clone();

        return other;
    }

    public ReadOnlyCustomerLightValue getReadOnlyCustomerLightValue() {
        return new ReadOnlyCustomerLightValue();
    }

    public int hashCode(){
	  int result = 17;
      result = 37*result + Float.floatToIntBits(credit);

      result = 37*result + ((this.array != null) ? this.array.hashCode() : 0);

      if (image != null) {
        for (int i=0; i<image.length; i++)
        {
          long l = image[i];
          result = 37*result + (int)(l^(l>>>32));
        }
      }

      result = 37*result + ((this.id != null) ? this.id.hashCode() : 0);

	  return result;
    }

    /**
     * Covariant function so the compiler can choose the proper one at compile time,
     * eliminates the need for XDoclet to really understand compiletime typing.
     *
     * Read only collections need to be synchronized. Once we start giving out handles
     * to these collections, they'll be used in other threads sooner or later. 
     */
    private static java.util.Collection wrapCollection(java.util.Collection input) {
        return java.util.Collections.synchronizedCollection(input);
    }
    /**
     * Covariant function so the compiler can choose the proper one at compile time,
     * eliminates the need for XDoclet to really understand compiletime typing.
     *
     * Read only collections need to be synchronized. Once we start giving out handles
     * to these collections, they'll be used in other threads sooner or later. 
     */
    private static java.util.Set wrapCollection(java.util.Set input) {
        return java.util.Collections.synchronizedSet(input);
    }
    /**
     * Covariant function. This is used in covariant form so that the compiler
     * can do some of our conditional branches for us. If I made these functions
     * have different names, then XDoclet would have to choose between them based on 
     * compiletime types, that wouldn't be easy. 
     */
    private static java.util.Collection wrapReadOnly(java.util.Collection input) {
        return java.util.Collections.unmodifiableCollection(input);
    }
    /**
     * Covariant function. This is used in covariant form so that the compiler
     * can do some of our conditional branches for us. If I made these functions
     * have different names, then XDoclet would have to choose between them based on 
     * compiletime types, that wouldn't be easy. 
     */
    private static java.util.Set wrapReadOnly(java.util.Set input) {
        return java.util.Collections.unmodifiableSet(input);
    }

    private final class ReadOnlyCustomerLightValue 
    implements java.lang.Cloneable, java.io.Serializable 
    {
        private CustomerLightValue underlying() {
            return CustomerLightValue.this;
        }

       public float getCredit() {
              return underlying().credit;
       }

       public java.lang.String[][] getArray() {
              return underlying().array;
       }

       public byte[] getImage() {
              return underlying().image;
       }

       public java.lang.String getId() {
              return underlying().id;
       }

        public int hashCode() {
            return 101 * underlying().hashCode();
        }

        public boolean equals(Object o) {
            if(o instanceof ReadOnlyCustomerLightValue) {
                return this.equals((ReadOnlyCustomerLightValue) o);
            }
            return false;
        }

        public boolean equals(ReadOnlyCustomerLightValue that) {
            if(null == that) {
                return false;
            }

            return this.underlying().equals(that.underlying());
        }

    }

}
