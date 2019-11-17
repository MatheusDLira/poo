package controller;

import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;
import model.FuncionarioModel;

public class FuncionarioController {
	
	private FuncionarioModel funcionarioModel;
	
	public FuncionarioController() {
		this.funcionarioModel = new FuncionarioModel();
	}
	
	public ArrayList<Funcionario> cadastrar(Funcionario funcionario, ArrayList<Funcionario> bdFuncionario) {
		
		this.funcionarioModel.cadastrar(funcionario, bdFuncionario);
		
		
		return bdFuncionario;
		
		
		// return this.funcionarioModel.cadastrar(funcionario);
	}
	
	public ArrayList<Funcionario> alterar(Funcionario funcionario, ArrayList<Funcionario> bdFuncionario) {
		return this.funcionarioModel.alterar(funcionario, bdFuncionario);
	}
	
	public ArrayList<Funcionario> remover(Funcionario f, ArrayList<Funcionario> bdFuncionario) {
		
		Funcionario funcionario = this.funcionarioModel.buscarPeloCodigo(f.getCodigo(), bdFuncionario);
		
		if(funcionario != null ) {
			return this.funcionarioModel.remover(funcionario, bdFuncionario);
		} else {
			return null;
		}

	}
	
//	public List<Funcionario> listar(){
//		return this.funcionarioModel.listar();
//		
//	}
	
	public Funcionario buscarPeloCodigo( int codigo, ArrayList<Funcionario> bdFuncionario){
		return this.funcionarioModel.buscarPeloCodigo(codigo, bdFuncionario);
		
	}
	 

}