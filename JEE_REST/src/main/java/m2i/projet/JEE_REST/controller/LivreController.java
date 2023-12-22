package m2i.projet.JEE_REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import m2i.projet.JEE_REST.dto.LivreDTO;
import m2i.projet.JEE_REST.service.LivreService;

@RestController
@RequestMapping("/api-livres")
public class LivreController {

	@Autowired
	LivreService livreService;

	
	@GetMapping("livres_filtered")
	public List<LivreDTO> getLivreListFilter(@RequestParam("filter_titre")String filt_titre,
										@RequestParam("filter_auteur")String filt_auteur,
										@RequestParam("filter_editeur")String filt_editeur) 
	{
		return livreService.findAll(filt_titre, filt_auteur, filt_editeur);
	}

	
	@GetMapping("livre/{ISBN}")
	public LivreDTO getLivre(@PathVariable("ISBN") String ISBN) {
		return livreService.findByISBN(ISBN);
	}
	
	
	@DeleteMapping("delete/{ISBN}")
	public void deleteLivre(@PathVariable("ISBN") String ISBN) {
		livreService.delete(ISBN);
		return;
	}
	
	
	@PostMapping("add")
	public LivreDTO addLivre(@Valid @RequestBody LivreDTO request) {
		// Return the object just created as a proof that everything is OK
		return livreService.add(request); 
	}
	
	
	@PutMapping("update/{ISBN}")
	public LivreDTO updateClient(@PathVariable("ISBN") String ISBN, @Valid @RequestBody LivreDTO request) {
		
		return livreService.update(ISBN, request);
	}
	
}
