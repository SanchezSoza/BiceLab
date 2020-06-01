package cl.rs.project.bice.lab.proyecto;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.rs.project.bice.lab.proyecto.model.BiceLabModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
public class BiceLabApplicationTests {

	@Autowired
    private MockMvc mockMvc;
 
    @Autowired
    ObjectMapper objectmapper;
     
    @Test
    public void testObtenerTodosLosValores() throws Exception {
        mockMvc.perform(get("http://localhost:8080/consumoInfoCompleta"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void testObtenerValor() throws Exception {
    	BiceLabModel bicemoModel = new BiceLabModel();
    	bicemoModel.setValor("cobre");
    	mockMvc.perform(post("http://localhost:8080/consumoSoloValor")
    			.content(objectmapper.writeValueAsString(bicemoModel))
    			.contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().is(HttpStatus.OK.value()))
    	.andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testObtenerValorYFecha() throws Exception {
    	BiceLabModel bicemoModel = new BiceLabModel();
    	bicemoModel.setValor("cobre");
    	bicemoModel.setFecha("03-01-2020");
    	mockMvc.perform(post("http://localhost:8080/consumoPorValorFecha")
    			.content(objectmapper.writeValueAsString(bicemoModel))
    			.contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().is(HttpStatus.OK.value()))
    	.andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testObtenerValorFallido() throws Exception {
    	mockMvc.perform(post("http://localhost:8080/consumoSoloValor")
    			.content(objectmapper.writeValueAsString("cobre"))
    			.contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
    	.andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testObtenerValorYFechaFallido() throws Exception {
    	mockMvc.perform(post("http://localhost:8080/consumoPorValorFecha")
    			.content(objectmapper.writeValueAsString("cobre"))
    			.content(objectmapper.writeValueAsBytes("03-01-2020"))
    			.contentType(MediaType.APPLICATION_JSON))
    	.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
    	.andReturn().getResponse().getContentAsString();
    }
    
}