package com.manning.sbip.ch09.controller;

import com.manning.sbip.ch09.model.Course;
import com.manning.sbip.ch09.service.CourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        List<Course> courseList = (List<Course>) courseService.findAllCourses();
        model.addAttribute("courses", courseList.isEmpty() ? Collections.EMPTY_LIST : courseList);

        logger.info("récupération de tous les cours");

        return "index";
    }

    @GetMapping("/addcourse")
    public String showAddCourseForm(Course course) {
        return "add-course";
    }

    @PostMapping("/addcourse")
    public String addCourse(@Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseService.createCourse(course);
        model.addAttribute("courses", courseService.findAllCourses());

        logger.info("création du cours : {}", course);

        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showUpdateCourseForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("course", courseService.findCourseById(id).get());
        return "update-course";
    }

    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setId(id);
            return "update-course";
        }
        courseService.updateCourse(course);
        model.addAttribute("courses", courseService.findAllCourses());

        logger.info("mise à jour du cours : {}", course);

        return "redirect:/index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id, Model model) {
        courseService.deleteCourseById(id);
        model.addAttribute("courses", courseService.findAllCourses());

        logger.info("suppression du cours : {}", id);

        return "redirect:/index";
    }
}
