package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Cliente;

public class ClienteModel {
	
	List<Cliente> bdCliente;
	
	public ClienteModel() {
		bdCliente = new ArrayList<Cliente>();
	}
	
	public ArrayList<Cliente> cadastrar(Cliente cliente, ArrayList<Cliente> bdCliente) {
		
		int id = bdCliente.size() + 1;
		cliente.setId(id);
		
		bdCliente.add(cliente);
		
		return bdCliente;
	}
	
	public ArrayList<Cliente> alterar(Cliente cliente, ArrayList<Cliente> bdCliente) {
		
		int index = bdCliente.indexOf(cliente);
		
		bdCliente.set(index, cliente);
		
		return bdCliente;
	}
	
	public ArrayList<Cliente> remover(Cliente cliente, ArrayList<Cliente> bdCliente) {
		bdCliente.remove(cliente);
		return bdCliente;
	}
	
//	public List<Cliente> listar(){
//		return this.bdCliente;
//	}
	
	public Cliente buscarPeloCodigo( int codigo, ArrayList<Cliente> bdCliente ){
		
		for(int i = 0; i < bdCliente.size(); i++) {
    		
			if(bdCliente.get(i).getCodigo() == codigo) {
				return bdCliente.get(i);
			}
			
    	}
//		
//		for(Cliente cliente : bdCliente) {
//			
//			if(cliente.getCodigo().equals(codigo)) {
//				return cliente;
//			}
//		}
		
		return null;
	}
	
	
	
}