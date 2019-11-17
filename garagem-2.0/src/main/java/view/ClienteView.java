package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import controller.ClienteController;
import entity.Badeco;
import entity.Cliente;
import entity.Gerente;

public class ClienteView {

	private ClienteController clienteController;
	
	public ClienteView() {
		this.clienteController = new ClienteController();
	}
	
	public ArrayList<Cliente> menuCliente(ArrayList<Cliente> bdCliente) {
	        System.out.println("#Menu Cliente");
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
	            	
	            	System.out.println("# Lista de Clientes");
	            	
	            	List<Cliente> clientes = bdCliente;

	            	if(clientes.size() < 1) {
	            		System.out.println("Não existem clientes cadastradas.");
	            	}else {
	            		for(int i = 0; i < clientes.size(); i++) {
	            			System.out.println(" ID: " + clientes.get(i).getId()+ "Nome: " + clientes.get(i).getNome()+
	        	            	    " CPF: " + clientes.get(i).getCpf()+ " Endereço: " + clientes.get(i).getEndereco()
	        	            	    + " Telefone: " + clientes.get(i).getTelefone()
	        	            	    + " Data de Nascimento: " + clientes.get(i).getDt_nascimento()
	        	            	    + " Codigo: " + clientes.get(i).getCodigo());
		            	}
	            	}
	            	
	            	menuCliente(bdCliente);
	                
	                break;
	            case 2:
	            	Cliente cliente = new Cliente();
	            	
	                
	                System.out.println("# Cadastro de cliente ");
	                
	                System.out.println("> Informe o nome: ");
	                cliente.setNome(sc.next());

	                System.out.println("> Informe o cpf: ");
	                cliente.setCpf(sc.next());

	                System.out.println("> Informe o endereco: ");
	                cliente.setEndereco(sc.next());

	                System.out.println("> Informe o telefone: ");
	                cliente.setTelefone(sc.next());

	                try {
	                    System.out.print("> Informe a data de nascimento: ");
	                    String data = sc.next();
	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                    cliente.setDt_nascimento(dt);
	                } catch (ParseException e){
	                    System.out.println(e.getMessage());
	                }

	                System.out.println("> Informe o codigo: ");
	                int codigo = sc.nextInt();
	                for(int i = 0; i < bdCliente.size(); i++) {
	                	if(bdCliente.get(i).getCodigo() == codigo) {
	                		System.out.println("Erro: Este código já está cadastrado.");
	                		menuCliente(bdCliente);
	    	                break;
	                	}
	                }
	                
	                cliente.setCodigo(codigo);
	                //sc.nextLine();
	                
	                int size = bdCliente.size();
	            	bdCliente = this.clienteController.cadastrar(cliente, bdCliente);
	            	
	            	if(bdCliente.size() > size) {
	            		System.out.println("> Cliente cadastrado com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar cliente !");
	            	}
	            	menuCliente(bdCliente);
	                break;
	               
	            case 3:
	            	
	            	System.out.println("# Alterar Cliente");
	            	
	            	System.out.println("> Informe o codigo do cliente:");
	            	sc.nextLine();
	            	int altera = sc.nextInt();
	            	
	            	Cliente clienteAltera = this.clienteController.buscarPeloCodigo(altera, bdCliente);
	            	
	            	if(clienteAltera != null) {
	            		System.out.println(" ID: " + clienteAltera.getId()+ " Nome: " + clienteAltera.getNome()+
	    	            	    " CPF: " + clienteAltera.getCpf()+ " Endereço: " + clienteAltera.getEndereco()
	    	            	    + " Telefone: " + clienteAltera.getTelefone()
	    	            	    + " Data de Nascimento: " + clienteAltera.getDt_nascimento()
	    	            	    + " Codigo: " + clienteAltera.getCodigo());
	            		
	            		
	            		System.out.println("> Informe o nome (Alterado): ");
		                clienteAltera.setNome(sc.next());

		                System.out.println("> Informe o cpf (Alterado): ");
		                clienteAltera.setCpf(sc.next());

		                System.out.println("> Informe o endereco (Alterado): ");
		                clienteAltera.setEndereco(sc.next());

		                System.out.println("> Informe o telefone (Alterado): ");
		                clienteAltera.setTelefone(sc.next());

		                try {
		                    System.out.print("> Informe a data de nascimento (Alterado): ");
		                    String data = sc.nextLine();
		                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		                    clienteAltera.setDt_nascimento(dt);
		                } catch (ParseException e){
		                    System.out.println(e.getMessage());
		                }
	            		
	            		this.clienteController.alterar(clienteAltera, bdCliente);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, cliente não encontrado !");
	            	}
	            	
	            	menuCliente(bdCliente);
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Cliente pelo codigo");
	            	
	            	System.out.println("> Informe o codigo do cliente:");
	            	sc.nextLine();
	            	int busca = sc.nextInt();
	            	
	            	Cliente clienteBusca = this.clienteController.buscarPeloCodigo(busca, bdCliente);
	            	
	            	if(clienteBusca != null) {
	            		System.out.println(" ID: " + clienteBusca.getId()+ "Nome: " + clienteBusca.getNome()+
	            	    " CPF: " + clienteBusca.getCpf()+ " Endereço: " + clienteBusca.getEndereco()
	            	    + " Telefone: " + clienteBusca.getTelefone()
	            	    + " Data de Nascimento: " + clienteBusca.getDt_nascimento()
	            	    + " Codigo: " + clienteBusca.getCodigo()+ " Usuario: ");
		            	
	            	} else {
	            		System.out.println("> OPS, cliente não encontrado !");
	            	}
	            	
	            	menuCliente(bdCliente);
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Cliente");
	            	
	            	System.out.println("> Informe o codigo do cliente:");
	            	
	            	int exclui = sc.nextInt();
	            	
	            	Cliente f = clienteController.buscarPeloCodigo(exclui, bdCliente);
	            	
	            	if(f == null) {
	            		System.out.println("Cliente não existe");;
	            		menuCliente(bdCliente);
	            		break;
	            	}
	            	
	            	if( this.clienteController.remover(f, bdCliente) != null ) {
	            		System.out.println("> Cliente excluido com sucesso !");
	            	} else {
	            		System.out.println("> Cliente não encontrado !");
	            	}
	            	
	            	menuCliente(bdCliente);
	                break;
	            case 0: default:
	                break;
	        }
	        
	        return bdCliente;
	        //menuCliente();

	    }

}
