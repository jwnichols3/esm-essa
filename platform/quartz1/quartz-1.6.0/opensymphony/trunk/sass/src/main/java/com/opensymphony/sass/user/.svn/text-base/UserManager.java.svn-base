package com.opensymphony.sass.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public interface UserManager {
    boolean authenticate(String username, String password);

    String authenticate(HttpServletRequest req);

    User getUser(String username);

    void create(User user, String password);

    List getAllUsers();

    Group getGroup(String name);

    List getAllGroups();

    void login(String username, String password, boolean remember, HttpServletResponse res);

    boolean changePassword(HttpServletRequest req, HttpServletResponse res, String password);

    void logout(HttpServletRequest req, HttpServletResponse res);

    void resetPassword(String username);
}
