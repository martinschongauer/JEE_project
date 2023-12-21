package m2i.projet.JEE_REST.dto;

import java.util.Objects;

import m2i.projet.JEE_REST.entity.Utilisateur;

public class UtilisateurDTO {
	private String nomUser;
	private String prenomUser;
	private String mailUser;
	private Integer roleUser;
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
	
	/**Constructeur d'utilisateurDTO par paramètres**/
	public UtilisateurDTO(String nomUser, String prenomUser, String mailUser, Integer roleUser) {
		super();
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.mailUser = mailUser;
		this.roleUser = roleUser;
	}
	/**Constructeur d'utilisateurDTO par defaut**/
	public UtilisateurDTO() {
	}
	/**Constructeur d'utilisateurDTO par un utilisateur**/
	public UtilisateurDTO(Utilisateur user) {
		this.nomUser = user.getNomUser();
		this.prenomUser = user.getPrenomUser();
		this.mailUser = user.getMailUser();
		this.roleUser = user.getRoleUser();
	}
	@Override
	public int hashCode() {
		return Objects.hash(mailUser, nomUser, prenomUser, roleUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilisateurDTO other = (UtilisateurDTO) obj;
		return Objects.equals(mailUser, other.mailUser) && Objects.equals(nomUser, other.nomUser)
				&& Objects.equals(prenomUser, other.prenomUser) && Objects.equals(roleUser, other.roleUser);
	}
	@Override
	public String toString() {
		return "UtilisateurDTO [nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", mailUser=" + mailUser
				+ ", roleUser=" + roleUser + "]";
	}
	
	
}
