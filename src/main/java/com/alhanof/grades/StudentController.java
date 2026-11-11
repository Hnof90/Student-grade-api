package com.alhanof.grades;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController // this is the API controller
@RequestMapping("/api") //sets the base url path 

public class StudentController {
     static final Logger logger =
    LoggerFactory.getLogger(StudentController.class);


 private List<Student> students = new ArrayList<>(List.of(
 new Student(1L, "Ahmed", "SE4111", 90.0),
 new Student(2L, "Sara", "SE4111", 88.5)

 ));


@GetMapping("/students")// handle GET requests to /api/students (read data)
 public List<Student> getAll() {
 return students;
 }


 @GetMapping("/students/{id}")// handle GET requests to read student data by id
 public Student getById(@PathVariable Long id) {
 return students.stream()
 .filter(s -> s.getId().equals(id))
 .findFirst()
 .orElse(null);
 }

 @PostMapping("/students") //handle POST requests to /api/students (create new student)
 public Student add(@RequestBody Student s) {
 s.setId((long) (students.size() + 1));
 students.add(s);
 logger.info("Added student: id={}, name={}", s.getId(), s.getName());//log the addition of a new student
 return s;
 }


}