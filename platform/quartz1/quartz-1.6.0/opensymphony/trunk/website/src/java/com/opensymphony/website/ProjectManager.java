package com.opensymphony.website;

import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.HashMap;

/**
 * User: plightbo
 * Date: Apr 21, 2005
 * Time: 5:50:36 PM
 */
public class ProjectManager {
    private static ProjectManager instance = new ProjectManager();

    public static ProjectManager getInstance() {
        return instance;
    }

    XStream xStream;
    HashMap cache;

    private ProjectManager() {
        // singleton
        xStream = new XStream();
        xStream.alias("project", Project.class);
        xStream.alias("person", Person.class);
        xStream.alias("release", Release.class);
        xStream.alias("docs", Documentation.class);
        xStream.alias("item", Item.class);
        xStream.alias("forums", Forums.class);
        xStream.alias("download", Download.class);

        cache = new HashMap();
    }

    ServletContext ctx;

    public void init(ServletContext ctx) {
        this.ctx = ctx;
    }

    public synchronized void clearCache() {
        cache.clear();
    }

    public synchronized Project getProject(String name) {
        if (cache.containsKey(name)) {
            CacheEntry entry = (CacheEntry) cache.get(name);
            if (!entry.isExpired()) {
                return entry.project;
            }
        }

        Project project = null;
        String path = ctx.getRealPath(name + "/meta.xml");
        File file = new File(path);
        if (file.exists()) {
            try {
                project = buildProject(name, file);
            } catch (FileNotFoundException e) {
                project = null;
            }
        } else {
            // try in /WEB-INF/projects
            path = ctx.getRealPath("WEB-INF/projects/" + name + ".xml");
            file = new File(path);
            if (file.exists()) {
                try {
                    project = buildProject(name, file);
                } catch (FileNotFoundException e) {
                    project = null;
                }
            }
        }

        if (project != null) {
            cache.put(name, new CacheEntry(project));
        }

        return project;
    }

    private Project buildProject(String id, File file) throws FileNotFoundException {
        Project project = (Project) xStream.fromXML(new FileReader(file));
        project.setId(id);
        return project;
    }

    class CacheEntry {
        Project project;
        long time;

        public CacheEntry(Project project) {
            this.project = project;
            this.time = System.currentTimeMillis();
        }

        public boolean isExpired() {
            return (System.currentTimeMillis() > (time + 1000 * 60 * 60 * 6));
        }
    }
}
