package management.system.at.an.IT.enterprise.demo.controllers;

import management.system.at.an.IT.enterprise.demo.models.Project;
import management.system.at.an.IT.enterprise.demo.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
public class ProjectController {

    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/getAllProjects")
    public String getAllProject(Model model) {
        Iterable<Project> projects=projectRepo.findAll();
        model.addAttribute("projects", projects);
        return "project";
    }
}
