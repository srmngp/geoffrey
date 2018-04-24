package es.alfatecsistemas.glpinfo.geoffrey.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;
import es.alfatecsistemas.glpinfo.geoffrey.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	//Inyeccion de dependencias
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Servicios
	
	public void guardar(String login, String password, String nombre) {
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setPassword(password);
		u.setNombre(nombre);
		
		usuarioRepository.save(u);
	}
	
}
