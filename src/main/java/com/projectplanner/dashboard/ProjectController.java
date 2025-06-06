package com.projectplanner.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class ProjectController {
    private List<Project> projects = new ArrayList<>();

    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projects);
        return "project";
    }

    @PostMapping("/projects")
    public String addProject(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String people) {

        long id = projects.size() + 1;
        List<String> tagList = (tags != null && !tags.isBlank())
                ? Arrays.asList(tags.split("\\s*,\\s*"))
                : Collections.emptyList();
        List<String> peopleList = (people != null && !people.isBlank())
                ? Arrays.asList(people.split("\\s*,\\s*"))
                : Collections.emptyList();

        projects.add(new Project(id, name, description, tagList, peopleList));
        return "redirect:/projects";
    }
}
