package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;

public class MarcaModel {
	
	private List<Marca> bdMarca;
	
	public MarcaModel() {
		bdMarca = new ArrayList<Marca>();
	}
	
	public Marca cadastrar(Marca marca) {
		
		int id = this.bdMarca.size() + 1;
		marca.setId(id);
		
		this.bdMarca.add(marca);
		
		return marca;
	}
	
	public Marca alterar(Marca marca) {
		
		int index = this.bdMarca.indexOf(marca);
		
		return this.bdMarca.set(index, marca);
	}
	
	public boolean remover(Marca marca) {
		return this.bdMarca.remove(marca);
	}
	
	public List<Marca> listar(){
		return this.bdMarca;
	}
	
	public Marca buscarPeloNome( String nome ){
		
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