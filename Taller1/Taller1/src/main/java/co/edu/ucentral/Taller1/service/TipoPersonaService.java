package co.edu.ucentral.Taller1.service;


	import java.util.List;

import co.edu.ucentral.Taller1.model.TipoPersona;

public interface TipoPersonaService {
	public List<TipoPersona> listar();
	public void guardarTipoPersona(TipoPersona tipoPersona);
	public TipoPersona buscarTipoPersonaPorId(Long id);
	public void eliminarTipoPersona(Long id);
}