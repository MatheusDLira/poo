package model;

import java.util.ArrayList;
import java.util.List;

import entity.Marca;
import entity.Funcionario;

public class FuncionarioModel {
	
	List<Funcionario> bdFuncionario;
	
	public FuncionarioModel() {
		bdFuncionario = new ArrayList<Funcionario>();
	}
	
	public ArrayList<Funcionario> cadastrar(Funcionario funcionario, ArrayList<Funcionario> bdFuncionario) {
		
		int id = bdFuncionario.size() + 1;
		funcionario.setId(id);
		
		bdFuncionario.add(funcionario);
		
		return bdFuncionario;
	}
	
	public ArrayList<Funcionario> alterar(Funcionario funcionario, ArrayList<Funcionario> bdFuncionario) {
		
		int index = bdFuncionario.indexOf(funcionario);
		
		bdFuncionario.set(index, funcionario);
		
		return bdFuncionario;
	}
	
	public ArrayList<Funcionario> remover(Funcionario funcionario, ArrayList<Funcionario> bdFuncionario) {
		bdFuncionario.remove(funcionario);
		return bdFuncionario;
	}
	
//	public List<Funcionario> listar(){
//		return this.bdFuncionario;
//	}
	
	public Funcionario buscarPeloCodigo( int codigo, ArrayList<Funcionario> bdFuncionario ){
		
		for(int i = 0; i < bdFuncionario.size(); i++) {
    		
			if(bdFuncionario.get(i).getCodigo() == codigo) {
				return bdFuncionario.get(i);
			}
			
    	}
//		
//		for(Funcionario funcionario : bdFuncionario) {
//			
//			if(funcionario.getCodigo().equals(codigo)) {
//				return funcionario;
//			}
//		}
		
		return null;
	}
	
	
	
}