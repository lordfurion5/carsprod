package management.system.at.an.IT.enterprise.demo.controllers;
import management.system.at.an.IT.enterprise.demo.models.Project;
import management.system.at.an.IT.enterprise.demo.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/tasks")
    public String taskMain(Model model){
        model.addAttribute("title","Страница о задачах");
        return "task-main";
    }

    @GetMapping("/addProject")
    public String addProject(Model model){
        Project expected = new Project();
        expected.setId(964320);
        expected.setName("TEST1");
         projectRepo.save(expected);

        model.addAttribute("title","Страница о задачах");
        return "task-main";
    }



    @GetMapping("/getAllProject")
    public String getAllProject(Model model) {
        Iterable<Project> projects=projectRepo.findAll();
        model.addAttribute("projects", projects);
        return "project";
    }

    @PostMapping
    public String add(@RequestParam String text, Map<String, Object> model) {
        Project project = new Project(text);

        projectRepo.save(project);

        Iterable<Project> projects = projectRepo.findAll();

        model.put("projects", projects);

        return "addProject";
    }


}