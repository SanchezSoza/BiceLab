package cl.rs.project.bice.lab.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/cabecera")
	public String cabecera(){
		return "Cabecera";
	}
	
	@RequestMapping("/indicadores")
	public String indicadores(){
		return "todosLosIndicadores";
	}
	
	@RequestMapping("/indicadoresValor")
	public String indicadoresValor(){
		return "indicadoresValor";
	}
	
	@RequestMapping("/indicadoresValorFecha")
	public String indicadoresValorFecha(){
		return "indicadoresValorFecha";
	}
	
	@RequestMapping("/resultadoValor/{valor}")
	public String resultadoValor(){
		return "resultadoValor";
	}
	
	@RequestMapping("/resultadoValorFecha/{valor}/{fecha}")
	public String resultadoValorFecha(){
		return "resultadoValorFecha";
	}
}