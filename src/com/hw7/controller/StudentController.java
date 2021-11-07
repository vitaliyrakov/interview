package com.hw7.controller;

import com.hw7.model.entity.Student;
import com.hw7.model.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("students", service.findAll());
        return "showStudent";
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "showStudent";
    }

    @GetMapping("/edit/{id}")
    public String editUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", service.findById(id));
        return "editStudent";
    }

    @GetMapping("/new")
    public String createStudent(@ModelAttribute("student") Student student) {
        return "editStudent";
    }

    @PostMapping("/new")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.save(student);
        return "redirect:/login";
    }

    @PostMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/students";
    }

}