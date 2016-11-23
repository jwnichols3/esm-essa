/*
 * Generated by XDoclet - Do not edit!
 */
package test.dao;

/**
 * Data Access Object interface for CustomerBMP.
 * @xdoclet-generated at 10-02-07
 * @copyright The XDoclet Team
 * @author XDoclet
 * @version 1.3-SNAPSHOT
 */
public interface CustomerDAO
{
    public void init();

    public void load(test.interfaces.CustomerPK pk, test.ejb.CustomerBMPBean ejb) throws javax.ejb.EJBException;
    public void store(test.ejb.CustomerBMPBean ejb) throws javax.ejb.EJBException;
    public void remove(test.interfaces.CustomerPK pk) throws javax.ejb.RemoveException, javax.ejb.EJBException;

    public test.interfaces.CustomerPK create(test.ejb.CustomerBMPBean ejb) throws javax.ejb.CreateException, javax.ejb.EJBException;

    public java.util.Collection findAll() throws javax.ejb.FinderException;

    public test.interfaces.CustomerPK findByPrimaryKey(test.interfaces.CustomerPK pk) throws javax.ejb.FinderException;

    public void backup(test.interfaces.CustomerPK pk) ;

}
