package co.edu.unbosque.SabogalJose_Prog2.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Redada {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDate fechaEjecucion;
	private LocalTime horaInicio;
	private LocalTime horaFinal;
	private int cantidadCapturados;
	private String narcotico;
	private double peso;

	@ElementCollection
	@OneToMany(fetch = FetchType.EAGER)
	private List<Policia> nombresPolicias = new ArrayList<>(); // Inicializar la lista

	public Redada() {
		// TODO Auto-generated constructor stub
	}

	public Redada(Integer id, LocalDate fechaEjecucion, LocalTime horaInicio, LocalTime horaFinal,
			int cantidadCapturados, String narcotico, double peso, List<Policia> nombresPolicias) {
		super();
		this.id = id;
		this.fechaEjecucion = fechaEjecucion;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.cantidadCapturados = cantidadCapturados;
		this.narcotico = narcotico;
		this.peso = peso;
		this.nombresPolicias = nombresPolicias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(LocalDate fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getCantidadCapturados() {
		return cantidadCapturados;
	}

	public void setCantidadCapturados(int cantidadCapturados) {
		this.cantidadCapturados = cantidadCapturados;
	}

	public String getNarcotico() {
		return narcotico;
	}

	public void setNarcotico(String narcotico) {
		this.narcotico = narcotico;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public List<Policia> getNombresPolicias() {
		return nombresPolicias;
	}

	public void setNombresPolicias(List<Policia> nombresPolicias) {
		this.nombresPolicias = nombresPolicias;
	}

}