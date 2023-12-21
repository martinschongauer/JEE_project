package m2i.projet.JEE_REST.dto;

import jakarta.validation.constraints.NotNull;

public class TypeLivreDTO {
	
	@NotNull (message = "Le type de livre est obligatoire")
	private String nomType;
	
	public TypeLivreDTO() {
	}
	
	public TypeLivreDTO(String nomType) {
		this.nomType = nomType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

}
