package dev.paie.entite;

public class Utilisateur {
	
	public enum ROLES {
	ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}
	
	private Integer id;
	private String nomUtilisateur;
	private String motDePasse;
	private Boolean estActif;
	private ROLES role;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getEstActif() {
		return estActif;
	}
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}
	public ROLES getRole() {
		return role;
	}
	public void setRole(ROLES role) {
		this.role = role;
	}
}