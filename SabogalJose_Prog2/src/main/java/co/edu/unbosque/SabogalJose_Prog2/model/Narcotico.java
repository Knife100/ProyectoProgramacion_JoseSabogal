package co.edu.unbosque.SabogalJose_Prog2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Narcotico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String tipo;
	private double peso;

	public Narcotico() {
	}

	public Narcotico(String tipo, double peso) {
		this.tipo = tipo;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
