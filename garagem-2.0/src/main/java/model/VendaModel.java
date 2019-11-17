package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Venda;

public class VendaModel {
	
	List<Venda> bdVenda;
	
	public VendaModel() {
		bdVenda = new ArrayList<Venda>();
	}
	
	public ArrayList<Venda> cadastrar(Venda venda, ArrayList<Venda> bdVenda) {
		
		int id = bdVenda.size() + 1;
		venda.setId(id);
		
		bdVenda.add(venda);
		
		return bdVenda;
	}
	
	public ArrayList<Venda> alterar(Venda venda, ArrayList<Venda> bdVenda) {
		
		int index = bdVenda.indexOf(venda);
		
		bdVenda.set(index, venda);
		
		return bdVenda;
	}
	
	public ArrayList<Venda> remover(Venda venda, ArrayList<Venda> bdVenda) {
		bdVenda.remove(venda);
		return bdVenda;
	}
	
//	public List<Venda> listar(){
//		return this.bdVenda;
//	}
	
	public Venda buscarPeloCodigo( int codigo, ArrayList<Venda> bdVenda ){
		
		/*for(int i = 0; i < bdVenda.size(); i++) {
    		
			bdVenda.get(i)
			
    	}*/
		
		for(int i = 0; i < bdVenda.size(); i++) {
    		
			if(bdVenda.get(i).getCod_venda() == codigo) {
				return bdVenda.get(i);
			}
			
    	}
		
		return null;
	}
	
	
	
}