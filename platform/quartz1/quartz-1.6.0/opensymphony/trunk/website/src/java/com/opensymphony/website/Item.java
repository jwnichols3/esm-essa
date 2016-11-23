package com.opensymphony.website;

/**
 * User: plightbo
 * Date: May 7, 2005
 * Time: 8:31:29 AM
 */
public class Item {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getAbsoluteUrl(String id) {
        if (url.startsWith("http") || url.startsWith("/")) {
            return url;
        } else {
            return "/" + id + "/" + url;
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
