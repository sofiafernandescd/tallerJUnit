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
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarritoCompraServiceTest {

	CarritoCompraService carrito;
	static Articulo a = new Articulo("maça", 20d);
	static Articulo b = new Articulo("pera", 20d);
	static Articulo c = new Articulo("sofa", 20d);
	static Articulo d = new Articulo("maça", 20d);

	@InjectMocks
	static CarritoCompraService service;
	@Mock
	private BaseDeDatosService base;

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
	public void testBefore() throws Exception {
		carrito = new CarritoCompraService();
		System.out.println("Entramos na before");
		Mockito.when(base.findById(1L)).thenReturn(new Articulo(1L, "Este artigo esta mockeado", 100D));
		Mockito.when(base.findById(100L)).thenReturn(new Articulo(100L, "Este artigo esta mockeado", 100D));
		//Mockito.doThrow(new Exception()).when(base).nohagonada();
		//Criar objeto
		Articulo miArt = new Articulo("cha", 30D);
		//Definir comportamento
		BaseDeDatosService base = Mockito.mock(BaseDeDatosService.class);
		Mockito.when(base.findById(Mockito.eq(100L))).thenReturn(miArt);
		//Chamada do metodo a testar
		
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

	}

	/**
	 * Test totalPrice.
	 */
	@Test
	public void testTotalPrice() {

		carrito.addArticulo(a);
		carrito.addArticulo(b);
		double res = carrito.totalPrice();
		assertTrue(res == 40);

	}

	/**
	 * Test calculadorDescuento.
	 */
	@Test
	public void testCalculadorDescuento() {
		Double res = carrito.calculadorDescuento(50d, 20d);
		assertEquals(40d, res, 0);
	}

	@Test
	public void testGetNumArticulo() {
		carrito.addArticulo(a);
		carrito.addArticulo(b);
		assertEquals(2, carrito.getNumArticulo(), 0);
	}

	@Test
	public void testSetArticulos() {

		List<Articulo> articulos = new ArrayList<>();
		articulos.add(a);
		articulos.add(b);
		carrito.setArticulos(articulos);
		assertEquals(articulos, carrito.getArticulos());
	}

	@Test
	public void testAplicarDescuento() {
		double desc = service.aplicaDescuento(1L, 50D);
		assertEquals(50D, desc, 0);
		Mockito.verify(base, times(1)).findById(1L);
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
