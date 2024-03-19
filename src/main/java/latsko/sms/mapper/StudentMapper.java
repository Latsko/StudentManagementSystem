package latsko.sms.mapper;

import latsko.sms.dto.StudentDTO;
import latsko.sms.entity.Student;

public class StudentMapper {
    public static StudentDTO mapToStudentDto(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail()
        );
    }
}
