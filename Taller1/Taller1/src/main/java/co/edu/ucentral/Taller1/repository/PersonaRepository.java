package co.edu.ucentral.Taller1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.Taller1.model.Persona;
import co.edu.ucentral.Taller1.model.TipoPersona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	
	public List<Persona> findByTipoPersona(TipoPersona tipoPersona);
}