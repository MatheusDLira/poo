package view;

import java.util.List;
import java.util.Scanner;

import controller.MarcaController;
import entity.Marca;

public class MarcaView {

	MarcaController marcaController;
	
	public MarcaView() {
		this.marcaController = new MarcaController();
	}
	
	public void menuMarca() {
	        System.out.println("#Menu Marca");
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
	            	
	            	System.out.println("# Lista de Marcas");
	            	
	            	List<Marca> marcas = this.marcaController.listar();

	            	
	            	for(int i = 0; i < marcas.size(); i++) {
	            		System.out.println(" ID: " + marcas.get(i).getId() + " NOME: " + marcas.get(i).getNomeMarca());
	            	}
	            	
	                
	                break;
	            case 2:
	            	System.out.println("# Cadastrar Marca");
	            	
	            
	            	System.out.println("> Informe a marca:");
	            	sc.nextLine();
	            	String nome = sc.nextLine();
	            	
	            	Marca marca = new Marca();
	            	marca.setNomeMarca(nome);
	            	
	            	Marca marcaCadastrada;
	            	marcaCadastrada = this.marcaController.cadastrar(marca);
	            	
	            	if(marcaCadastrada.getId() != 0) {
	            		System.out.println("> Marca cadastrada com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar marca !");
	            	}
	                
	                break;
	            case 3:
	            	
	            	System.out.println("# Alterar Marca");
	            	
	            	System.out.println("> Informe a marca:");
	            	sc.nextLine();
	            	String altera = sc.nextLine();
	            	
	            	Marca marcaAltera = this.marcaController.buscarPeloNome(altera);
	            	
	            	if(marcaAltera != null) {
	            		System.out.println(" ID: " + marcaAltera.getId() + " NOME: " + marcaAltera.getNomeMarca());
	            		
	            		
	            		System.out.println("> Informe a marca(alterada):");
		            	
	            		marcaAltera.setNomeMarca(sc.nextLine());
	            		
	            		this.marcaController.alterar(marcaAltera);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, marca não encontrada !");
	            	}
	            	
	            	
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Marca pelo nome");
	            	
	            	System.out.println("> Informe a marca:");
	            	sc.nextLine();
	            	String busca = sc.nextLine();
	            	
	            	Marca marcaBusca = this.marcaController.buscarPeloNome(busca);
	            	
	            	if(marcaBusca != null) {
	            		System.out.println(" ID: " + marcaBusca.getId() + " NOME: " + marcaBusca.getNomeMarca());
	            	} else {
	            		System.out.println("> OPS, marca não encontrada !");
	            	}
	            	
	            	
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Marca");
	            	
	            	System.out.println("> Informe a marca:");
	            	sc.nextLine();
	            	String exclui = sc.nextLine();
	            	
	            	if( this.marcaController.remover(exclui) == true ) {
	            		System.out.println("> Marca excluida com sucesso !");
	            	} else {
	            		System.out.println("> Marca nar encontrada !");
	            	}
	            	
	            	
	                break;
	            case 0: default:
	                
	                break;
	        }

	        menuMarca();

	    }

}
