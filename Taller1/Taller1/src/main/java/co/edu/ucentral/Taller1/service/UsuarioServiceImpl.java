package co.edu.ucentral.Taller1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.ucentral.Taller1.model.Usuario;

import co.edu.ucentral.Taller1.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Override
	public List<Usuario> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		repository.save(usuario);

	}

	@Override
	public Usuario buscarUsuarioPorUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) {
		Optional<Usuario> optional = repository.findById(id);
		if(optional.isPresent())
			return optional.get();

		return null;
	}

	@Override
	public void eliminarUsuario(Long id) {
		repository.deleteById(id);

	}

}