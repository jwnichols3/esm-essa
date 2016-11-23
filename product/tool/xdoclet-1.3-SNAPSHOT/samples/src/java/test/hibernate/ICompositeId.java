/*
 * Copyright (c) 2001, 2005 The XDoclet team
 * All rights reserved.
 */
package test.hibernate;

public interface ICompositeId
{
    public Integer getFoo();

    public long getBar();

    public String getBaz();

    public Order getOrder();

    public void setFoo(Integer foo);

    public void setBar(long bar);

    public void setBaz(String baz);

    public void setOrder(Order order);

}
