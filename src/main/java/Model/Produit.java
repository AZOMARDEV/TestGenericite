package Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long id;
	String nom;
	String marque;
	Double prix;
	String description;
	Integer nbstock;

	public Produit(@JsonProperty("id") Long id, @JsonProperty("nom") String nom, @JsonProperty("marque") String marque,
			@JsonProperty("prix") Double prix, @JsonProperty("description") String description,
			@JsonProperty("nbstock") Integer nbstock) {
		super();
		this.id = id;
		this.nom = nom;
		this.marque = marque;
		this.prix = prix;
		this.description = description;
		this.nbstock = nbstock;
	}

	public Produit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNbstock() {
		return nbstock;
	}

	public void setNbstock(Integer nbstock) {
		this.nbstock = nbstock;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", marque=" + marque + ", prix=" + prix + ", description="
				+ description + ", nbstock=" + nbstock + "]";
	}

}
