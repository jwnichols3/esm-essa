package com.opensymphony.sass.jive;

import com.jivesoftware.base.*;
import com.jivesoftware.base.database.DbGroupManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SassGroupManager implements GroupManager, IntrospectiveGroupManager {
    static com.opensymphony.sass.user.UserManager um = com.opensymphony.sass.user.UserManagerFactory.getInstance();

    DbGroupManager db = new DbGroupManager();

    public Group createGroup(String string) throws GroupAlreadyExistsException {
        throw new UnsupportedOperationException();
    }

    public Group getGroup(long groupId) throws GroupNotFoundException {
        Group group = db.getGroup(groupId);
        return getRealGroup(groupId, group.getName());
    }

    private Group getRealGroup(long id, String name) {
        return new SassGroup(id, name);
    }

    public Group getGroup(String name) throws GroupNotFoundException {
        com.opensymphony.sass.user.Group group = um.getGroup(name);
        if (group == null) {
            throw new GroupNotFoundException("Group " + name + " not found");
        }

        // does a DB version already exist?
        try {
            Group dbGroup = db.getGroup(name);

            // good, then we don't need to do anything
            return getRealGroup(dbGroup.getID(), name);
        } catch (GroupNotFoundException e) {
            // we can ignore this, since it just means we need to create the group in the DB
        }

        // no? ok, then let's create one
        try {
            Group dbGroup = db.createGroup(name);

            // now we can return it
            return getRealGroup(dbGroup.getID(), name);
        } catch (GroupAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteGroup(Group group) throws UnauthorizedException {
        throw new UnsupportedOperationException();
    }

    public int getGroupCount() {
        return um.getAllGroups().size();
    }

    public Iterator getGroups() {
        return getGroupList().iterator();
    }

    private List getGroupList() {
        ArrayList groups = new ArrayList();
        for (Iterator iterator = um.getAllGroups().iterator(); iterator.hasNext();) {
            com.opensymphony.sass.user.Group group = (com.opensymphony.sass.user.Group) iterator.next();
            try {
                Group g = getRealGroup(db.getGroup(group.getName()).getID(), group.getName());
                groups.add(g);
            } catch (GroupNotFoundException e) {
                Log.error(e);
            }
        }
        return groups;
    }

    public Iterator getGroups(int i, int i1) {
        return getGroupList().subList(i, i1).iterator();
    }

    public Iterator getUserGroups(User user) {
        List groupNames = um.getUser(user.getUsername()).getGroupNames();
        ArrayList groups = new ArrayList(groupNames.size());
        for (Iterator iterator = groupNames.iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            try {
                Group group = getGroup(name);
                groups.add(group);
            } catch (GroupNotFoundException e) {
                Log.error(e);
            }
        }
        return groups.iterator();
    }

    public boolean isCreateGroupSupported() {
        return false;
    }

    public boolean isDeleteGroupSupported() {
        return false;
    }

    public boolean isGroupListSupported() {
        return true;
    }

    public boolean isGetUserGroupsSupported() {
        return true;
    }

    public boolean isReadOnly() {
        return true;
    }
}
