package com.everis.bootcamp.tallerjunit;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
public class CarritoCompraService {
	
	BaseDeDatosService service = new BaseDeDatosService();
	List<Articulo> articulos = new ArrayList<Articulo>();
	
	public void limpiarCesta(){
		articulos = new ArrayList<Articulo>();
	}
	
	public void addArticulo(Articulo a){
		articulos.add(a);
	}
	
	public int getNumArticulo(){
		return articulos.size();
	}
	
	public Double totalPrice(){
		double precioTotal = articulos.stream().  	
			     mapToDouble(Articulo::getPrecio).
			     sum();
		return precioTotal;
	}
	
	public static Double calculadorDescuento(double precio, double porcentajeDescuento){
		return precio - (precio * (porcentajeDescuento/100));
	}

	public Double aplicaDescuento(Long id, double porcentajeDescuento){
		
		return calculadorDescuento(service.findById(id).getPrecio(), porcentajeDescuento);
	}
	
	/*public Double aplicaDescuento(Long id, double porcentajeDescuento){
		BaseDeDatosService base= new BaseDeDatosService();
		return calculadorDescuento(base.findById(id).getPrecio(), porcentajeDescuento);
	}*/
	
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	

}
