package net.javaguides.sprintboot_rest_api.controller;
import net.javaguides.sprintboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("students") // To define base url
public class StudentController {
    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Belvi",
                "Pachinco"
        );
        // return new ResponseEntity<>(student, HttpStatus.OK);
        // return ResponseEntity.ok(student);
        //  Add header method
        return ResponseEntity.ok().
                header("custom header", "Pouadjeu").
                body(student);
    }
    // Return a list of students
    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Yapo", "Zogo"));
        students.add(new Student(2, "Pouqdjeu", "Belvinard"));
        students.add(new Student(3, "Tchinda", "Rodrigue"));
        students.add(new Student(4, "Touko", "Pierre"));
        students.add(new Student(5, "Chuanga", "Felicien"));
        // return students;
        return ResponseEntity.ok(students);
    }
    // Spring Boot rest API with path Variable
    // `{id}` is called URI template variable
    // http://localhost:8080/students/2/Pouadjeu/Belvinard
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        //return  new Student(studentId, "Belvi", "Pouadjeu");
        // return new Student(studentId, firstName, lastName);
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }
    // Spring boot REST API with @RequestParam                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 uest Param
    // http://localhost:8080/students/query?id=2&firstName=Pouadjeu&lastName=Belvinard
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        // return new Student(id, firstName, lastName);
        // It returned ResponseEntity object
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }
    // Spring boot rest api that handles http post request
    // @PostMapping and @RequestBody annotation
    // http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // Spring boot rest API that handles HTTP PUT Request - updating existing resources
    // http://localhost:8080/students/{id}/update
    @PutMapping("{id}/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
    // Spring boot rest API that handles HTTP DELETE Request - deleting existing resources
    // http://localhost:8080/students/{id}/delete
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "Student deleted successfully!!";
    }
}