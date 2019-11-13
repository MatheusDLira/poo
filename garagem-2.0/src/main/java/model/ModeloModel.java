package model;

import java.util.ArrayList;
import java.util.List;

import entity.Modelo;

public class ModeloModel {
	
	List<Modelo> bdModelo;
	
	public ModeloModel() {
		bdModelo = new ArrayList<Modelo>();
	}
	
	public Modelo cadastrar(Modelo modelo) {
		
		int id = this.bdModelo.size() + 1;
		modelo.setId(id);
		
		this.bdModelo.add(modelo);
		
		return modelo;
	}
	
	public Modelo alterar(Modelo modelo) {
		
		int index = this.bdModelo.indexOf(modelo);
		
		return this.bdModelo.set(index, modelo);
	}
	
	public boolean remover(Modelo modelo) {
		return this.bdModelo.remove(modelo);
	}
	
	public List<Modelo> listar(){
		return this.bdModelo;
	}
	
	public Modelo buscarPeloNome( String nome ){
		
		/*for(int i = 0; i < bdModelo.size(); i++) {
    		
			bdModelo.get(i)
			
    	}*/
		
		for(Modelo modelo : bdModelo) {
			
			if(modelo.getNomeModelo().equals(nome)) {
				return modelo;
			}
		}
		
		return null;
	}
	
	
}