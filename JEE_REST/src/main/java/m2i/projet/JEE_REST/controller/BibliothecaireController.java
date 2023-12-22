package m2i.projet.JEE_REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import m2i.projet.JEE_REST.dto.EmpruntDateDTO;
import m2i.projet.JEE_REST.service.EmpruntService;
@RestController
@RequestMapping("/lagrandelibrairie/admin/")
public class BibliothecaireController {
	
	@Autowired
	EmpruntService empruntService;
	
	@GetMapping("/emprunts")
	public String displayEmprunts(HttpServletRequest request) {
		String parametre = request.getParameter("filter");
		return empruntService.findAllWithFilter(parametre).toString();
	}
	
	@PatchMapping("/emprunts/{id}")
	public String ValidateEmprunts(@PathVariable("id") Integer idEmprunt) {
		empruntService.validateEmprunt(idEmprunt);
		return "L'emprunt n° "+idEmprunt+" a été validé";
	}
	@PutMapping("/emprunts/{id}")
	public String UpdateEmprunts(@PathVariable("id") Integer idEmprunt, @RequestBody EmpruntDateDTO dateEmprunt) {
		empruntService.updateEmprunt(idEmprunt, dateEmprunt);
		return "L'emprunt n° "+idEmprunt+" a été mis à jour";
	}
	@DeleteMapping("/emprunts/{id}")
	public String deleteEmprunt(@PathVariable("id") Integer idEmprunt) {
		empruntService.delete(idEmprunt);
		return "L'emprunt du livre n°"+ idEmprunt + "a bien été supprimé";
	}
}
