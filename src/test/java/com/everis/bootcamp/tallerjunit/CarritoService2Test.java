package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarritoService2Test {
	
	private CarritoCompraService carrito = new CarritoCompraService();
	static Articulo a = new Articulo ("maça",20d);
	static Articulo b = new Articulo ("pera",20d);
	static Articulo c = new Articulo ("sofa",20d);
	static Articulo d = new Articulo ("maça",20d);
	
	/**
	 * Test before class.
	 */
	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Entramos na beforeClass");
	
	}
	
	/**
	 * Test before.
	 */
	@Before
	public void testBefore() {
		System.out.println("Entramos na before");
		
	}
	
	/**
	 * Test addArticulo.
	 */
	@Test
	public void testAddArticulo() {
		List<Articulo> res1 = carrito.getArticulos();
		int inicial = res1.size();
		carrito.addArticulo(b);
		List<Articulo> res2 = carrito.getArticulos();
		assertTrue(res2.size() > inicial);
		System.out.println("Entramos no addArticulo");
		
	}
	/**
	 * Test getNumArticulo.
	 */
	@Test
	public void testLimpiarCesta() {
		carrito.addArticulo(c);
		assertFalse(carrito.getArticulos().isEmpty());
		carrito.limpiarCesta();
		assertTrue(carrito.getArticulos().isEmpty());
		System.out.println("Entramos no limpiarCesta");
		
	}
	/**
	 * Test totalPrice.
	 */
	@Test
	public void testTotalPrice() {
		
		carrito.addArticulo(a);
		carrito.addArticulo(b);
		double res = carrito.totalPrice();
		assertTrue(res==40);
		System.out.println("Entramos na totalPrice");
		
	}
	/**
	 * Test calculadorDescuento.
	 */
	@Test
	public void testCalculadorDescuento() {
		Double res = carrito.calculadorDescuento(50d,20d);
		assertEquals(40d,res , 0);
	}
	
	@Test
	public void testGetNumArticulo() {
		carrito.addArticulo(a);
		carrito.addArticulo(b);
		assertEquals(2,carrito.getNumArticulo() , 0);
	}
	
	@Test
	public void testSetArticulos() {
		
		List<Articulo> articulos = new ArrayList();
		articulos.add(a);
		articulos.add(b);
		carrito.setArticulos(articulos);
		assertEquals(articulos, carrito.getArticulos());
	}
	
	/**
	 * Test after class.
	 */
	@After
	public void testAfter() {
		System.out.println("Entramos na After");
	}
	
	/**
	 * Test before.
	 */
	@AfterClass
	public static void testAfterClass() {
		
		System.out.println("Entramos na afterClass");
	}
	
}
