package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Modelo;

public class ModeloModel {
	
	List<Modelo> bdModelo;
	
	public ModeloModel() {
		bdModelo = new ArrayList<Modelo>();
	}
	
	public ArrayList<Modelo> cadastrar(Modelo modelo, ArrayList<Modelo> bdModelo) {
		
		int id = bdModelo.size() + 1;
		modelo.setId(id);
		
		bdModelo.add(modelo);
		
		return bdModelo;
	}
	
	public ArrayList<Modelo> alterar(Modelo modelo, ArrayList<Modelo> bdModelo) {
		
		int index = bdModelo.indexOf(modelo);
		
		bdModelo.set(index, modelo);
		
		return bdModelo;
	}
	
	public ArrayList<Modelo> remover(Modelo modelo, ArrayList<Modelo> bdModelo) {
		bdModelo.remove(modelo);
		return bdModelo;
	}
	
//	public List<Modelo> listar(){
//		return this.bdModelo;
//	}
	
	public Modelo buscarPeloNome( String nome, ArrayList<Modelo> bdModelo ){
		
		/*for(int i = 0; i < bdModelo.size(); i++) {
    		
			bdModelo.get(i)
			
    	}*/
		
		for(Modelo nodelo : bdModelo) {
			
			if(nodelo.getNomeModelo().equals(nome)) {
				return nodelo;
			}
		}
		
		return null;
	}
	
	
	
}