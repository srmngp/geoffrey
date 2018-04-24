package es.alfatecsistemas.glpinfo.geoffrey.bean;

import java.util.Date;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.alfatecsistemas.glpinfo.geoffrey.model.service.GeoffreyService;

@Component
@RequestScoped
public class TareaBean {
	
	@Autowired
	private GeoffreyService geoffreyService;
	
	private Long id;
	private String tipo;
	private int identificador;
	private String titulo;
	private String descripcion;
	private Date fecha;
	private int tiempo;
	
	public void crearTarea() {
		geoffreyService.guardarTarea(id,tipo,identificador,titulo, descripcion, fecha, tiempo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	
	
	
}
