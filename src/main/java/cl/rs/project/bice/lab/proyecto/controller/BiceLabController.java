package cl.rs.project.bice.lab.proyecto.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.rs.project.bice.lab.proyecto.model.BiceLabModel;
import cl.rs.project.bice.lab.proyecto.model.BiceLabModelSalida;
import cl.rs.project.bice.lab.proyecto.service.BiceLabService;

@Controller
public class BiceLabController {

	@CrossOrigin
	@GetMapping(value = "/consumoInfoCompleta")
	public @ResponseBody List<BiceLabModelSalida> obtenerTodosLosDatos() {
//		logger.info("Fecha Inicial: "+entrada.getStarttime());
//		logger.info("Fecha Final: "+entrada.getEndtime());
		List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
		BiceLabService service = new BiceLabService();
		lista = service.obtenerTodosLosDatos();
//		logger.info("tamano lista controller: "+lista.size());
		return lista;
	}
	
	@CrossOrigin
	@PostMapping(value = "/consumoSoloValor")
	public @ResponseBody List<BiceLabModelSalida> obtenerUnSoloValor(@RequestBody BiceLabModel biceModelo) {
//		logger.info("Fecha Inicial: "+entrada.getStarttime());
//		logger.info("Fecha Final: "+entrada.getEndtime());
		List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
		BiceLabService service = new BiceLabService();
		lista = service.obtenerSoloValor(biceModelo.getValor());
//		logger.info("tamano lista controller: "+lista.size());
		return lista;
	}
	
	@CrossOrigin
	@PostMapping(value = "/consumoPorValorFecha")
	public @ResponseBody List<BiceLabModelSalida> obtenerPorValorYPorFecha(@RequestBody BiceLabModel biceModelo) {
//		logger.info("Fecha Inicial: "+entrada.getStarttime());
//		logger.info("Fecha Final: "+entrada.getEndtime());
		List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
		BiceLabService service = new BiceLabService();
//		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//		String fecha = formato.format(biceModelo.getFecha());
		lista = service.obtenerValorFecha(biceModelo.getValor(), biceModelo.getFecha());
//		logger.info("tamano lista controller: "+lista.size());
		return lista;
	}
}
