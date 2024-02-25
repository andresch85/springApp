package co.edu.ucentral.Taller1.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ucentral.Taller1.model.Role;
import co.edu.ucentral.Taller1.model.Usuario;
import co.edu.ucentral.Taller1.service.RoleService;
import co.edu.ucentral.Taller1.service.UsuarioService;


@Controller
@RequestMapping(value="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	
	@GetMapping("/index")
	public String listar(Model model) {
		model.addAttribute("usuarios", usuarioService.listar());
		return "usuarios/index";
	}
	@GetMapping("/crear")
	public String crear(Usuario usuario,Model model) {
		List<Role> roles = roleService.listar();
		model.addAttribute("roles", roles);
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(@Valid Usuario usuario,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "usuarios/formUsuario"; 
		}
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarUsuario(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(id);
		model.addAttribute("usuario", usuario);
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios/index";
	}

	@ModelAttribute("roles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}
}