package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BaseDeDatosService {

	public List<Articulo> artigos =new ArrayList<Articulo>(Arrays.asList(
	new Articulo(1L, "kiwi", 10D),
	new Articulo(1L, "maca", 5D),
	new Articulo(1L, "banana", 7D),
	new Articulo(1L, "laranja", 1000D)));
	
	public Articulo findById(Long id) {
		for (Articulo a: artigos) {
			if(a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	
/*	public Articulo findById(Long id) {
		Optional<Articulo> articuloFind= artigos.stream().filter(a -> a.getId().equals(id)).findFirst();
		if(articuloFind.isPresent()) {
			articuloFind.get();
		}
	}*/
}

