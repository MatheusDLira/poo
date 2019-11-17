package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Automovel;
import entity.Marca;
import entity.Venda;
import model.AutomovelModel;
import model.VendaModel;

public class VendaController {
	
	private VendaModel vendaModel;
	private AutomovelModel automovelModel;
	
	public VendaController() {
		this.vendaModel = new VendaModel();
		this.automovelModel = new AutomovelModel();
	}
	
	public ArrayList<Venda> cadastrar(Venda venda, ArrayList<Venda> bdVenda) {
		
		this.vendaModel.cadastrar(venda, bdVenda);
		
		
		return bdVenda;
		
		
		// return this.vendaModel.cadastrar(venda);
	}
	
	public ArrayList<Venda> alterar(Venda venda, ArrayList<Venda> bdVenda) {
		return this.vendaModel.alterar(venda, bdVenda);
	}
	
	public ArrayList<Venda> remover(String nome, ArrayList<Venda> bdVenda) {
		
		Venda venda = this.vendaModel.buscarPeloCodigo(nome, bdVenda);
		
		if(venda != null ) {
			return this.vendaModel.remover(venda, bdVenda);
		} else {
			return null;
		}

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

}