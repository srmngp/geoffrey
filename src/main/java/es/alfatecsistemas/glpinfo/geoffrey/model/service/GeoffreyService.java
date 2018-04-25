package es.alfatecsistemas.glpinfo.geoffrey.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Rol;
import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Tarea;
import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;
import es.alfatecsistemas.glpinfo.geoffrey.model.repository.RolRepository;
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
	
	@Autowired 
	private RolRepository rolRepository;
	
	//Servicios
	
	public void guardarUsuario(String login, String password, String nombre) throws GeoffreyException  {
		Usuario u = new Usuario();
		
		u.setActivo(true);
		u.setLogin(login);
		//Encriptar contraseña
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		u.setPassword(password);
		u.setNombre(nombre);
		/*List<Rol> roles = new ArrayList<Rol>();
		Rol rol = new Rol();
		rol.setNombre("ROLE_USER");
		roles.add(rol);
		u.setRoles(roles);*/
		
		usuarioRepository.save(u);
	}
	
	public void asignarRol(String rol, String login) throws GeoffreyException {
		Usuario u = usuarioRepository.buscarUsuarioByNombre(login);
		Rol r = rolRepository.buscarRolByNombre(rol);
		List<Rol> roles = new ArrayList<Rol>();
		roles.add(r);
		r = rolRepository.buscarRolByNombre("ROLE_USER");
		roles.add(r);
		u.setRoles(roles);
		
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
	
	public List<Tarea> listarTareas() {
		return tareaRepository.findAll();
	}
	
	public List<Usuario> listarUsuarios() throws GeoffreyException {
		return usuarioRepository.findAll();
	}
}
