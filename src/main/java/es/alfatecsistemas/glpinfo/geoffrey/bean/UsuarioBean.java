package es.alfatecsistemas.glpinfo.geoffrey.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.alfatecsistemas.glpinfo.geoffrey.model.service.GeoffreyService;

@Component
@RequestScoped
public class UsuarioBean {

	// Atributos de la entidad
	private String login;
	private String password;
	private Boolean activo;
	private String nombre;
	
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

	// Métodos
	
	public void registrar() {
		geoffreyService.guardar(login, password, nombre);
	}

}
