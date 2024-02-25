package co.edu.ucentral.Taller1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.Taller1.model.Persona;
import co.edu.ucentral.Taller1.model.TipoPersona;
import co.edu.ucentral.Taller1.repository.PersonaRepository;

@Service
//@Primary
public class PersonaServiceImpl implements PersonaService {

	@Autowired	
	private PersonaRepository repository;
	
	@Override
	public List<Persona> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarPersona(Persona persona) {
		repository.save(persona);
	}

	@Override
	public Persona buscarPersonaPorId(Long id) {
		Optional<Persona> optional = repository.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public void eliminarPersona(Long id) {
		repository.deleteById(id);

	}

	@Override
	public List<Persona> buscarPersonaPorTipo(TipoPersona tipoPersona) {
		return repository.findByTipoPersona(tipoPersona);
		
	}

}
