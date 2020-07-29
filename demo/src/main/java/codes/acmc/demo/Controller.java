package codes.acmc.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import codes.acmc.demo.service.ITaskService;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ITaskService taskService;

    @RequestMapping("/message")
    public String showMessagePage(Model model) {
        model.addAttribute("mensaje", "PRUEBA");
        return "message";
    }

    @RequestMapping("/showTasks")
    public String getHelp(Model model) {

        List<Task> tasks = taskService.findAll();

        model.addAttribute("tasks", tasks);

        return "showTasks";
    }
}