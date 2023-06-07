package co.edu.unbosque.SabogalJose_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.SabogalJose_Prog2.model.Policia;

public interface PoliciaRepository extends CrudRepository<Policia, Integer> {

	public Optional<Policia> findById(Integer id);

	public List<Policia> findAll();

	List<Policia> findByNombre(String nombre);

	List<Policia> findAllByNombre(String nombre);

}
