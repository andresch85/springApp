package co.edu.ucentral.Taller1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.edu.ucentral.Taller1.model.Persona;
import co.edu.ucentral.Taller1.model.TipoPersona;
import co.edu.ucentral.Taller1.service.PersonaService;
import co.edu.ucentral.Taller1.service.TipoPersonaService;

@Controller
public class IndexController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private TipoPersonaService tipoPersonaService;

	@GetMapping({ "/" })
	public String index(Model model) {
		return "index";
	}

	@ModelAttribute
	public void setAtributos(Model model) {
		TipoPersona tipoPersona = new TipoPersona();
		model.addAttribute("buscar", tipoPersona);
		model.addAttribute("tipoPersonas", tipoPersonaService.listar());
	}

	@GetMapping("/buscar")
	public String buscarPorTipoPersona(@ModelAttribute("buscar") TipoPersona tipoPersona, Model model) {
		List<Persona> lista = personaService.buscarPersonaPorTipo(tipoPersona);
		model.addAttribute("personas", lista);
		return "index";
	}

}