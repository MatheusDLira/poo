package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Modelo;
import model.ModeloModel;

public class ModeloController {
	
	private ModeloModel modeloModel;
	
	public ModeloController() {
		this.modeloModel = new ModeloModel();
	}
	
	public Modelo cadastrar(Modelo modelo) {
		
		Modelo modelo2;
		
		modelo2 = this.modeloModel.cadastrar(modelo);
		
		return modelo2;
		
		// return this.modeloModel.cadastrar(modelo);
	}
	
	public Modelo alterar(Modelo modelo) {
		return this.modeloModel.alterar(modelo);
	}
	
	public boolean remover(String nome) {
		
		Modelo modelo = this.modeloModel.buscarPeloNome(nome);
		
		if(modelo != null ) {
			return this.modeloModel.remover(modelo);
		} else {
			return false;
		}

	}
	
	public List<Modelo> listar(){
		return this.modeloModel.listar();
		
	}
	
	public Modelo buscarPeloNome( String nome ){
		return this.modeloModel.buscarPeloNome(nome);
	}
	 

}
