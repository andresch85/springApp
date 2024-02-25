package co.edu.ucentral.Taller1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.Taller1.model.TipoPersona;
import co.edu.ucentral.Taller1.repository.TipoPersonaRepository;

@Service
public class TipoPersonaServiceImpl implements TipoPersonaService {

	
	
	@Autowired
	private TipoPersonaRepository repository;
	@Override
	public List<TipoPersona> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarTipoPersona(TipoPersona tipoPersona) {
		repository.save(tipoPersona);
	}

	@Override
	public TipoPersona buscarTipoPersonaPorId(Long id) {
		Optional<TipoPersona> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminarTipoPersona(Long id) {
		repository.deleteById(id);

	}

}