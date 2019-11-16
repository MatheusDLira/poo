package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Automovel;

public class AutomovelModel {
	
	List<Automovel> bdAutomovel;
	
	public AutomovelModel() {
		bdAutomovel = new ArrayList<Automovel>();
	}
	
	public ArrayList<Automovel> cadastrar(Automovel automovel, ArrayList<Automovel> bdAutomovel) {
		
		int id = bdAutomovel.size() + 1;
		automovel.setId(id);
		
		bdAutomovel.add(automovel);
		
		return bdAutomovel;
	}
	
	public ArrayList<Automovel> alterar(Automovel automovel, ArrayList<Automovel> bdAutomovel) {
		
		int index = bdAutomovel.indexOf(automovel);
		
		bdAutomovel.set(index, automovel);
		
		return bdAutomovel;
	}
	
	public ArrayList<Automovel> remover(Automovel automovel, ArrayList<Automovel> bdAutomovel) {
		bdAutomovel.remove(automovel);
		return bdAutomovel;
	}
	
//	public List<Automovel> listar(){
//		return this.bdAutomovel;
//	}
	
	public Automovel buscarPelaPlaca( String placa, ArrayList<Automovel> bdAutomovel ){
		
		/*for(int i = 0; i < bdAutomovel.size(); i++) {
    		
			bdAutomovel.get(i)
			
    	}*/
		
		for(Automovel modelo : bdAutomovel) {
			
			if(modelo.getPlaca().equals(placa)) {
				return modelo;
			}
		}
		
		return null;
	}
	
	
	
}