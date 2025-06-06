package com.projectplanner.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String settingsPage(Model model) {
        // any settings‐specific data can go into the model here
        return "settings";   // <-- must match settings.html
    }
}
