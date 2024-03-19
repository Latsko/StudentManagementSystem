package latsko.sms.service.impl;

import latsko.sms.dto.StudentDTO;
import latsko.sms.entity.Student;
import latsko.sms.mapper.StudentMapper;
import latsko.sms.repository.StudentRepository;
import latsko.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::mapToStudentDto)
                .toList();
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        studentRepository.save(student);
    }
}
