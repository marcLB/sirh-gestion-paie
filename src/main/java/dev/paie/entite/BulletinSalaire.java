package dev.paie.entite;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bulletinSalaire")
public class BulletinSalaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	private Periode periode;
	
	@Column(name="primeExceptionnelle")
	private BigDecimal primeExceptionnelle;
	
	
	
	
	public BulletinSalaire() {
		super();
	}

	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	//GETTERS AND SETTERS
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

}
