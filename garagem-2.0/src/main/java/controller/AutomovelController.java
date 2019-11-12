package controller;

import java.util.List;

import entity.Automovel;
import model.AutomovelModel;

public class AutomovelController {
	
	AutomovelModel automovelM;
	
	
	public AutomovelController() {
		
		this.automovelM = new AutomovelModel();
	}

	public void cadastrarAutomovel(Automovel automovel) {
		
		automovelM.cadastrarAutomovel(automovel);
	}
	
	public void alterarAutomovel(Automovel automovel) {
		
		automovelM.alterarAutomovel(automovel);
		
		
	}
	
	public List<Automovel> listarAutomovel(){
		
		return automovelM.listarAutomovel();
		
		
		
	}
	
	 public Automovel buscarAutomovel(int busca){
		 
		 return automovelM.buscarAutomovel(busca);
		 
		 
		 
	 }
	 
	 public void excluirAutomovel(int busca){
		 
		 automovelM.excluirAutomovel(busca);
		 
	 }
	 

}
