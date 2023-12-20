package m2i.projet.JEE_REST.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmpruntKey {

	@Column(name = "id_emprunteur")
	private Integer idEmprunteur;
	
	@Column(name = "id_exemplaireEmprunte")
	private Integer idExemplaireEmprunte;

	public Integer getIdEmprunteur() {
		return idEmprunteur;
	}

	public void setIdEmprunteur(Integer idEmprunteur) {
		this.idEmprunteur = idEmprunteur;
	}

	public Integer getIdExemplaireEmprunte() {
		return idExemplaireEmprunte;
	}

	public void setIdExemplaireEmprunte(Integer idExemplaireEmprunte) {
		this.idExemplaireEmprunte = idExemplaireEmprunte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEmprunteur, idExemplaireEmprunte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmpruntKey)) {
			return false;
		}
		EmpruntKey other = (EmpruntKey) obj;
		return Objects.equals(idEmprunteur, other.idEmprunteur)
				&& Objects.equals(idExemplaireEmprunte, other.idExemplaireEmprunte);
	}
	
}
