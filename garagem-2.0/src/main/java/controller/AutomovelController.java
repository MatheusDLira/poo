package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Modelo;
import entity.Automovel;
import model.AutomovelModel;
import model.ModeloModel;

public class AutomovelController {
	
	private AutomovelModel automovelModel;
	private ModeloModel modeloModel;
	
	public AutomovelController() {
		this.automovelModel = new AutomovelModel();
		this.modeloModel = new ModeloModel();
	}
	
	public ArrayList<Automovel> cadastrar(Automovel automovel, ArrayList<Automovel> bdAutomovel) {
		
		this.automovelModel.cadastrar(automovel, bdAutomovel);
		
		
		return bdAutomovel;
		
		
		// return this.automovelModel.cadastrar(automovel);
	}
	
	public ArrayList<Automovel> alterar(Automovel automovel, ArrayList<Automovel> bdAutomovel) {
		return this.automovelModel.alterar(automovel, bdAutomovel);
	}
	
	public ArrayList<Automovel> remover(String nome, ArrayList<Automovel> bdAutomovel) {
		
		Automovel automovel = this.automovelModel.buscarPelaPlaca(nome, bdAutomovel);
		
		if(automovel != null ) {
			return this.automovelModel.remover(automovel, bdAutomovel);
		} else {
			return null;
		}

	}
	
//	public List<Automovel> listar(){
//		return this.automovelModel.listar();
//		
//	}
	
	public Automovel buscarPelaPlaca( String placa, ArrayList<Automovel> bdAutomovel){
		return this.automovelModel.buscarPelaPlaca(placa, bdAutomovel);
		
	}
	
	public Modelo buscarModelo( String nome, ArrayList<Modelo> bdModelo){
		return this.modeloModel.buscarPeloNome(nome, bdModelo);
		
	}
	 

}