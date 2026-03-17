package com.nt.service.impl;

import com.nt.dto.AddStudentRequestDto;
import com.nt.dto.StudentDto;
import com.nt.entity.Student;
import com.nt.repository.StudentRepository;
import com.nt.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl  implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students= studentRepository.findAll();

        List<StudentDto> studentList=students.stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();

        return studentList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("student not found with this id"));
        StudentDto studentDto= modelMapper.map(student,StudentDto.class);
        return studentDto;
    }

    @Override
    public StudentDto createStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent= modelMapper.map(addStudentRequestDto,Student.class);

        Student student= studentRepository.save(newStudent);

        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void removeStudent(Long id) {

        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("no such student found");
        }
        studentRepository.deleteById(id);

//        Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("enter a valid id!!"));
//        studentRepository.deleteById(id);
//
//         return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with this id"));
        modelMapper.map(addStudentRequestDto,student);
        student=studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with this id"));

        updates.forEach((field,value)->{
            switch (field){
                case "name"-> student.setName((String) value);
                case "email"-> student.setEmail((String) value);
                default-> throw new IllegalArgumentException("feild is not supported");
            }
        });
       Student savedStudent=studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }

    //AScending sort by name
    Sort sort= Sort.by(Sort.Direction.ASC,"name");
    // descending sort on multiple props..
    Sort sort2= Sort.by(Sort.Direction.DESC,"name","email");
    @Override
    public List<StudentDto> showStudentsBySorting(boolean asc, String... props) {

        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, props);

        return studentRepository.findAll(sort)
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }
}
