package cl.rs.project.bice.lab.proyecto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import cl.rs.project.bice.lab.proyecto.model.BiceLabModelSalida;

public class BiceLabService {

	public List<BiceLabModelSalida>obtenerTodosLosDatos(){
		String result = "";
		HttpClient httpclient = HttpClientBuilder.create().build();
		String url = "http://www.indecon.online/last";
    	HttpGet httpget = new HttpGet(url);
    	List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
    	HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
	    	StringBuffer resultado = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				resultado.append(line);
			}
			result = resultado.toString();
			JSONObject jo = new JSONObject(result);
			for(int i = 0; i<jo.names().length(); i++){
			    JSONObject jObj2 = jo.getJSONObject(jo.names().getString(i));
			    BiceLabModelSalida modelSalida = new BiceLabModelSalida();
			    String fecha = isNull(String.valueOf(jObj2.get("date")));
			    Long convertirALong = Long.valueOf(fecha);
			    
			    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			    Date fechaDate = new Date(convertirALong * 1000);
			    String fechaFormato = dateFormat.format(fechaDate);
			    modelSalida.setFecha(fechaFormato);
			    modelSalida.setUnidadMedida(isNull(jObj2.getString("unit")));
			    modelSalida.setNombre(isNull(jObj2.getString("name")));
			    modelSalida.setValor(isNull(String.valueOf(jObj2.getDouble("value"))));
			    modelSalida.setNombreUnidad(isNull(jObj2.getString("key")));
			    lista.add(modelSalida);
			    
			}			
		} catch (IOException e) {
			System.err.println("Error en el consumo del servicio rest");
		}
		return lista;
	}
	
	public List<BiceLabModelSalida>obtenerSoloValor(String valor){
		String result = "";
		HttpClient httpclient = HttpClientBuilder.create().build();
		String url = "https://www.indecon.online/values/"+valor;
    	HttpGet httpget = new HttpGet(url);
    	List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
    	HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
	    	StringBuffer resultado = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				resultado.append(line);
			}
			result = resultado.toString();
			JSONObject jo = new JSONObject(result);
			JSONObject jObj2 = new JSONObject(String.valueOf(jo.get("values")));
		    for(int i = 0; i<jObj2.names().length(); i++){
		    	BiceLabModelSalida modelSalida = new BiceLabModelSalida();
			    modelSalida.setUnidadMedida(isNull(jo.getString("unit")));
			    modelSalida.setNombre(isNull(jo.getString("name")));
			    modelSalida.setNombreUnidad(isNull(jo.getString("key")));
		    	String fecha = isNull(String.valueOf(jObj2.names().getString(i)));
		    	Long convertirALong = Long.valueOf(fecha);
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			    Date fechaDate = new Date(convertirALong * 1000);
			    String fechaFormato = dateFormat.format(fechaDate);
			    modelSalida.setFecha(fechaFormato);
			    modelSalida.setValor(isNull(String.valueOf(jObj2.get(jObj2.names().getString(i)))));
			    lista.add(modelSalida);
		    }
		} catch (IOException e) {
			System.err.println("Error en el consumo del servicio rest");
		}
		return lista;
	}
	
	public List<BiceLabModelSalida>obtenerValorFecha(String valor, String fecha){
		String result = "";
		HttpClient httpclient = HttpClientBuilder.create().build();
		String url = "https://www.indecon.online/date/"+valor+"/"+fecha;
    	HttpGet httpget = new HttpGet(url);
    	List<BiceLabModelSalida> lista = new ArrayList<BiceLabModelSalida>();
    	HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
	    	StringBuffer resultado = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				resultado.append(line);
			}
			result = resultado.toString();
			JSONObject jo = new JSONObject(result);
		    BiceLabModelSalida modelSalida = new BiceLabModelSalida();
		    String fechaAux = isNull(String.valueOf(jo.get("date")));
		    Long convertirALong = Long.valueOf(fechaAux);
			    
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    Date fechaDate = new Date(convertirALong * 1000);
		    String fechaFormato = dateFormat.format(fechaDate);
		    modelSalida.setFecha(fechaFormato);
		    modelSalida.setUnidadMedida(isNull(jo.getString("unit")));
		    modelSalida.setNombre(isNull(jo.getString("name")));
		    modelSalida.setValor(isNull(String.valueOf(jo.getDouble("value"))));
		    modelSalida.setNombreUnidad(isNull(jo.getString("key")));
		    lista.add(modelSalida);			
		} catch (IOException e) {
			System.err.println("Error en el consumo del servicio rest");
		}
		return lista;
	}
	
	public String isNull(String valor) {
		if ((valor == "null") || (valor == null)) {
			valor = "";
		}
		return valor;
	}
}
