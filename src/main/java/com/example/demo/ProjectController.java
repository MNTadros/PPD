package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
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
    public String addProject(@RequestParam String name, @RequestParam String description) {
        long id = projects.size() + 1;
        projects.add(new Project(id, name, description));
        return "redirect:/projects";
    }
}
