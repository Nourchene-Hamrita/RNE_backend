package com.RNE.referentiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.referentiel.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
