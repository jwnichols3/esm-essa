package com.opensymphony.sass.osuser;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.user.Entity;
import com.opensymphony.user.provider.ProfileProvider;
import com.opensymphony.user.provider.hibernate.HibernateCredentialsProvider;
import com.opensymphony.user.provider.hibernate.HibernateProfileProvider;
import com.opensymphony.sass.user.User;
import com.opensymphony.sass.user.UserManager;
import com.opensymphony.sass.user.UserManagerFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SaasHibernateProfileProvider implements ProfileProvider {
    UserManager userManager = UserManagerFactory.getInstance();
    HibernateProfileProvider hibProfile = new HibernateProfileProvider();
    HibernateCredentialsProvider hibCred = new HibernateCredentialsProvider();

    public PropertySet getPropertySet(String username) {
        if (!hibCred.handles(username)) {
            hibCred.create(username);
        }

        User user = userManager.getUser(username);
        if (user == null) {
            return null;
        }

        PropertySet ps = hibProfile.getPropertySet(username);

        return new SaasPropertySet(ps, user);
    }

    public boolean create(String string) {
        return true;
    }

    public void flushCaches() {
    }

    public boolean handles(String username) {
        return userManager.getUser(username) != null;
    }

    public boolean init(Properties properties) {
        hibCred.init(properties);
        hibProfile.init(properties);
        return true;
    }

    public List list() {
        return null;
    }

    public boolean load(String string, Entity.Accessor accessor) {
        return true;
    }

    public boolean remove(String string) {
        return true;
    }

    public boolean store(String string, Entity.Accessor accessor) {
        return true;
    }
}
