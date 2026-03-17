package com.nt.service;

import com.nt.dto.AddStudentRequestDto;
import com.nt.dto.StudentDto;
import com.nt.entity.Student;
import org.jspecify.annotations.Nullable;

import java.net.URI;
import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
    StudentDto createStudent(AddStudentRequestDto addStudentRequestDto);

    void removeStudent(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);

    public List<StudentDto> showStudentsBySorting(boolean asc, String... props) ;
}
