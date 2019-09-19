package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculadoraTest {
	
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
	 * Test soma.
	 */
	@Test
	public void testSoma() {
		
		Calculadora calculadora = new Calculadora();
		double res = calculadora.Soma(1, 1);
		assertEquals(2, res, 0);
		
	}
	/**
	 * Test subtracao.
	 */
	@Test
	public void testSubtracao() {
		
		Calculadora calculadora = new Calculadora();
		double res = calculadora.Subtracao(1, 1);
		assertEquals(0, res, 0);
		
	}
	/**
	 * Test multiplicacao.
	 */
	@Test
	public void testMultiplicacao() {
		
		Calculadora calculadora = new Calculadora();
		double res = calculadora.Multiplicacao(2, 1);
		assertEquals(2, res, 0);
		
	}
	/**
	 * Test divisao.
	 */
	@Test
	public void testDivisao() {
		
		Calculadora calculadora = new Calculadora();
		double res = calculadora.Divisao(2, 1);
		assertEquals(2, res, 0);
		
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
