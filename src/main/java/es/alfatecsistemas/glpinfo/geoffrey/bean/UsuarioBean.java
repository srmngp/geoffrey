package es.alfatecsistemas.glpinfo.geoffrey.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Usuario;
import es.alfatecsistemas.glpinfo.geoffrey.model.service.GeoffreyService;
import es.alfatecsistemas.glpinfo.geoffrey.support.GeoffreyException;

@Component
@RequestScoped
public class UsuarioBean {

	// Atributos de la entidad
	private String login;
	private String password;
	private Boolean activo;
	private String nombre;

	private String rol;

	private List<Usuario> listaUsuarios;
	private List<String> nombres;

	@Autowired
	private GeoffreyService geoffreyService;

	// Gets and sets
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}

	// Métodos

	public void userNRoll() {
		registrar();
		asignarRol();
	}

	public String registrar() {
		FacesMessage mensaje = new FacesMessage("Usuario registrado correctamente.");
		try {
			geoffreyService.guardarUsuario(login, password, nombre, rol);
			login = null;
			password = null;
			nombre = null;
		} catch (GeoffreyException e) {
			mensaje.setSummary(e.getMessage());
			return "mensaje";
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		list();
		return null;
	}
	
	public String editar(Usuario usuario) {
		FacesMessage mensaje = new FacesMessage("Usuario editado correctamente.");
		try {
			geoffreyService.editarUsuario(usuario);
			login = null;
			password = null;
			nombre = null;
		} catch (GeoffreyException e) {
			mensaje.setSummary(e.getMessage());
			return "mensaje";
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		list();
		return null;
	}

	public String eliminar(Usuario usuario) {
		FacesMessage mensaje = new FacesMessage("Usuario eliminado correctamente.");
		try {
			geoffreyService.eliminarUsuario(usuario);
			login = null;
			password = null;
			nombre = null;
		} catch (GeoffreyException e) {
			mensaje.setSummary(e.getMessage());
			return "mensaje";
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		list();
		return null;
	}

	public String asignarRol() {
		FacesMessage mensaje = new FacesMessage("Rol asignado.");
		try {
			geoffreyService.asignarRol(rol, login);
		} catch (GeoffreyException e) {
			mensaje.setSummary(e.getMessage());
			return "mensaje";
		}
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return null;
	}

	@PostConstruct
	public void list() {
		try {
			listaUsuarios = geoffreyService.listarUsuarios();
			nombres = new ArrayList<String>();
			for (int i = 0; i < listaUsuarios.size(); i++) {
				Usuario u = listaUsuarios.get(i);
				nombres.add(u.getLogin());
			}
		} catch (GeoffreyException e) {
			e.printStackTrace();
		}

	}

}
