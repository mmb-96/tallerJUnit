package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompraService {
	
	BaseDeDatosService bbdd = new BaseDeDatosService();
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

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public Double getMedia() {
		//Operadir ternario java.
		return (articulos.size() > 0) ? totalPrice()/articulos.size() : null;
		
	}
	
	public Double aplicarDescuento(int id, Double descuento) {
		return calculadorDescuento(bbdd.findArticulosById(id).getPrecio(), descuento);
	}
	
	public void setDDBB(BaseDeDatosService ddbb) {
		this.bbdd = ddbb;
	}

}
