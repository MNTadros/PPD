package com.projectplanner.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    private final ProjectController projectController;
    private final List<Report> reports = new ArrayList<>();

    public ReportController(ProjectController projectController) {
        this.projectController = projectController;
    }

    @GetMapping("/reports")
    public String listReports(Model model) {
        model.addAttribute("reports", reports);
        return "report";
    }

    @GetMapping("/reports/new")
    public String newReportForm(Model model) {
        model.addAttribute("projects", projectController.getProjects());
        return "new-report";
    }

    @PostMapping("/reports")
    public String submitReport(@RequestParam String title,
                               @RequestParam String content,
                               @RequestParam(required = false) String googleDocLink,
                               @RequestParam Long projectId) {
        Project project = projectController.getProjects().stream()
                .filter(p -> p.getId().equals(projectId))
                .findFirst()
                .orElse(null);
        if (project == null) return "redirect:/reports";
        long reportId = reports.size() + 1;
        reports.add(new Report(reportId, title, content, googleDocLink, project));
        return "redirect:/reports";
    }
}
