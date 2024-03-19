package latsko.sms.service;

import latsko.sms.dto.StudentDTO;
import latsko.sms.entity.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
}
