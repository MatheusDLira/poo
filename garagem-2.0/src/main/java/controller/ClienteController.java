package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import model.ClienteModel;

public class ClienteController {
	
	private ClienteModel clienteModel;
	
	public ClienteController() {
		this.clienteModel = new ClienteModel();
	}
	
	public ArrayList<Cliente> cadastrar(Cliente cliente, ArrayList<Cliente> bdCliente) {
		
		this.clienteModel.cadastrar(cliente, bdCliente);
		
		
		return bdCliente;
		
		
		// return this.clienteModel.cadastrar(cliente);
	}
	
	public ArrayList<Cliente> alterar(Cliente cliente, ArrayList<Cliente> bdCliente) {
		return this.clienteModel.alterar(cliente, bdCliente);
	}
	
	public ArrayList<Cliente> remover(Cliente f, ArrayList<Cliente> bdCliente) {
		
		Cliente cliente = this.clienteModel.buscarPeloCodigo(f.getCodigo(), bdCliente);
		
		if(cliente != null ) {
			return this.clienteModel.remover(cliente, bdCliente);
		} else {
			return null;
		}

	}
	
//	public List<Cliente> listar(){
//		return this.clienteModel.listar();
//		
//	}
	
	public Cliente buscarPeloCodigo( int codigo, ArrayList<Cliente> bdCliente){
		return this.clienteModel.buscarPeloCodigo(codigo, bdCliente);
		
	}
	 

}