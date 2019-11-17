package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Automovel;
import entity.Cliente;
import entity.Funcionario;
import entity.Marca;
import entity.Venda;
import model.AutomovelModel;
import model.ClienteModel;
import model.FuncionarioModel;
import model.VendaModel;
import view.ClienteView;

public class VendaController {
	
	private VendaModel vendaModel;
	private AutomovelModel automovelModel;
	private FuncionarioModel funcionarioModel;
	private ClienteModel clienteModel;
	
	public VendaController() {
		this.vendaModel = new VendaModel();
		this.automovelModel = new AutomovelModel();
		this.funcionarioModel = new FuncionarioModel();
		this.clienteModel = new ClienteModel();
	}
	
	public ArrayList<Venda> cadastrar(Venda venda, ArrayList<Venda> bdVenda) {
		
		this.vendaModel.cadastrar(venda, bdVenda);
		
		
		return bdVenda;
		
		
		// return this.vendaModel.cadastrar(venda);
	}
	
	public ArrayList<Venda> alterar(Venda venda, ArrayList<Venda> bdVenda) {
		return this.vendaModel.alterar(venda, bdVenda);
	}
	
	public ArrayList<Venda> remover(Venda v, ArrayList<Venda> bdVenda) {
			return this.vendaModel.remover(v, bdVenda);
	}
	
//	public List<Venda> listar(){
//		return this.vendaModel.listar();
//		
//	}
	
	public Venda buscarPeloCodigo( int codigo, ArrayList<Venda> bdVenda){
		return this.vendaModel.buscarPeloCodigo(codigo, bdVenda);
		
	}
	 
	public Automovel buscarAutomovel( String placa , ArrayList<Automovel> bdAutomovel){
		return this.automovelModel.buscarPelaPlaca(placa, bdAutomovel);
				
	}
	
	public Funcionario buscarFuncionario( int codigo, ArrayList<Funcionario> bdFuncionario){
		return this.funcionarioModel.buscarPeloCodigo(codigo, bdFuncionario);
		
	}
	
	public Cliente buscarCliente( int codigo, ArrayList<Cliente> bdCliente){
		return this.clienteModel.buscarPeloCodigo(codigo, bdCliente);
		
	}
}