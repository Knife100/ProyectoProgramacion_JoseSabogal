package co.edu.unbosque.SabogalJose_Prog2.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Policia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private int edad;
    private LocalDate entrada;
    private String rango;
    private int redadas;

    public Policia() {
    }

    public Policia(String nombre, int edad, LocalDate entrada, String rango, int redadas) {
        this.nombre = nombre;
        this.edad = edad;
        this.entrada = entrada;
        this.rango = rango;
        this.redadas = redadas;
    }

    // Incrementa el contador de redadas
    public void incrementarRedadas() {
        this.redadas++;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getRedadas() {
		return redadas;
	}

	public void setRedadas(int redadas) {
		this.redadas = redadas;
	}

}
