package co.edu.unbosque.SabogalJose_Prog2.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.SabogalJose_Prog2.model.Narcotico;
import co.edu.unbosque.SabogalJose_Prog2.model.Policia;
import co.edu.unbosque.SabogalJose_Prog2.model.Redada;
import co.edu.unbosque.SabogalJose_Prog2.repository.NarcoticoRepository;
import co.edu.unbosque.SabogalJose_Prog2.repository.PoliciaRepository;
import co.edu.unbosque.SabogalJose_Prog2.repository.RedadaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/joseapi")

public class RedadaController {

	@Autowired
	private RedadaRepository redares;
	@Autowired
	private PoliciaRepository polires;

	@PostMapping("/redada")
	public ResponseEntity<String> agregarRedada(@RequestParam String fechaEjecucion, @RequestParam String horaInicio,
			@RequestParam String horaFinal, @RequestParam int cantidadCapturados, @RequestParam String tipo,
			@RequestParam double peso, @RequestParam ArrayList<String> nombresPolicias) {

		Redada redada = new Redada();

		DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

		try {
			LocalDate fechaEjecucionParsed = LocalDate.parse(fechaEjecucion, fechaFormatter);
			LocalTime horaInicioParsed = LocalTime.parse(horaInicio, horaFormatter);
			LocalTime horaFinalParsed = LocalTime.parse(horaFinal, horaFormatter);

			redada.setFechaEjecucion(fechaEjecucionParsed);
			redada.setHoraInicio(horaInicioParsed);
			redada.setHoraFinal(horaFinalParsed);
			redada.setCantidadCapturados(cantidadCapturados);
			redada.setNarcotico(tipo);
			redada.setPeso(peso);

			List<Policia> policias = nombresPolicias.stream().map(nombre -> {
				List<Policia> existentes = polires.findAllByNombre(nombre);
				if (!existentes.isEmpty()) {

					return existentes.get(0);
				}
				throw new RuntimeException("El policía '" + nombre + "' no existe.");
			}).collect(Collectors.toList());
			redada.setNombresPolicias(policias);
			for (Policia policia : policias) {
				policia.setRedadas(policia.getRedadas() + 1);
				polires.save(policia);
			}
			redares.save(redada);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada creada con éxito: 201");
		} catch (DateTimeParseException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al convertir las fechas y horas.");
		}
	}

	@GetMapping("/redada")
	public ResponseEntity<List<Redada>> mostrarTodo() {
		List<Redada> lista = redares.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(lista);
	}

	@DeleteMapping("/redada/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Optional<Redada> redadaExistente = redares.findById(id);

		if (redadaExistente.isPresent()) {
			Redada redada = redadaExistente.get();

			redares.delete(redada);

			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada " + id + " eliminada con éxito");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No se encontró la redada con el ID" + id + " proporcionado");
		}
	}

	@PutMapping("/redada/{id}")
	public ResponseEntity<String> actualizarRedada(@PathVariable Integer id, @RequestParam String fechaEjecucion,
			@RequestParam String horaInicio, @RequestParam String horaFinal, @RequestParam int cantidadCapturados,
			@RequestParam String tipo, @RequestParam double peso, @RequestParam ArrayList<String> nombresPolicias) {
		Optional<Redada> redadaExistente = redares.findById(id);

		if (redadaExistente.isPresent()) {
			Redada redada = redadaExistente.get();

			DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

			LocalDate fechaEjecucionPar = LocalDate.parse(fechaEjecucion, fechaFormatter);
			LocalTime horaInicioPar = LocalTime.parse(horaInicio, horaFormatter);
			LocalTime horaFinalPar = LocalTime.parse(horaFinal, horaFormatter);

			redada.setFechaEjecucion(fechaEjecucionPar);
			redada.setHoraInicio(horaInicioPar);
			redada.setHoraFinal(horaFinalPar);
			redada.setCantidadCapturados(cantidadCapturados);
			redada.setNarcotico(tipo);
			redada.setPeso(peso);

			List<Policia> policias = nombresPolicias.stream().map(nombre -> {
				List<Policia> existentes = polires.findAllByNombre(nombre);
				if (!existentes.isEmpty()) {

					return existentes.get(0);
				}
				throw new RuntimeException("El policía '" + nombre + "' no existe.");
			}).collect(Collectors.toList());
			redada.setNombresPolicias(policias);
			redares.save(redada);

			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Redada actualizada con éxito");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la redada con el ID proporcionado");
		}
	}
}