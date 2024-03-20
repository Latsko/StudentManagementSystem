package latsko.sms.controller;

import jakarta.validation.Valid;
import latsko.sms.dto.StudentDTO;
import latsko.sms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String saveStudent(@Valid @ModelAttribute("student") StudentDTO studentDTO,
                              BindingResult result,
                              Model model) {
        if(result.hasErrors()) {
            model.addAttribute("student", studentDTO);
            return "create_student";
        }
        studentService.saveStudent(studentDTO);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long id,
                              Model model) {
        StudentDTO student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long id,
                                @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult result,
                                Model model) {
        studentDTO.setId(id);
        if(result.hasErrors()) {
            model.addAttribute("student", studentDTO);
            return "edit_student";
        }
        studentService.updateStudent(id, studentDTO);
        return "redirect:/students";
    }
}
