package org.weblioteca.application.controller;

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
import org.weblioteca.application.model.Editora;
import org.weblioteca.application.model.Autor;
import org.weblioteca.application.model.Livro;
import org.weblioteca.application.repository.AutorRepository;
import org.weblioteca.application.repository.EditoraRepository;
import org.weblioteca.application.service.EditoraService;
import org.weblioteca.application.service.LivroService;
import org.weblioteca.application.service.AutorService;

@Controller
public class LivroController {
	

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private EditoraRepository editoraRepository;
	@Autowired
	LivroService livroService;
	@Autowired
	EditoraService editoraService;
	@Autowired
	AutorService autorService;
	
	@GetMapping("/indexLivro")
	public String viewHomePage(Model model) {
		return livrosPaginacao(1, "tituloLivro", "asc", model);
	}
	
	@GetMapping("/novoLivro") 
	public String novoLivro(Model model) {
		Livro livro = new Livro();
		model.addAttribute("livro", livro);
		List<Autor> listAutor = autorRepository.findAll();
	    model.addAttribute("listAutor", listAutor);
		List<Editora> listEditora = editoraRepository.findAll();
	    model.addAttribute("listEditora", listEditora);
		
		return "salvarLivro";
	}
	
	@PostMapping("/salvarLivro")
	public String salvarLivro(@ModelAttribute("livro") Livro livro) {
		if (livro.getTituloLivro() == "") {
			if (livro.getLivroId() != null)
				return "redirect:/atualizarLivro/"+livro.getLivroId();
			else
				return "salvarLivro";	
		}else {
			livroService.salvarLivro(livro);
<<<<<<< HEAD
			return "redirect:/indexLivro";
=======
			return "redirect:/livro";
>>>>>>> cd6d175aa3a21b3c0f7ecbe93435f80725cdac57
		}
	}	
	
	@GetMapping("/atualizarLivro/{id}")
	public String atualizarLivro(@PathVariable ( value = "id") Long id, Model model) {
		Livro livro = livroService.getLivroById(id);
		model.addAttribute("livro", livro);
		List<Autor> listAutor = autorRepository.findAll();
	    model.addAttribute("listAutor", listAutor);
		List<Editora> listEditora = editoraRepository.findAll();
	    model.addAttribute("listEditora", listEditora);
	    
		return "atualizarLivro";
	}
	
	@GetMapping("/deletarLivro/{id}")
	public String deletarLivro(@PathVariable (value = "id") Long id) {
		livroService.deletarLivroById(id);
		return "redirect:/indexLivro";
	}
	
	@GetMapping("/pageLivro/{pageNo}")
	public String livrosPaginacao(@PathVariable (value = "pageNo") int pageNoLivro, 
			                        @RequestParam("sortField") String sortFieldLivro,
		                        	@RequestParam("sortDir") String sortDirLivro,
		                         	Model model) {
		int pageSizeLivro = 5;
		
		Page<Livro> pageLivro = livroService.findPaginated(pageNoLivro, pageSizeLivro, sortFieldLivro, sortDirLivro);
		List<Livro> listaLivros = pageLivro.getContent();
		
		model.addAttribute("currentPage", pageNoLivro);
		model.addAttribute("totalPages", pageLivro.getTotalPages());
		model.addAttribute("totalItems", pageLivro.getTotalElements());
		
		model.addAttribute("sortField", sortFieldLivro);
		model.addAttribute("sortDir", sortDirLivro);
		model.addAttribute("reverseSortDir", sortDirLivro.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listaLivros", listaLivros);
		return "indexLivro";
	}
}
