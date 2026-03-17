package com.nt.controller;

import com.nt.dto.AddStudentRequestDto;
import com.nt.dto.StudentDto;
import com.nt.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>>
    getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                        .body(studentService.getStudentById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(addStudentRequestDto));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.removeStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }

    @GetMapping("/sort")
    public List<StudentDto> getSortedStudents(@RequestParam(name="sort") String[] props, @RequestParam(defaultValue = "true") boolean asc){
        return studentService.showStudentsBySorting(asc,props);
    }
}
