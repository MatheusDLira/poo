package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Modelo;
import model.ModeloModel;

public class ModeloController {
	
	private ModeloModel modeloModel;
	
	public ModeloController() {
		this.modeloModel = new ModeloModel();
	}
	
	public ArrayList<Modelo> cadastrar(Modelo modelo, ArrayList<Modelo> bdModelo) {
		
		this.modeloModel.cadastrar(modelo, bdModelo);
		
		
		return bdModelo;
		
		
		// return this.modeloModel.cadastrar(modelo);
	}
	
	public ArrayList<Modelo> alterar(Modelo modelo, ArrayList<Modelo> bdModelo) {
		return this.modeloModel.alterar(modelo, bdModelo);
	}
	
	public ArrayList<Modelo> remover(String nome, ArrayList<Modelo> bdModelo) {
		
		Modelo modelo = this.modeloModel.buscarPeloNome(nome, bdModelo);
		
		if(modelo != null ) {
			return this.modeloModel.remover(modelo, bdModelo);
		} else {
			return null;
		}

	}
	
//	public List<Modelo> listar(){
//		return this.modeloModel.listar();
//		
//	}
	
	public Modelo buscarPeloNome( String nome, ArrayList<Modelo> bdModelo){
		return this.modeloModel.buscarPeloNome(nome, bdModelo);
		
	}
	 

}
