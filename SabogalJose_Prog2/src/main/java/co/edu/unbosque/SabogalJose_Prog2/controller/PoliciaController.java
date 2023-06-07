package co.edu.unbosque.SabogalJose_Prog2.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

import co.edu.unbosque.SabogalJose_Prog2.model.Policia;
import co.edu.unbosque.SabogalJose_Prog2.repository.PoliciaRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/joseapi")

public class PoliciaController {

	@Autowired
	private PoliciaRepository polires;

	@PostMapping("/policia")
	public ResponseEntity<String> agregar(@RequestParam String nombre, @RequestParam int edad,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entrada, @RequestParam String rango) {

		Policia temp = new Policia();
		temp.setNombre(nombre);
		temp.setEdad(edad);
		temp.setEntrada(entrada);
		temp.setRango(rango);
		temp.setRedadas(0);

		polires.save(temp);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policia: " + nombre + " creado con exito: 201");

	}

	@GetMapping("/policia")
	public ResponseEntity<List<Policia>> mostrarTodo() {

		List<Policia> lista = polires.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lista);
	}

	@DeleteMapping("/policia/{id}")
	public ResponseEntity<String> eliminarPolicia(@PathVariable Integer id) {
	    Optional<Policia> policiaExistente = polires.findById(id);
	    
	    if (policiaExistente.isPresent()) {
	        Policia policia = policiaExistente.get();
	        
	        polires.delete(policia);
	        
	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policía" + id  + " eliminado con éxito");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el policía con el ID " + id +" proporcionado");
	    }
	}


	@PutMapping("/policia/{id}")
	public ResponseEntity<String> actualizarPolicia(@PathVariable Integer id, @RequestParam String nombre,
	        @RequestParam int edad, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate entrada,
	        @RequestParam String rango, @RequestParam int redadas) {
	    Optional<Policia> policiaExistente = polires.findById(id);

	    if (policiaExistente.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Policía no encontrado");
	    }

	    Policia policia = policiaExistente.get();
	    policia.setNombre(nombre);
	    policia.setEdad(edad);
	    policia.setEntrada(entrada);
	    policia.setRango(rango);
	    policia.setRedadas(redadas);

	    polires.save(policia);
	    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policía " + nombre + " actualizado con éxito");
	}

}
