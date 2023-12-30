package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    //write a method for teachers and return list of teachers

    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        return teacherService.findAll();
    }
    /*  7MIN
        create an endpoint for students, where json response includes
        "students are successfully retrieved." message
        code:200
        success:true
        and student data
     */

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){

        return ResponseEntity.ok(new ResponseWrapper
                ("students are successfully retrieved."
                ,studentService.findAll()));
    }

}
