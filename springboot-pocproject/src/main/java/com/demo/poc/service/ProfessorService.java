package com.demo.poc.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.demo.poc.model.Professor;

public interface ProfessorService {
	List<Professor> getAllProfessors();
	void saveProfessor(Professor professor);
	Professor getProfessorById(long id);
	void deleteProfessorById(long id);
	Page<Professor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
