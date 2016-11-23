package com.opensymphony.sass.osuser;

import com.opensymphony.user.provider.AccessProvider;
import com.opensymphony.user.Entity;

import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Iterator;

import com.opensymphony.sass.user.*;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SassGroupManager implements AccessProvider {
    UserManager userManager = UserManagerFactory.getInstance();

    public boolean addToGroup(String username, String groupname) {
        return false;
    }

    public boolean inGroup(String username, String groupname) {
        return listGroupsContainingUser(username).contains(groupname);
    }

    public List listGroupsContainingUser(String username) {
        User user = userManager.getUser(username);
        return user.getGroupNames();
    }

    public List listUsersInGroup(String groupname) {
        Group group = userManager.getGroup(groupname);
        return group.getUsernames();
    }

    public boolean removeFromGroup(String username, String groupname) {
        return false;
    }

    public boolean create(String groupname) {
        return false;
    }

    public void flushCaches() {
    }

    public boolean handles(String name) {
        if (list().contains(name)) {
            return true;
        } else {
            return userManager.getUser(name) != null;
        }
    }

    public boolean init(Properties properties) {
        return true;
    }

    public List list() {
        List groups = userManager.getAllGroups();
        List groupNames = new ArrayList(groups.size());
        for (Iterator iterator = groups.iterator(); iterator.hasNext();) {
            Group group = (Group) iterator.next();
            groupNames.add(group.getName());
        }

        return groupNames;
    }

    public boolean load(String name, Entity.Accessor accessor) {
        accessor.setName(name);
        accessor.setMutable(true);
        return true;
    }

    public boolean remove(String groupname) {
        return false;
    }

    public boolean store(String groupname, Entity.Accessor accessor) {
        return true;
    }
}
