package m2i.projet.JEE_REST.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Livre {

	@Id
	@Column(nullable = false, unique = true)
	private Integer isbnLivre;
	@Column(nullable = false)
	private Integer idTypeLivre;
	@Column(nullable = false)
	private String titreLivre;
	@Column(nullable = false)
	private String auteur;
	@Column(nullable = false)
	private String editeur;
	
	@JsonIgnoreProperties
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	private TypeLivre typelivre;
	
	
}
