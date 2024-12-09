package com.generation.devfit.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
 
import com.generation.devfit.model.Exercicio;
 
public interface ExercicioRepository extends JpaRepository<Exercicio,Long>{
	
	public List<Exercicio> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);
}