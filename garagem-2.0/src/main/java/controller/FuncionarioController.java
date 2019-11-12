package controller;

import java.util.List;

import entity.Funcionario;
import model.FuncionarioModel;

public class FuncionarioController {
	
	FuncionarioModel funcionarioM;
	
	
	public FuncionarioController() {
		
		this.funcionarioM = new FuncionarioModel();
	}

	public void cadastrarFuncionario(Funcionario funcionario) {
		
		funcionarioM.cadastrarFuncionario(funcionario);
	}
	
	public void alterarFuncionario(Funcionario funcionario) {
		
		funcionarioM.alterarFuncionario(funcionario);
		
		
	}
	
	public List<Funcionario> listarFuncionario(){
		
		return funcionarioM.listarFuncionario();
		
		
		
	}
	
	 public Funcionario buscarFuncionario(int busca){
		 
		 return funcionarioM.buscarFuncionario(busca);
		 
		 
		 
	 }
	 
	 public void excluirFuncionario(int busca){
		 
		 funcionarioM.excluirFuncionario(busca);
		 
	 }
	 

}
