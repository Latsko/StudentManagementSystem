package latsko.sms.controller;

import latsko.sms.dto.StudentDTO;
import latsko.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudent(Model model) {
        StudentDTO studentDTO = new StudentDTO();
        model.addAttribute("student", studentDTO);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO) {
        studentService.saveStudent(studentDTO);
        return "redirect:/students";
    }
}
