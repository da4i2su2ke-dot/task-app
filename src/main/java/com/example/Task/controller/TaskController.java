package com.example.Task.controller;
import com.example.Task.service.TaskService;
import com.example.Task.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class TaskController {
    @Autowired
    public TaskService taskService;

    @GetMapping("/tasks")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasks/index";
    }

    @GetMapping("/tasks/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("task",taskService.findById(id));
        return "tasks/detail";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "tasks/form";
    }
    
    @PostMapping("/tasks")
    public String save(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }
    
    @PostMapping("/tasks/{id}/delete")
    public String delete(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
    
    
}
