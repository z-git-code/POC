package com.demo.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.poc.model.Professor;
import com.demo.poc.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public List<Professor> getAllProfessors() {
		return professorRepository.findAll();
	}

	@Override
	public void saveProfessor(Professor professor) {
		this.professorRepository.save(professor);

	}

	@Override
	public Professor getProfessorById(long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		Professor professor = null;
		if (optional.isPresent()) {
			professor = optional.get();
		} else {
			throw new RuntimeException("Invalid Professor id : " + id);
		}
		return professor;
	}

	@Override
	public void deleteProfessorById(long id) {
		this.professorRepository.deleteById(id);

	}

	@Override
	public Page<Professor> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.professorRepository.findAll(pageable);
	}

}
