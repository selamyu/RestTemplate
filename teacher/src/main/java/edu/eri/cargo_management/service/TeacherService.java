package edu.eri.cargo_management.service;

import edu.eri.cargo_management.VO.Department;
import edu.eri.cargo_management.VO.ResponseTemplateVO;
import edu.eri.cargo_management.entity.Teacher;
import edu.eri.cargo_management.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final RestTemplate restTemplate;

    public Teacher saveUser(Teacher teacher) {
        log.info("Inside saveTeacherTeacherService");
        return teacherRepository.save(teacher);
    }
    public ResponseTemplateVO getTeacherWithDepartment(Long teacherId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);

        Department department =
                restTemplate.getForObject("http://localhost:5010/departments/" + teacher.getDepartmentId()
                        ,Department.class);

        vo.setTeacher(teacher);
        vo.setDepartment(department);

        return  vo; //DEPARTMENT-SERVICE
    }
}
