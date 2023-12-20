package m2i.projet.JEE_REST.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprunt {

	@EmbeddedId
	EmpruntKey id;
	private LocalDate dateDebut;
	private Integer dureeEmprunt;
	
	@JsonIgnoreProperties
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private Utilisateur utilisateur;
}
