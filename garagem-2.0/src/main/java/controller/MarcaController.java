package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import model.MarcaModel;

public class MarcaController {
	
	private MarcaModel marcaModel;
	
	public MarcaController() {
		this.marcaModel = new MarcaModel();
	}
	
	public ArrayList<Marca> cadastrar(Marca marca, ArrayList<Marca> bdMarca) {
		
		this.marcaModel.cadastrar(marca, bdMarca);
		
		
		return bdMarca;
		
		
		// return this.marcaModel.cadastrar(marca);
	}
	
	public ArrayList<Marca> alterar(Marca marca, ArrayList<Marca> bdMarca) {
		return this.marcaModel.alterar(marca, bdMarca);
	}
	
	public ArrayList<Marca> remover(String nome, ArrayList<Marca> bdMarca) {
		
		Marca marca = this.marcaModel.buscarPeloNome(nome, bdMarca);
		
		if(marca != null ) {
			return this.marcaModel.remover(marca, bdMarca);
		} else {
			return null;
		}

	}
	
//	public List<Marca> listar(){
//		return this.marcaModel.listar();
//		
//	}
	
	public Marca buscarPeloNome( String nome, ArrayList<Marca> bdMarca){
		return this.marcaModel.buscarPeloNome(nome, bdMarca);
		
	}
	 

}
