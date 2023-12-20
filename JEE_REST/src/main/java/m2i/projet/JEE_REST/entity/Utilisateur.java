package m2i.projet.JEE_REST.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUser;
	@Column(nullable = false)
	private String nomUser;
	@Column(nullable = false)
	private String prenomUser;
	@Column(nullable = false, unique = true)
	private String mailUser;
	@Column(nullable = false)
	private Integer roleUser;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
	private List<Emprunt> emprunts;

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getMailUser() {
		return mailUser;
	}

	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}

	public Integer getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(Integer roleUser) {
		this.roleUser = roleUser;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nomUser, String prenomUser, String mailUser, Integer roleUser) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.mailUser = mailUser;
		this.roleUser = roleUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emprunts, idUser, mailUser, nomUser, prenomUser, roleUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(emprunts, other.emprunts) && Objects.equals(idUser, other.idUser)
				&& Objects.equals(mailUser, other.mailUser) && Objects.equals(nomUser, other.nomUser)
				&& Objects.equals(prenomUser, other.prenomUser) && Objects.equals(roleUser, other.roleUser);
	}

	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", mailUser="
				+ mailUser + ", roleUser=" + roleUser /*+ ", emprunts=" + emprunts*/ + "]";
	}
	
}
