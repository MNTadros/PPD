package com.projectplanner.dashboard;

public class Report {
    private Long id;
    private String title;
    private String content;
    private String googleDocLink;
    private Project project;

    public Report() {}

    public Report(Long id, String title, String content, String googleDocLink, Project project) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.googleDocLink = googleDocLink;
        this.project = project;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public String getGoogleDocLink() {return googleDocLink;}
    public void setGoogleDocLink(String googleDocLink) {this.googleDocLink = googleDocLink;}
    public Project getProject() {return project;}
    public void setProject(Project project) {this.project = project;}
}
