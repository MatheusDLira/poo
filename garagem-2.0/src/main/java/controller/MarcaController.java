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
	
	public Marca cadastrar(Marca marca) {
		
		Marca marca2;
		
		marca2 = this.marcaModel.cadastrar(marca);
		
		return marca2;
		
		// return this.marcaModel.cadastrar(marca);
	}
	
	public Marca alterar(Marca marca) {
		return this.marcaModel.alterar(marca);
	}
	
	public boolean remover(String nome) {
		
		Marca marca = this.marcaModel.buscarPeloNome(nome);
		
		if(marca != null ) {
			return this.marcaModel.remover(marca);
		} else {
			return false;
		}

	}
	
	public List<Marca> listar(){
		return this.marcaModel.listar();
	}
	
	public Marca buscarPeloNome( String nome ){
		return this.marcaModel.buscarPeloNome(nome);
	}
	 

}
