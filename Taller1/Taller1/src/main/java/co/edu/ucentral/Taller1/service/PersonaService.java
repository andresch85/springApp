package co.edu.ucentral.Taller1.service;

import java.util.List;

import co.edu.ucentral.Taller1.model.Persona;
import co.edu.ucentral.Taller1.model.TipoPersona;

public interface PersonaService {

	public List<Persona> listar();
	public void guardarPersona(Persona persona);
	public List<Persona> buscarPersonaPorTipo(TipoPersona tipoPersona);
	public Persona buscarPersonaPorId(Long id);
	public void eliminarPersona(Long id);
}