package com.opensymphony.sass.osuser;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.user.Entity;
import com.opensymphony.user.provider.ProfileProvider;
import com.opensymphony.user.provider.ofbiz.OFBizCredentialsProvider;
import com.opensymphony.user.provider.ofbiz.OFBizProfileProvider;
import com.opensymphony.sass.user.User;
import com.opensymphony.sass.user.UserManager;
import com.opensymphony.sass.user.UserManagerFactory;

import java.util.List;
import java.util.Properties;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SassOfbizProfileProvider implements ProfileProvider {
    UserManager userManager = UserManagerFactory.getInstance();
    OFBizProfileProvider ofbizProfile = new OFBizProfileProvider();
    OFBizCredentialsProvider ofbizCred = new OFBizCredentialsProvider();

    public PropertySet getPropertySet(String username) {
        if (!ofbizCred.handles(username)) {
            ofbizCred.create(username);
        }

        User user = userManager.getUser(username);
        if (user == null) {
            return null;
        }

        PropertySet ps = ofbizProfile.getPropertySet(username);

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
        ofbizCred.init(properties);
        ofbizProfile.init(properties);
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
