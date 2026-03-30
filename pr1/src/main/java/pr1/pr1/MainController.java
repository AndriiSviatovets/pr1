package pr1.pr1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class MainController {
    
    private List<Student> students = new ArrayList<>();

    // Показати список студентів
    @GetMapping
    public String showStudents(Model model) {
        model.addAttribute("students", students);
        return "students";
    }

    // Показати форму додавання
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    // Обробка збереження нового студента
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        students.add(student);
        return "redirect:/students";
    }

    // Показати форму редагування для конкретного студента
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student studentToEdit = students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (studentToEdit != null) {
            model.addAttribute("student", studentToEdit);
            return "edit-student"; // Повертає новий шаблон
        }
        return "redirect:/students";
    }

    // Обробка збереження змін після редагування
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable String id, @ModelAttribute Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                updatedStudent.setId(id); // Зберігаємо оригінальний ID
                students.set(i, updatedStudent); // Замінюємо старий об'єкт новим
                break;
            }
        }
        return "redirect:/students";
    }

    // Видалення студента
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        students.removeIf(student -> student.getId().equals(id));
        return "redirect:/students";
    }
}