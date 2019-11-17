package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.AutomovelController;
import controller.ModeloController;
import entity.Modelo;
import entity.Automovel;



public class AutomovelView {

	private AutomovelController automovelController;
	private ModeloController modeloController;
	
	
	public AutomovelView() {
		this.automovelController = new AutomovelController();
		this.modeloController = new ModeloController();
	}
	
	public ArrayList<Automovel> menuAutomovel(ArrayList<Automovel> bdAutomovel, ArrayList<Modelo> bdModelo) {
	        System.out.println("#Menu Automovel");
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
	            	
	            	System.out.println("# Lista de Automoveis");
	            	
	            	List<Automovel> automoveis = bdAutomovel;

	            	
	            	for(int i = 0; i < automoveis.size(); i++) {
	            		System.out.println(" ID: " + automoveis.get(i).getId() + " MARCA: " + automoveis.get(i).getModelo().getMarca().getNomeMarca() + 
	    	            		" MODELO: " + automoveis.get(i).getModelo().getNomeModelo() + " COR: "+ automoveis.get(i).getCor()
	    	            		+ " PLACA: "+ automoveis.get(i).getPlaca()+ " ANO DE FABRICAÇÃO: "+ automoveis.get(i).getAno_fabricacao()
	    	            		+ " ANO DO MODELO: "+ automoveis.get(i).getAno_modelo());
	            	}
	            	
	            	menuAutomovel(bdAutomovel, bdModelo);
	                break;
	            case 2:
	            	Automovel automovel = new Automovel();
	            	System.out.println("# Cadastrar Automovel");
	            	
	            	System.out.println("# Lista de Modelos");
	            	
	            	List<Modelo> modelos = bdModelo;

	            	if(modelos.size() < 1) {
	            		System.out.println("Não existem modelos cadastrados.");
	            		menuAutomovel(bdAutomovel, bdModelo);
	            		break;
	            		
	            	}else {
	            		for(int i = 0; i < modelos.size(); i++) {
		            		System.out.println(" ID: " + modelos.get(i).getId() + " MODELO: " + modelos.get(i).getNomeModelo() 
		            		+ " MARCA: "+ modelos.get(i).getMarca().getNomeMarca());
		            	}
	            		
	            	}
	            	
	            	System.out.println("> Informe a Modelo:");
	            	sc.nextLine();
	            	String nomeModelo = sc.nextLine();
	            	Modelo modelo = modeloController.buscarPeloNome(nomeModelo, bdModelo);
	            	
	            	
	            	if(modelo == null) {
	            		System.out.println("Este modelo não existe");
	            		menuAutomovel(bdAutomovel, bdModelo);
	            		break;
	            	}
	            
	            	System.out.println("> Informe a cor:");
	            	String cor = sc.nextLine();
	            	
	            	Date dt = null;
	            	Date dt2 = null;
	            	
	            	  try {
	                      System.out.print("> Informe a data de fabricacao: ");
	                      String data = sc.nextLine();
	                      dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                      
	                      System.out.print("> Informe o ano do modelo: ");
	                      String data2 = sc.nextLine();
	                      dt2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
	                      
	                  } catch (ParseException e){
	                      System.out.println(e.getMessage());
	                  }
	            	  
	            	  System.out.println("> Informe o Chassi:");
		            	String chassi = sc.nextLine();
		            	
		              System.out.println("> Informe a Placa:");
		              String placa = sc.nextLine();
		              
		              for(int i = 0; i < bdAutomovel.size(); i++) {
	                	if(bdAutomovel.get(i).getPlaca() == placa) {
	                		System.out.println("Erro: Esta placa já está cadastrada.");
	                		menuAutomovel(bdAutomovel, bdModelo);
	    	                break;
	                	}
		              }
		              
		              System.out.println("> Informe a Kilometragem:");
		              float km = sc.nextFloat();
		              
		              System.out.println("> Informe o valor:");
		              float valor = sc.nextFloat();
		              
	            	automovel.setCor(cor);
	            	automovel.setAno_fabricacao(dt);
	            	automovel.setAno_modelo(dt2);
	            	automovel.setChassi(chassi);
	            	automovel.setPlaca(placa);
	            	automovel.setKm(km);
	            	automovel.setValor(valor);
	            	automovel.setModelo(modelo);
	            	
	            	int size = bdAutomovel.size();
	            	bdAutomovel = this.automovelController.cadastrar(automovel, bdAutomovel);
	            	
	            	if(bdAutomovel.size() > size) {
	            		System.out.println("> Automovel cadastrado com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar automovel !");
	            	}
	            	menuAutomovel(bdAutomovel, bdModelo);
	                break;
	                
	            case 3:
	            	
	            	System.out.println("# Alterar Automovel");
	            	
	            	System.out.println("> Informe a	Placa:");
	            	
	            	String altera = sc.next();
	            	
	            	Automovel automovelAltera = this.automovelController.buscarPelaPlaca(altera, bdAutomovel);
	            	
	            	if(automovelAltera != null) {
	            		System.out.println(" ID: " + automovelAltera.getId() + " MARCA: " + automovelAltera.getModelo().getMarca().getNomeMarca() + 
	    	            		" MODELO: " + automovelAltera.getModelo().getNomeModelo() + " COR: "+ automovelAltera.getCor()
	    	            		+ " PLACA: "+ automovelAltera.getPlaca()+ " ANO DE FABRICAÇÃO: "+ automovelAltera.getAno_fabricacao()
	    	            		+ " ANO DO MODELO: "+ automovelAltera.getAno_modelo());
	            		
	            		
	            		System.out.println("> Informe a Modelo (alterado):");
		            	sc.nextLine();
		            	String modeloAlterado = sc.nextLine();
		            	Modelo modeloNovo = modeloController.buscarPeloNome(modeloAlterado, bdModelo);
		            	
		            	
		            	if(modeloNovo == null) {
		            		System.out.println("Esta modelo não existe");
		            		menuAutomovel(bdAutomovel, bdModelo);
		            		break;
		            	}
		            
		            	System.out.println("> Informe a cor (alterada):");
		            	String corAlterada = sc.nextLine();
		            	
		            	Date dtAlterada = null;
		            	Date dt2Alterada = null;
		            	
		            	  try {
		                      System.out.print("> Informe a data de fabricacao (alterada): ");
		                      String data = sc.nextLine();
		                      dtAlterada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		                      
		                      System.out.print("> Informe o ano do modelo (alterado): ");
		                      String data2 = sc.nextLine();
		                      dt2Alterada = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
		                      
		                  } catch (ParseException e){
		                      System.out.println(e.getMessage());
		                  }
		            	  
		            	  System.out.println("> Informe o Chassi (alterado):");
			            	String chassiAlterado = sc.nextLine();
			            	
			              System.out.println("> Informe a Placa (alterado):");
			              String placaAlterada = sc.nextLine();
			              
			              System.out.println("> Informe a Kilometragem (alterada):");
			              float kmAlterada = sc.nextFloat();
			              
			              System.out.println("> Informe o valor (alterado):");
			              float valorAlterado = sc.nextFloat();
			              
		            	automovelAltera.setCor(corAlterada);
		            	automovelAltera.setAno_fabricacao(dtAlterada);
		            	automovelAltera.setAno_modelo(dt2Alterada);
		            	automovelAltera.setChassi(chassiAlterado);
		            	automovelAltera.setPlaca(placaAlterada);
		            	automovelAltera.setKm(kmAlterada);
		            	automovelAltera.setValor(valorAlterado);
		            	automovelAltera.setModelo(modeloNovo);
	            		
	            		this.automovelController.alterar(automovelAltera, bdAutomovel);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, automovel não encontrado !");
	            	}
	            	
	            	menuAutomovel(bdAutomovel, bdModelo);
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Automovel pela Placa");
	            	
	            	System.out.println("> Informe a Placa do Automovel:");
	            	sc.nextLine();
	            	String busca = sc.nextLine();
	            	
	            	Automovel automovelBusca = this.automovelController.buscarPelaPlaca(busca, bdAutomovel);
	            	
	            	if(automovelBusca != null) {
	            		System.out.println(" ID: " + automovelBusca.getId() + " Marca: " + automovelBusca.getModelo().getMarca().getNomeMarca() + 
	    	            		" MODELO: " + automovelBusca.getModelo().getNomeModelo() + " COR: "+ automovelBusca.getCor() + " PLACA: "+ automovelBusca.getPlaca());
	            	} else {
	            		System.out.println("> OPS, automovel não encontrado !");
	            	}
	            	menuAutomovel(bdAutomovel, bdModelo);
	            	
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Automovel");
	            	
	            	System.out.println("> Informe a placa do automovel:");
	            	sc.nextLine();
	            	String exclui = sc.nextLine();
	            	
	            	if( this.automovelController.remover(exclui, bdAutomovel) != null ) {
	            		System.out.println("> Automovel excluido com sucesso !");
	            	} else {
	            		System.out.println("> Automovel não encontrado !");
	            	}
	            	
	            	menuAutomovel(bdAutomovel, bdModelo);
	                break;
	                
	            case 0: default:
	            	break;
	               
	        }
	        
	        
	        return bdAutomovel;
	        

	    }

}
