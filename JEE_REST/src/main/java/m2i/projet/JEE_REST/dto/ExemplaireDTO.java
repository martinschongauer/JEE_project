package m2i.projet.JEE_REST.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ExemplaireDTO {

	@NotNull(message = "ISBN du livre obligatoire.")
	@Size(min = 10, max =13, message = "L'ISBN est constitué de 10 ou 13 chiffres.")
	private String isbnLivre;
	private String integriteLivre;
	
	//3 constructeurs : vide - isbnLivre - isbnLivre & integriteLivre
	public ExemplaireDTO() {
		super();
	}

	
	public ExemplaireDTO(String isbnLivre) {
		super();
		this.isbnLivre = isbnLivre;
	}


	public ExemplaireDTO(String isbnLivre, String integriteLivre) {
		super();
		this.isbnLivre = isbnLivre;
		this.integriteLivre = integriteLivre;
	}

	public String getIsbnLivre() {
		return isbnLivre;
	}

	public void setIsbnLivre(String isbnLivre) {
		this.isbnLivre = isbnLivre;
	}

	public String getIntegriteLivre() {
		return integriteLivre;
	}

	public void setIntegriteLivre(String integriteLivre) {
		this.integriteLivre = integriteLivre;
	}
	
	
}
