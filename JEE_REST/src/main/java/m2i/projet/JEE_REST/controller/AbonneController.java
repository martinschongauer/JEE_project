package m2i.projet.JEE_REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.projet.JEE_REST.dto.UtilisateurDTO;
import m2i.projet.JEE_REST.service.imp.UtilisateurServiceImp;

@RestController
@RequestMapping("/api-abonne")
public class AbonneController {

	@Autowired
	UtilisateurServiceImp userService;
	
	/** MAJ des informations d'un client **/
	@PutMapping("update")
	public void userService(@RequestBody UtilisateurDTO userDTO, Integer id) {
		userService.updateUser(userDTO, id );
	}
		
	/** MAJ des informations d'un client **/
	@GetMapping("seeProfil")
	public UtilisateurDTO seeProfil(String mail) {
		return userService.getUserDTO(mail);
	}
}
