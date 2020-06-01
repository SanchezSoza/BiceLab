package cl.rs.project.bice.lab.proyecto.model;

import java.util.Date;

public class BiceLabModelSalida {

	private String fecha;
	private String unidadMedida;
	private String nombre;
	private String valor;
	private String nombreUnidad;
	
	public BiceLabModelSalida() {

	}
	
	public BiceLabModelSalida(String fecha, String unidadMedida, String nombre, String valor, String nombreUnidad) {
		this.fecha = fecha;
		this.unidadMedida = unidadMedida;
		this.nombre = nombre;
		this.valor = valor;
		this.nombreUnidad = nombreUnidad;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
}
