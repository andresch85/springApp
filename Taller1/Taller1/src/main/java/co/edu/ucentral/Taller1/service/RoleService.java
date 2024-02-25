package co.edu.ucentral.Taller1.service;

import java.util.List;

import co.edu.ucentral.Taller1.model.Role;

public interface RoleService {
	public List<Role> listar();
	public void guardarRole(Role role);
	public Role buscarRolePorId(Long id);
	public void eliminarRole(Long id);
}
