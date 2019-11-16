package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ModeloController;
import controller.MarcaController;
import entity.Marca;
import entity.Modelo;



public class ModeloView {

	private ModeloController modeloController;
	private MarcaController marcaController;
	
	
	public ModeloView() {
		this.modeloController = new ModeloController();
		this.marcaController = new MarcaController();
	}
	
	public ArrayList<Modelo> menuModelo(ArrayList<Modelo> bdModelo, ArrayList<Marca> bdMarca) {
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
	            	
	            	List<Modelo> modelos = bdModelo;

	            	
	            	for(int i = 0; i < modelos.size(); i++) {
	            		System.out.println(" ID: " + modelos.get(i).getId() + " MODELO: " + modelos.get(i).getNomeModelo()
	            		+ " TIPO: "+ modelos.get(i).getTipo() + " MARCA: "+ modelos.get(i).getMarca().getNomeMarca());
	            	}
	            	
	            	menuModelo(bdModelo, bdMarca);
	                break;
	            case 2:
	            	Modelo modelo = new Modelo();
	            	System.out.println("# Cadastrar Modelo");
	            	
	            	System.out.println("# Lista de Marcas");
	            	
	            	List<Marca> marcas = bdMarca;

	            	if(marcas.size() < 1) {
	            		System.out.println("Não existem marcas cadastradas.");
	            		menuModelo(bdModelo, bdMarca);
	            		break;
	            	}else {
	            		for(int i = 0; i < marcas.size(); i++) {
		            		System.out.println(" ID: " + marcas.get(i).getId() + " NOME: " + marcas.get(i).getNomeMarca());
		            	}
	            	}
	            	
	            	System.out.println("> Informe a Marca:");
	            	sc.nextLine();
	            	String nomeMarca = sc.nextLine();
	            	Marca marca = marcaController.buscarPeloNome(nomeMarca, bdMarca);
	            	
	            	
	            	if(marca == null) {
	            		System.out.println("Esta marca não existe");
	            		menuModelo(bdModelo, bdMarca);
	            		break;
	            	}
	            
	            	System.out.println("> Informe a modelo:");
	            	
	            	String nome = sc.nextLine();
	            	
	            	System.out.println("> Informe o Tipo:");
	            	
	            	String tipo = sc.nextLine();
	            	
	            	//Modelo modelo = new Modelo();
	            	modelo.setNomeModelo(nome);
	            	modelo.setTipo(tipo);
	            	modelo.setMarca(marca);
	            	
	            	int size = bdModelo.size();
	            	bdModelo = this.modeloController.cadastrar(modelo, bdModelo);
	            	
	            	if(bdModelo.size() > size) {
	            		System.out.println("> Modelo cadastrada com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar modelo !");
	            	}
	            	menuModelo(bdModelo, bdMarca);
	                break;
	            case 3:
	            	
	            	System.out.println("# Alterar Modelo");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String altera = sc.nextLine();
	            	
	            	Modelo modeloAltera = this.modeloController.buscarPeloNome(altera, bdModelo);
	            	
	            	if(modeloAltera != null) {
	            		System.out.println(" ID: " + modeloAltera.getId() + " NOME: " + modeloAltera.getNomeModelo() + " TIPO: "+ modeloAltera.getTipo());
	            		
	            		
	            		System.out.println("> Informe a modelo(alterada):");
		            	
	            		modeloAltera.setNomeModelo(sc.nextLine());
	            		
	            		this.modeloController.alterar(modeloAltera, bdModelo);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, modelo não encontrada !");
	            	}
	            	
	            	menuModelo(bdModelo, bdMarca);
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Modelo pelo nome");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String busca = sc.nextLine();
	            	
	            	Modelo modeloBusca = this.modeloController.buscarPeloNome(busca, bdModelo);
	            	
	            	if(modeloBusca != null) {
	            		System.out.println(" ID: " + modeloBusca.getId() + " NOME: " + modeloBusca.getNomeModelo()+ " TIPO: "+ modeloBusca.getTipo());
	            	} else {
	            		System.out.println("> OPS, modelo não encontrada !");
	            	}
	            	menuModelo(bdModelo, bdMarca);
	            	
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Modelo");
	            	
	            	System.out.println("> Informe a modelo:");
	            	sc.nextLine();
	            	String exclui = sc.nextLine();
	            	
	            	if( this.modeloController.remover(exclui, bdModelo) != null ) {
	            		System.out.println("> Modelo excluida com sucesso !");
	            	} else {
	            		System.out.println("> Modelo nar encontrada !");
	            	}
	            	
	            	
	                break;
	            case 0: default:
	            	break;
	               
	        }
	        
	        
	        return bdModelo;
	        

	    }

}