package latsko.sms.service;

import latsko.sms.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    void saveStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long id);

    void updateStudent(Long id, StudentDTO studentDTO);

    void deleteStudent(Long id);
}
