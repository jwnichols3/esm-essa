package com.opensymphony.website;

/**
 * User: plightbo
 * Date: Apr 21, 2005
 * Time: 5:43:00 PM
 */
public class Project {
    String id;
    String name;
    String jiraId;
    String jiraUrl = "http://jira.opensymphony.com";
    String jiraName;
    String confluenceName;
    Forums forums;
    Item[] evaluating;
    Documentation docs;
    String about;
    String newsRssFeed;
    Person[] owners;
    Person[] developers;
    Release[] releases;
    String license = "opensymphony";
    boolean svn;
    boolean noMailingLists;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiraUrl() {
        if (jiraUrl == null) {
            return "http://jira.opensymphony.com";
        }
        
        return jiraUrl;
    }

    public void setJiraUrl(String jiraUrl) {
        this.jiraUrl = jiraUrl;
    }


    public String getJiraId() {
        return jiraId;
    }

    public void setJiraId(String jiraId) {
        this.jiraId = jiraId;
    }

    public String getJiraName() {
        return jiraName;
    }

    public void setJiraName(String jiraName) {
        this.jiraName = jiraName;
    }

    public String getConfluenceName() {
        return confluenceName;
    }

    public void setConfluenceName(String confluenceName) {
        this.confluenceName = confluenceName;
    }

    public Forums getForums() {
        return forums;
    }

    public void setForums(Forums forums) {
        this.forums = forums;
    }

    public Item[] getEvaluating() {
        return evaluating;
    }

    public void setEvaluating(Item[] evaluating) {
        this.evaluating = evaluating;
    }

    public Documentation getDocs() {
        return docs;
    }

    public void setDocs(Documentation docs) {
        this.docs = docs;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNewsRssFeed() {
        return newsRssFeed;
    }

    public void setNewsRssFeed(String newsRssFeed) {
        this.newsRssFeed = newsRssFeed;
    }

    public Person[] getOwners() {
        return owners;
    }

    public void setOwners(Person[] owners) {
        this.owners = owners;
    }

    public Person[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(Person[] developers) {
        this.developers = developers;
    }

    public Release[] getReleases() {
        return releases;
    }

    public void setReleases(Release[] releases) {
        this.releases = releases;
    }

    /**
     * @return Returns the license.
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license The license to set.
     */
    public void setLicense(String license) {
        this.license = license;
    }

    public boolean isSvn() {
        return svn;
    }

    public void setSvn(boolean svn) {
        this.svn = svn;
    }

    public boolean isNoMailingLists() {
        return noMailingLists;
    }

    public void setNoMailingLists(boolean noMailingLists) {
        this.noMailingLists = noMailingLists;
    }
}
