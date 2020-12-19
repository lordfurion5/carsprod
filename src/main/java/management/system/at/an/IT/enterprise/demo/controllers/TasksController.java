package management.system.at.an.IT.enterprise.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TasksController {
    @GetMapping("/task")
    public String taskMain(Model model){
        model.addAttribute("title","Страница о задачах");
        return "task-main";
    }

}
