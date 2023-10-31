package edu.eri.cargo_management.controller;

import edu.eri.cargo_management.VO.ResponseTemplateVO;
import edu.eri.cargo_management.entity.Teacher;
import edu.eri.cargo_management.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
@Slf4j
@RequiredArgsConstructor
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;
    @PostMapping("/")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        log.info("Inside saveTeacher of TeacherController");
        return teacherService.saveUser(teacher);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getTeacherWithDepartment(@PathVariable("id") Long teacherId) {
        log.info("Inside getTeacherWithDepartment of TeacherController");
        return teacherService.getTeacherWithDepartment(teacherId);
    }
}