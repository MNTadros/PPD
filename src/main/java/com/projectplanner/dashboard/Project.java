package com.projectplanner.dashboard;

import java.util.List;

public class Project {
    private Long id;
    private String name;
    private String description;
    private List<String> tags;
    private List<String> people;

    public Project() {}

    public Project(Long id, String name, String description, List<String> tags, List<String> people) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.people = people;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public List<String> getTags() {return tags;}
    public void setTags(List<String> tags) {this.tags = tags;}
    public List<String> getPeople() {return people;}
    public void setPeople(List<String> people) {this.people = people;}
}
