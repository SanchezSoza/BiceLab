package cl.rs.project.bice.lab.proyecto.model;

import java.util.Date;

public class BiceLabModel {

	private String valor;
	private String fecha;
	
	public BiceLabModel() {
	
	}
	
	public BiceLabModel(String valor, String fecha) {
		this.valor = valor;
		this.fecha = fecha;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
