package co.edu.ucentral.Taller1.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.Taller1.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	
	public Usuario findByUsername(String username);
	
	

}
