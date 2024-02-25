package co.edu.ucentral.Taller1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ucentral.Taller1.model.Role;
import co.edu.ucentral.Taller1.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repository;
	
	@Override
	public List<Role> listar() {
		return repository.findAll();
	}

	@Override
	public void guardarRole(Role role) {
		repository.save(role);
	}

	@Override
	public Role buscarRolePorId(Long id) {
		Optional<Role> optional = repository.findById(id);
		if(optional.isPresent())
			return optional.get();

		return null;
	}

	@Override
	public void eliminarRole(Long id) {
		repository.deleteById(id);
	}

}