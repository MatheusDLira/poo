package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import controller.VendaController;
import controller.ModeloController;
import entity.Automovel;
import entity.Cliente;
import entity.Funcionario;
import entity.Modelo;
import entity.Venda;



public class VendaView {

	private VendaController vendaController;
	private ModeloController modeloController;
	
	
	public VendaView() {
		this.vendaController = new VendaController();
		this.modeloController = new ModeloController();
	}
	
	public  ArrayList<Venda> menuVenda(ArrayList<Venda> bdVenda, ArrayList<Automovel> bdAutomovel,
			ArrayList<Cliente> bdCliente, ArrayList<Funcionario> bdFuncionario) {
	        System.out.println("#Menu Venda");
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
	            	
	            	System.out.println("# Lista de Vendas");
	            	
	            	List<Venda> vendas = bdVenda;

	            	
	            	for(int i = 0; i < vendas.size(); i++) {
	            		System.out.println(" ID: " + vendas.get(i).getId() + " Marca: " + vendas.get(i).getAutomovel().getModelo().getMarca().getNomeMarca() + 
	    	            		" Modelo: " + vendas.get(i).getAutomovel().getModelo().getNomeModelo() + " Valor da Venda: "+ vendas.get(i).getValor_venda()
	    	            		+ " Cliente: "+ vendas.get(i).getCliente().getNome()+ " Funcionario: "+ vendas.get(i).getFuncionario().getNome()
	    	            		+ " Data da Venda: "+ vendas.get(i).getDt_venda() +  " Comissão: "+ vendas.get(i).getComissao_venda());
	            	}
	            	
	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                break;
	            case 2:
	            	Venda venda = new Venda();
	            	System.out.println("# Cadastrar Venda");
	            	
	            	System.out.println("# Lista de Automoveis");
	            	
	            	List<Automovel> automoveis = bdAutomovel;

	            	if(automoveis.size() < 1) {
	            		System.out.println("Não existem automoveis cadastrados.");
	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	            		break;
	            		
	            	}else {
	            		for(int i = 0; i < automoveis.size(); i++) {
	            			System.out.println(" ID: " + automoveis.get(i).getId() + " MARCA: " + automoveis.get(i).getModelo().getMarca().getNomeMarca() + 
    	            		" MODELO: " + automoveis.get(i).getModelo().getNomeModelo() + " COR: "+ automoveis.get(i).getCor()
    	            		+ " PLACA: "+ automoveis.get(i).getPlaca()+ " ANO DE FABRICAÇÃO: "+ automoveis.get(i).getAno_fabricacao()
    	            		+ " ANO DO MODELO: "+ automoveis.get(i).getAno_modelo());
		            	}
	            	}
	            	
	            	System.out.println("> Informe a placa do Automóvel:");
	            	String placa = sc.next();
	            	
	            	Automovel auto = vendaController.buscarAutomovel(placa, bdAutomovel);
	            	
	            	
	            	if(modelo == null) {
	            		System.out.println("Este modelo não existe");
	            		menuVenda(bdVenda, bdModelo);
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
		              
		              System.out.println("> Informe a Kilometragem:");
		              float km = sc.nextFloat();
		              
		              System.out.println("> Informe o valor:");
		              float valor = sc.nextFloat();
		              
	            	venda.setCor(cor);
	            	venda.setAno_fabricacao(dt);
	            	venda.setAno_modelo(dt2);
	            	venda.setChassi(chassi);
	            	venda.setPlaca(placa);
	            	venda.setKm(km);
	            	venda.setValor(valor);
	            	venda.setModelo(modelo);
	            	
	            	int size = bdVenda.size();
	            	bdVenda = this.vendaController.cadastrar(venda, bdVenda);
	            	
	            	if(bdVenda.size() > size) {
	            		System.out.println("> Venda cadastrado com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar venda !");
	            	}
	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                break;
	                
	            case 3:
	            	
	            	System.out.println("# Alterar Venda");
	            	
	            	System.out.println("> Informe a	Placa:");
	            	
	            	String altera = sc.next();
	            	
	            	Venda vendaAltera = this.vendaController.buscarPelaPlaca(altera, bdVenda);
	            	
	            	if(vendaAltera != null) {
	            		System.out.println(" ID: " + vendaAltera.getId() + " MARCA: " + vendaAltera.getModelo().getMarca().getNomeMarca() + 
	    	            		" MODELO: " + vendaAltera.getModelo().getNomeModelo() + " COR: "+ vendaAltera.getCor()
	    	            		+ " PLACA: "+ vendaAltera.getPlaca()+ " ANO DE FABRICAÇÃO: "+ vendaAltera.getAno_fabricacao()
	    	            		+ " ANO DO MODELO: "+ vendaAltera.getAno_modelo());
	            		
	            		
	            		System.out.println("> Informe a Modelo (alterado):");
		            	sc.nextLine();
		            	String modeloAlterado = sc.nextLine();
		            	Modelo modeloNovo = modeloController.buscarPeloNome(modeloAlterado, bdModelo);
		            	
		            	
		            	if(modeloNovo == null) {
		            		System.out.println("Esta modelo não existe");
		            		menuVenda(bdVenda, bdModelo);
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
			              
		            	vendaAltera.setCor(corAlterada);
		            	vendaAltera.setAno_fabricacao(dtAlterada);
		            	vendaAltera.setAno_modelo(dt2Alterada);
		            	vendaAltera.setChassi(chassiAlterado);
		            	vendaAltera.setPlaca(placaAlterada);
		            	vendaAltera.setKm(kmAlterada);
		            	vendaAltera.setValor(valorAlterado);
		            	vendaAltera.setModelo(modeloNovo);
	            		
	            		this.vendaController.alterar(vendaAltera, bdVenda);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, venda não encontrado !");
	            	}
	            	
	            	menuVenda(bdVenda, bdModelo);
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Venda pela Placa");
	            	
	            	System.out.println("> Informe a Placa do Venda:");
	            	sc.nextLine();
	            	String busca = sc.nextLine();
	            	
	            	Venda vendaBusca = this.vendaController.buscarPelaPlaca(busca, bdVenda);
	            	
	            	if(vendaBusca != null) {
	            		System.out.println(" ID: " + vendaBusca.getId() + " Marca: " + vendaBusca.getModelo().getMarca().getNomeMarca() + 
	    	            		" MODELO: " + vendaBusca.getModelo().getNomeModelo() + " COR: "+ vendaBusca.getCor() + " PLACA: "+ vendaBusca.getPlaca());
	            	} else {
	            		System.out.println("> OPS, venda não encontrado !");
	            	}
	            	menuVenda(bdVenda, bdModelo);
	            	
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Venda");
	            	
	            	System.out.println("> Informe a placa do venda:");
	            	sc.nextLine();
	            	String exclui = sc.nextLine();
	            	
	            	if( this.vendaController.remover(exclui, bdVenda) != null ) {
	            		System.out.println("> Venda excluido com sucesso !");
	            	} else {
	            		System.out.println("> Venda não encontrado !");
	            	}
	            	
	            	menuVenda(bdVenda, bdModelo);
	                break;
	                
	            case 0: default:
	            	break;
	               
	        }
	        
	        
	        return bdVenda;
	        

	    }

}
