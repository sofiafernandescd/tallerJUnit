package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CarritoCompraServiceTest {
	
	CarritoCompraService service;
	
	@Before
	public void setUp(){
		System.out.println("Inicializamos el servicio");
		service = new CarritoCompraService();
	}
	
	@Test
	public void primerTest(){
		System.out.println("Primer test");
	}
	
	@Test
	public void testAddArticulo(){
		System.out.println("Probando addArticulo");
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
	}
	
	@Test
	public void testLimpiarCestaCompra(){
		System.out.println("Probando llimpiarCesta");
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
		assertFalse(service.getArticulos().isEmpty());
		service.limpiarCesta();
		assertTrue(service.getArticulos().isEmpty());
	}
	
	@Test
	public void testTotalPrice(){
		System.out.println("Probando totalPrice");
		service.addArticulo(new Articulo("Articulo 1", 10d));
		service.addArticulo(new Articulo("Articulo 2", 20d));
		service.addArticulo(new Articulo("Articulo 3", 30d));
		service.addArticulo(new Articulo("Articulo 4", 40d));
		assertEquals(service.totalPrice(), new Double(100));
	}
	
	@Test
	public void testCalculaDescuento(){
		System.out.println("Probando calculaDescuento");
		assertEquals(service.calculadorDescuento(100, 10d), new Double(90));
	}

}
