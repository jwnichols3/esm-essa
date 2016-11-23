package com.opensymphony.sass.jive;

import com.jivesoftware.base.*;

import java.util.*;

/**
 * User: plightbo
 * Date: Nov 25, 2005
 * Time: 9:53:24 AM
 */
public class SassGroup extends GroupAdapter {
    static com.opensymphony.sass.user.UserManager um = com.opensymphony.sass.user.UserManagerFactory.getInstance();
    static com.jivesoftware.base.UserManager jiveum = UserManagerFactory.getInstance();

    long ID;
    String name;

    public SassGroup(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public boolean isMember(User user) {
        return um.getGroup(name).getUsernames().contains(user.getName());
    }

    public Iterator getMembers() {
        List names = um.getGroup(name).getUsernames();
        ArrayList list = new ArrayList(names.size());
        for (Iterator iterator = names.iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            try {
                list.add(jiveum.getUser(name));
            } catch (UserNotFoundException e) {
                Log.error(e);
            }
        }

        return list.iterator();
    }

    public int getMemberCount() {
        return um.getGroup(name).getUsernames().size();
    }

    public boolean isAddAdministratorSupported() {
        return false;
    }

    public boolean isAddMemberSupported() {
        return false;
    }

    public boolean isAdministratorListSupported() {
        return false;
    }

    public boolean isMembersSupported() {
        return true;
    }

    public boolean isRemoveAdministratorSupported() {
        return false;
    }

    public boolean isRemoveMemberSupported() {
        return false;
    }

    public boolean isSetDescriptionSupported() {
        return false;
    }

    public boolean isSetNameSupported() {
        return false;
    }

    public boolean isGetMemberCountSupported() {
        return true;
    }

    public boolean isGetAdministratorCountSupported() {
        return false;
    }

    public boolean isPropertyEditSupported() {
        return false;
    }

    public boolean isReadOnly() {
        return true;
    }

    public Date getCreationDate() {
        return new Date();
    }

    public Date getModificationDate() {
        return new Date();
    }

    public String getDescription() {
        return "";
    }

    public int getAdministratorCount() {
        return 0;
    }

    public Iterator getAdministrators() {
        return Collections.EMPTY_LIST.iterator();
    }
}
