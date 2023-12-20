package m2i.projet.JEE_REST.entity;

import jakarta.persistence.Entity;

@Entity
public class Exemplaire {

	private Integer idExemplaire;
	private Integer isbnLivre;
	private String integriteLivre;
}
