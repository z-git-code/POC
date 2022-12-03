package com.demo.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.poc.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
