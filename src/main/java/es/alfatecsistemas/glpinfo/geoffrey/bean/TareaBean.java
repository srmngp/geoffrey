package es.alfatecsistemas.glpinfo.geoffrey.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.alfatecsistemas.glpinfo.geoffrey.model.entity.Tarea;
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
	private DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
	private String fechaString;
	private Date fecha;
	private int tiempo;
	
	private List<Tarea> tareas;
	
	public void crearTarea() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("Etc/CET"));
		
		java.util.Date date = null;
		try {
			System.out.println(date = format.parse(fechaString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		java.sql.Date fecha = new java.sql.Date(date.getTime());

		geoffreyService.guardarTarea(id,tipo,identificador,titulo, descripcion, fecha, tiempo);
	}
	
	public void listarTareas(){
		tareas = geoffreyService.listarTareas();
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

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}

	
	
	
	
}
