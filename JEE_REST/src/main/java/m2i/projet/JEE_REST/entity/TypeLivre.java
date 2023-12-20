package m2i.projet.JEE_REST.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeLivre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idType;
	@Column(nullable = false)
	private String nomType;
	
	public String getNomType() {
		return nomType;
	}
	public void setNomType(String nomType) {
		this.nomType = nomType;
	}
	
	public Integer getIdType() {
		return idType;
	}
	
	public TypeLivre() {
		super();
	}
	
	public TypeLivre(String nomType) {
		super();
		this.nomType = nomType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idType, nomType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TypeLivre)) {
			return false;
		}
		TypeLivre other = (TypeLivre) obj;
		return Objects.equals(idType, other.idType) && Objects.equals(nomType, other.nomType);
	}
	
	@Override
	public String toString() {
		return "TypeLivre [idType=" + idType + ", nomType=" + nomType + "]";
	}

}
