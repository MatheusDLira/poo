package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;

public class MarcaModel {
	
	//private List<Marca> bdMarca;
	
//	public MarcaModel() {
//		bdMarca = new ArrayList<Marca>();
//	}
	
	public ArrayList<Marca> cadastrar(Marca marca, ArrayList<Marca> bdMarca) {
		
		int id = bdMarca.size() + 1;
		marca.setId(id);
		
		bdMarca.add(marca);
		
		return bdMarca;
	}
	
	public ArrayList<Marca> alterar(Marca marca, ArrayList<Marca> bdMarca) {
		
		int index = bdMarca.indexOf(marca);
		
		bdMarca.set(index, marca);
		
		return bdMarca;
	}
	
	public ArrayList<Marca> remover(Marca marca, ArrayList<Marca> bdMarca) {
		bdMarca.remove(marca);
		return bdMarca;
	}
	
//	public List<Marca> listar(){
//		return this.bdMarca;
//	}
	
	public Marca buscarPeloNome( String nome, ArrayList<Marca> bdMarca ){
		
		/*for(int i = 0; i < bdMarca.size(); i++) {
    		
			bdMarca.get(i)
			
    	}*/
		
		for(Marca marca : bdMarca) {
			
			if(marca.getNomeMarca().equals(nome)) {
				return marca;
			}
		}
		
		return null;
	}
	
	
}