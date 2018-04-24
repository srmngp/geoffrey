package es.alfatecsistemas.glpinfo.geoffrey.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Tarea;
import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;
import es.alfatecsistemas.glpinfo.geoffrey.model.repository.TareaRepository;
import es.alfatecsistemas.glpinfo.geoffrey.model.repository.UsuarioRepository;
import es.alfatecsistemas.glpinfo.geoffrey.support.GeoffreyException;

@Service
public class GeoffreyService {
	
	//Inyeccion de dependencias
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TareaRepository tareaRepository;
	
	//Servicios
	
	public void guardar(String login, String password, String nombre) throws GeoffreyException  {
		Usuario u = new Usuario();
		u.setActivo(true);
		u.setLogin(login);
		//Encriptar contraseña
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		u.setPassword(password);
		u.setNombre(nombre);
		
		usuarioRepository.save(u);
	}

	public void guardarTarea(Long id, String tipo, int identificador, String titulo, String descripcion, Date fecha,
			int tiempo) {
		Tarea t = new Tarea();
		t.setId(id);
		t.setTipo(tipo);
		t.setIdentificador(identificador);
		t.setTitulo(titulo);
		t.setDescripcion(descripcion);
		t.setFecha(fecha);
		t.setTiempo(tiempo);
		
		tareaRepository.save(t);
	}
	
}
