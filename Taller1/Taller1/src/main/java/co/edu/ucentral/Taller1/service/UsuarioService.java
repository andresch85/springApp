package co.edu.ucentral.Taller1.service;

import java.util.List;

import co.edu.ucentral.Taller1.model.Usuario;



public interface UsuarioService {
	public List<Usuario> listar();
	public void guardarUsuario(Usuario usuario);
	public Usuario buscarUsuarioPorUsername(String username);
	public Usuario buscarUsuarioPorId(Long id);
	public void eliminarUsuario(Long id);

}
