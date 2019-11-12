package controller;

import entity.Marca;
import model.MarcaModel;

public class MarcaController {
	
	MarcaModel marcaM;
	
	
	public MarcaController() {
		
		this.marcaM = new MarcaModel();
	}

	public void cadastrarMarca( Marca marca) {
		
		 marcaM.cadastrarMarca(marca);
	}
	
	public void alterarMarca() {
		
	}
	
	public void listarMarca(){
		
	}
	
	 public void buscarMarca(){
		 
		 
	 }
	 
	 public void excluirMarca(){
		 
		 
	 }
	 

}
