package m2i.projet.JEE_REST.dto;

import jakarta.validation.constraints.NotNull;

public class LivreDTO {
	
	private String titreLivre;
	private String auteur;
	private String editeur;
	private Integer idType; // previously : TypeLivre typeLivre;

	public LivreDTO() {
	}

	public LivreDTO(@NotNull (message = "Le titre du livre est obligatoire")String titreLivre, 
					@NotNull (message = "L'auteur du livre est obligatoire")String auteur,
					@NotNull (message = "L'éditeur livre est obligatoire")String editeur, 
					@NotNull (message = "Le type de livre est obligatoire")Integer idType) {
		this.titreLivre = titreLivre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.idType = idType;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public Integer getTypeLivre() {
		return idType;
	}

	public void setTypeLivre(Integer idType) {
		this.idType = idType;
	}

}
