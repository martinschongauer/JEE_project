package m2i.projet.JEE_REST.controller;

import java.util.List;
import java.util.Optional;

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
import m2i.projet.JEE_REST.dto.ExemplaireDTO;
import m2i.projet.JEE_REST.entity.Exemplaire;
import m2i.projet.JEE_REST.service.ExemplaireService;

@RestController
@RequestMapping("/api-exemplaires")
public class ControllerExemplaires {
	@Autowired
	ExemplaireService exemplaireService;

	//Ajout d'un exemplaire lié à un ISBN
	@PostMapping("exemplaire/add")
	public void addExemplaire(@Valid @RequestBody ExemplaireDTO request) {
		Exemplaire exemplaire = new Exemplaire();
		exemplaire.setIsbnLivre(request.getIsbnLivre());
		exemplaire.setIntegriteLivre(request.getIntegriteLivre());
		exemplaireService.save(exemplaire);
	}

	//Suppression d'un exemplaire lié à son ID
	@DeleteMapping("exemplaire/delete/{id}")
	public void deleteExemplaire(@PathVariable("id") Integer id) {
		exemplaireService.deleteById(id);
	}

	//Afficher un exemplaire selon son ID
	@GetMapping("exemplaire/{id}")
	public Exemplaire getById(Integer id) {
		ExemplaireDTO exemplaireDTO = exemplaireService.findById(id);
		Exemplaire exemplaire = new Exemplaire(exemplaireDTO.getIsbnLivre(), exemplaireDTO.getIntegriteLivre());
		return exemplaire;	
	}

	//Afficher la liste complète des exemplaires (tout livre confondu)
	@GetMapping("exemplaires/liste")
	public List<Exemplaire> getExemplairesList () {
		return exemplaireService.findAll();
	}

	//Afficher la liste des exemplaires disponibles selon l'isbn
	@GetMapping("{isbn}/exemplaires/disponibles")
	public List<Exemplaire> findExemplairesDisponibles(@PathVariable("isbn")String isbn) {
		return exemplaireService.findExemplairesDisponibles(isbn);
	}

	//Afficher la liste des exemplaires indisponibles selon l'isbn
	@GetMapping("{isbn}/exemplaires/indisponibles")
	public List<Exemplaire> findExemplairesIndisponibles(@PathVariable("isbn")String isbn) {
		return exemplaireService.findExemplairesIndisponibles(isbn);
	}

	//Nombre total d'exemplaires pour un livre
	@GetMapping("{isbn}/exemplaires/liste/total")
	public int countByIsbnLivre(String isbn) {
		return exemplaireService.countByIsbnLivre(isbn);
	}

	//Nombre d'exemplaires disponibles pour un livre
	@GetMapping("{isbn}/exemplaires/disponibles/total")
	public int countExemplairesDisponibles(String isbn) {
		return exemplaireService.countExemplairesDisponibles(isbn);
	}

	//Nombre d'exemplaires indisponibles pour un livre
	@GetMapping("{isbn}/exemplaires/indisponibles/total")
	public int countExemplairesIndisponibles(String isbn) {
		return exemplaireService.countExemplairesIndisponibles(isbn);
	}


	@PutMapping("exemplaire/update/{id}")
	public void updateExemplaire (@RequestBody ExemplaireDTO exemplaireDTO, @PathVariable("id")Integer id) {
		exemplaireService.updateExemplaire(exemplaireDTO, id);
	}
}
