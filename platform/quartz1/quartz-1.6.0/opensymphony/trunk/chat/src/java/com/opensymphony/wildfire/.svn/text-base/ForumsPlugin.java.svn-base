package com.opensymphony.wildfire;

import org.jivesoftware.util.JiveGlobals;
import org.jivesoftware.wildfire.container.PluginManager;
import org.jivesoftware.wildfire.container.Plugin;

import java.io.File;

/**
 * User: patrick
 * Date: Jul 21, 2005
 * Time: 3:38:41 PM
 */
public class ForumsPlugin implements Plugin {

    public void initializePlugin(PluginManager manager, File pluginDirectory) {
        JiveGlobals.setXMLProperty("provider.user.className", ForumsUserProvider.class.getName());
        JiveGlobals.setXMLProperty("provider.auth.className", ForumsUserProvider.class.getName());
    }

    public void destroyPlugin() {
    }
}
