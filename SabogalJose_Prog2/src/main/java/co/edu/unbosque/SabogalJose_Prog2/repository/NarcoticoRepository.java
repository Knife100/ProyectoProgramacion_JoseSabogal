package co.edu.unbosque.SabogalJose_Prog2.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.SabogalJose_Prog2.model.Narcotico;

public interface NarcoticoRepository extends CrudRepository<Narcotico, Integer> {

	Narcotico findByTipo(String tipo);
}