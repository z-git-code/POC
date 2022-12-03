package com.demo.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.poc.model.Professor;
import com.demo.poc.service.ProfessorService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/")
	public String visitHomePage(Model model) {
		System.out.println("visithomepage?");
		return findPaginated(1, "firstName", "asc", model);
//		model.addAttribute("listProfessors", professorService.getAllProfessors());
//		return "index";
	}

	@GetMapping("/addNewProfessorForm")
	public String addNewProfessorForm(Model model) {
		Professor professor = new Professor();
		model.addAttribute("professor", professor);
		return "new_professor";
	}

	@PostMapping("/saveProfessor")
	public String saveProfessor(@ModelAttribute("professor") Professor professor) {
		professorService.saveProfessor(professor);
		return "redirect:/";
	}

	@GetMapping("/updateProfessor/{id}")
	public String updateProfessor(@PathVariable(value = "id") long id, Model model) {
		Professor professor = professorService.getProfessorById(id);
		model.addAttribute("professor", professor);
		return "update_professor";
	}

	@GetMapping("/deleteProfessor/{id}")
	public String deleteProfessor(@PathVariable (value = "id") long id) {
		this.professorService.deleteProfessorById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
		// TODO Auto-generated method stub
		int pageSize = 5;
		
		Page<Professor> page = professorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Professor> listProfessors = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listProfessors", listProfessors);
//		System.out.println(">PageFunction?");
		return "index";
	}
}
