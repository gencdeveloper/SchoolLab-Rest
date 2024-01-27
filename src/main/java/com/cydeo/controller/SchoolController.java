package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //this controller provides return apis
public class SchoolController {



    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService,StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    //Write a method for teachers and return list of teachers
    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(
                new ResponseWrapper("Students are successfully retrieved",
                        studentService.findAll()));
    }




}
