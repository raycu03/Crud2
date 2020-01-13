package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import com.example.demo.controllers.ProductoController;

import com.example.demo.infraestructure.dto.ProductoDto;
import com.example.demo.infraestructure.dto.ProductoRest;
import com.example.demo.infraestructure.repository.database.FacturaRepository;
import com.example.demo.infraestructure.repository.database.ProductoRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
import org.hamcrest.Matchers;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class Crud2ApplicationTests {
	
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	ProductoController productoController;

	@Test
	public void TestProducto() {
		
		ProductoDto productoDto = new ProductoDto("25","sopa",14.58);
		
		productoRepository.save(productoDto);
		
		ProductoDto foudProducto = productoRepository.findById(productoDto.getCodigo()).get();
		
		assertEquals("sopa", foudProducto.getNombre());
		
	}
		
	@Test
	public void TestPorductoController() {
		
		ProductoRest producto = new ProductoRest("25","LECHE",14.58);
		
		productoController.crear(producto);
		
	}
	

}
