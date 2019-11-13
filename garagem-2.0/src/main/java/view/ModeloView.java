package view;

import java.util.List;
import java.util.Scanner;

import controller.ModeloController;
import entity.Modelo;

public class ModeloView {

	ModeloController modeloController;
	
	public ModeloView() {
		this.modeloController = new ModeloController();
	}
	
	public  void menuModelo() {
	        System.out.println("#Menu Modelo");
	        System.out.println("01- Listar");
	        System.out.println("02- Cadastrar");
	        System.out.println("03- Alterar");
	        System.out.println("04- Buscar");
	        System.out.println("05- Excluir");
	        System.out.println("00- Voltar");

	        Scanner sc = new Scanner(System.in);
	        int op = sc.nextInt();

	        switch (op){
	            case 1:
	            	
	            	System.out.println("# Lista de Modelos");
	            	
	            	List<Modelo> modelos = this.modeloController.listar();

	            	
	            	for(int i = 0; i < modelos.size(); i++) {
	            		System.out.println(" ID: " + modelos.get(i).getId() + " NOME: " + modelos.get(i).getNomeModelo());
	            	}
	            	
	                
	                break;
	            case 2:
	            	System.out.println("# Cadastrar Modelo");
	            	
	            
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String nome = sc.nextLine();
	            	
	            	Modelo modelo = new Modelo();
	            	modelo.setNomeModelo(nome);
	            	
	            	Modelo modeloCadastrada;
	            	modeloCadastrada = this.modeloController.cadastrar(modelo);
	            	
	            	if(modeloCadastrada.getId() != 0) {
	            		System.out.println("> Modelo cadastrada com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar modelo !");
	            	}
	                
	                break;
	            case 3:
	            	
	            	System.out.println("# Alterar Modelo");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String altera = sc.nextLine();
	            	
	            	Modelo modeloAltera = this.modeloController.buscarPeloNome(altera);
	            	
	            	if(modeloAltera != null) {
	            		System.out.println(" ID: " + modeloAltera.getId() + " NOME: " + modeloAltera.getNomeModelo());
	            		
	            		
	            		System.out.println("> Informe a modelo(alterada):");
		            	
	            		modeloAltera.setNomeModelo(sc.nextLine());
	            		
	            		this.modeloController.alterar(modeloAltera);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, modelo não encontrada !");
	            	}
	            	
	            	
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Modelo pelo nome");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String busca = sc.nextLine();
	            	
	            	Modelo modeloBusca = this.modeloController.buscarPeloNome(busca);
	            	
	            	if(modeloBusca != null) {
	            		System.out.println(" ID: " + modeloBusca.getId() + " NOME: " + modeloBusca.getNomeModelo());
	            	} else {
	            		System.out.println("> OPS, modelo não encontrada !");
	            	}
	            	
	            	
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Modelo");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String exclui = sc.nextLine();
	            	
	            	if( this.modeloController.remover(exclui) == true ) {
	            		System.out.println("> Modelo excluida com sucesso !");
	            	} else {
	            		System.out.println("> Modelo nar encontrada !");
	            	}
	            	
	            	
	                break;
	            case 0: default:
	                
	                break;
	        }

	        menuModelo();

	    }

}