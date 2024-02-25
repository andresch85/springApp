package co.edu.ucentral.Taller1.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ucentral.Taller1.model.Persona;
import co.edu.ucentral.Taller1.model.TipoPersona;
import co.edu.ucentral.Taller1.service.PersonaService;
import co.edu.ucentral.Taller1.service.TipoPersonaService;

@Controller
@RequestMapping(value ="/personas")
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@Autowired
	private TipoPersonaService tipoPersonaService;
	
	@GetMapping("/index")
	public String listar(Model model) {
		List<Persona> lista = service.listar();
		model.addAttribute("personas", lista);
		return "personas/index";
	}
	
	@GetMapping("/crear")
	public String crearPersona(Persona persona, Model model) {
		List<TipoPersona> lista = tipoPersonaService.listar();
		model.addAttribute("tipoPersonas", lista);
		return "personas/formPersona";
	}
	
	@PostMapping("/guardar")
	public String guardarPersona(Persona persona) {
		persona.setFecha(new Date());
		service.guardarPersona(persona);
		return "redirect:/personas/index";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarPersona(@PathVariable Long id, Model model ) {
		Persona persona = service.buscarPersonaPorId(id);
		List<TipoPersona> lista = tipoPersonaService.listar();
		model.addAttribute("tipoPersonas", lista);
		model.addAttribute("persona", persona);
		return "personas/formPersona";
	}
	
	@PostMapping("/modificar")
	public String modificarPersona(Persona persona) {
		service.guardarPersona(persona);
		return "redirect:/personas/index";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarPersona(@PathVariable Long id) {
		service.eliminarPersona(id);
		return "redirect:/personas/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(formato,false));
	}
}