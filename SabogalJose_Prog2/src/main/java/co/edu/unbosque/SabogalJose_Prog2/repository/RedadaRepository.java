package co.edu.unbosque.SabogalJose_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.SabogalJose_Prog2.model.Redada;

public interface RedadaRepository extends CrudRepository<Redada, Integer> {

	public Optional<Redada> findById(Integer id);

	public List<Redada> findAll();

}
