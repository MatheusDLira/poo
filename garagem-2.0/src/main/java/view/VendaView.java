
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import controller.VendaController;
import entity.Automovel;
import entity.Badeco;
import entity.Cliente;
import entity.Funcionario;
import entity.Venda;
import entity.Gerente;

public class VendaView {

	private VendaController vendaController;
	
	public VendaView() {
		this.vendaController = new VendaController();
	}
	
	public ArrayList<Venda> menuVenda(ArrayList<Venda> bdVenda, ArrayList<Automovel> bdAutomovel,
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

	            	if(vendas.size() < 1) {
	            		System.out.println("Não existem vendas cadastradas.");
	            	}else {
	            		for(int i = 0; i < vendas.size(); i++) {
		            		System.out.println(" ID: " + vendas.get(i).getId() + " Código: " + vendas.get(i).getCod_venda());
		            	}
	            	}
	            	
	            	menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                
	                break;
	            case 2:
	            	Venda venda = null;
	            	
	                
	                System.out.println("# Cadastro de venda ");
	                
	                System.out.print("> Informe a placa do Automovel: ");
	                Automovel auto = vendaController.buscarAutomovel(sc.next(), bdAutomovel);
	                if(auto == null) {
	                	System.out.println("Automovel não existe");
	                	menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                	break;
	                }
	                venda.setAutomovel(auto);
	                
	                System.out.print("> Informe o codigo do Cliente: ");
	                Cliente cliente = vendaController.buscarCliente(sc.nextInt(), bdCliente);
	                if(auto == null) {
	                	System.out.println("Cliente não existe");
	                	menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                	break;
	                }
	                venda.setCliente(cliente);
	                System.out.print("> Informe o codigo do Funcionario: ");
	                Funcionario fun = vendaController.buscarFuncionario(sc.nextInt(), bdFuncionario);
	                if(auto == null) {
	                	System.out.println("Funcionario não existe");
	                	menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                	break;
	                }
	                venda.setFuncionario(fun);
	                try {
	                    System.out.print("> Informe a data da Venda: ");
	                    String data = sc.next();
	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                    venda.setDt_venda(dt);
	                } catch (ParseException e){
	                    System.out.println(e.getMessage());
	                }

	                System.out.println("> Informe o codigo da Venda: ");
	                int codigo = sc.nextInt();
	                for(int i = 0; i < bdVenda.size(); i++) {
	                	if(bdVenda.get(i).getCod_venda() == codigo) {
	                		System.out.println("Erro: Este código já está cadastrado.");
	                		menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	    	                break;
	                	}
	                }
	                
	                venda.setCod_venda(codigo);
	                //sc.nextLine();
	                
	                System.out.println("> Informe o valor da Venda: ");
	                venda.setValor_venda(sc.nextFloat());
	                venda.setComissao_venda(venda.getValor_venda()/20);
	                System.out.println("> Comissão da venda (5%): "+ venda.getComissao_venda());
	                
	                int size = bdVenda.size();
	            	bdVenda = this.vendaController.cadastrar(venda, bdVenda);
	            	
	            	if(bdVenda.size() > size) {
	            		System.out.println("> Venda cadastrado com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar venda !");
	            	}
	            	menuVenda( bdVenda, bdAutomovel, bdCliente, bdFuncionario);
	                break;
	               
//	            case 3:
//	            	
//	            	System.out.println("# Alterar Venda");
//	            	
//	            	System.out.println("> Informe o codigo do venda:");
//	            	sc.nextLine();
//	            	int altera = sc.nextInt();
//	            	
//	            	Venda vendaAltera = this.vendaController.buscarPeloCodigo(altera, bdVenda);
//	            	
//	            	if(vendaAltera != null) {
//	            		System.out.println(" ID: " + vendaAltera.getId()+
//	            	    " Cargo: "+vendaAltera.getCargo() );
//	            		if(vendaAltera.getCargo() == "Gerente") {
//	            			System.out.println("Departamento: "+ ((Gerente)vendaAltera).getDepartamento());
//	            		}
//	            		if(vendaAltera.getCargo() == "Badeco") {
//	            			System.out.println("Função: "+ ((Badeco)vendaAltera).getFuncao());
//	            		}
//	            		System.out.println(" Nome: " + vendaAltera.getNome()+
//	            	    " CPF: " + vendaAltera.getCpf()+ " Endereço: " + vendaAltera.getEndereco()
//	            	    + " Telefone: " + vendaAltera.getTelefone()
//	            	    + " Data de Nascimento: " + vendaAltera.getDt_nascimento()
//	            	    + " Codigo: " + vendaAltera.getCod_venda()+ " Usuario: " + vendaAltera.getUsuario());
//	            		
//	            		
//	            		System.out.println("> Informe o nome (Alterado): ");
//		                vendaAltera.setNome(sc.next());
//
//		                System.out.println("> Informe o cpf (Alterado): ");
//		                vendaAltera.setCpf(sc.next());
//
//		                System.out.println("> Informe o endereco (Alterado): ");
//		                vendaAltera.setEndereco(sc.next());
//
//		                System.out.println("> Informe o telefone (Alterado): ");
//		                vendaAltera.setTelefone(sc.next());
//
//		                try {
//		                    System.out.print("> Informe a data de nascimento (Alterado): ");
//		                    String data = sc.nextLine();
//		                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
//		                    vendaAltera.setDt_nascimento(dt);
//		                } catch (ParseException e){
//		                    System.out.println(e.getMessage());
//		                }
//
//		                
//
//		                
//		                System.out.println("> Informe o usuario (Alterado): ");
//		                vendaAltera.setUsuario(sc.next());
//
//		                System.out.println("> Informe a senha (Alterado): ");
//		                vendaAltera.setSenha(sc.next());
//		                
//		                System.out.println("> Informe o salário (Alterado): ");
//		                vendaAltera.setSalario(vendaAltera.calculaSalario(sc.nextFloat()));
//		                System.out.println("Salário calculado (Alterado): \n"+vendaAltera.getSalario());
//		                
//		                if(vendaAltera.getCargo() == "Gerente") {
//		                	System.out.println("> Informe o departamento (Alterado): ");
//		                	((Gerente)vendaAltera).setDepartamento(sc.next());
//	            		}
//		                
//		                if(vendaAltera.getCargo() == "Badeco") {
//		                	System.out.println("> Informe a função (Alterado): ");
//		                	((Badeco)vendaAltera).setFuncao(sc.next());
//	            		}
//	            		
//	            		this.vendaController.alterar(vendaAltera, bdVenda);
//	            		
//	            		
//	            	} else {
//	            		System.out.println("> OPS, venda não encontrada !");
//	            	}
//	            	
//	            	menuVenda(bdVenda);
//	            	
//	                break;
//	            case 4:
//	                
//	            	System.out.println("# Buscar Venda pelo codigo");
//	            	
//	            	System.out.println("> Informe o codigo do venda:");
//	            	sc.nextLine();
//	            	int busca = sc.nextInt();
//	            	
//	            	Venda vendaBusca = this.vendaController.buscarPeloCodigo(busca, bdVenda);
//	            	
//	            	if(vendaBusca != null) {
//	            		System.out.println(" ID: " + vendaBusca.getId()+
//	            	    " Cargo: "+vendaBusca.getCargo() );
//	            		if(vendaBusca.getCargo() == "Gerente") {
//	            			System.out.println("Departamento: "+ ((Gerente)vendaBusca).getDepartamento());
//	            		}
//	            		if(vendaBusca.getCargo() == "Badeco") {
//	            			System.out.println("Função: "+ ((Badeco)vendaBusca).getFuncao());
//	            		}
//	            		System.out.println(" Nome: " + vendaBusca.getNome()+
//	            	    " CPF: " + vendaBusca.getCpf()+ " Endereço: " + vendaBusca.getEndereco()
//	            	    + " Telefone: " + vendaBusca.getTelefone()
//	            	    + " Data de Nascimento: " + vendaBusca.getDt_nascimento()
//	            	    + " Codigo: " + vendaBusca.getCod_venda()+ " Usuario: " + vendaBusca.getUsuario());
//		            	
//	            	} else {
//	            		System.out.println("> OPS, venda não encontrado !");
//	            	}
//	            	
//	            	menuVenda(bdVenda);
//	                break;
//	            case 5:
//	                
//	            	System.out.println("# Excluir Venda");
//	            	
//	            	System.out.println("> Informe o codigo do venda:");
//	            	
//	            	int exclui = sc.nextInt();
//	            	
//	            	Venda f = vendaController.buscarPeloCodigo(exclui, bdVenda);
//	            	
//	            	if(f == null) {
//	            		System.out.println("Venda não existe");;
//	            		menuVenda(bdVenda);
//	            		break;
//	            	}
//	            	
//	            	if( this.vendaController.remover(f, bdVenda) != null ) {
//	            		System.out.println("> Venda excluido com sucesso !");
//	            	} else {
//	            		System.out.println("> Venda não encontrada !");
//	            	}
//	            	
//	            	menuVenda(bdVenda);
//	                break;
	            case 0: default:
	                break;
//	        }
//	        
//	        return bdVenda;
//	        //menuVenda();
//
	    }
	        return bdVenda;
}
	
}



//package view;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import controller.VendaController;
//import entity.Automovel;
//import entity.Badeco;
//import entity.Cliente;
//import entity.Funcionario;
//import entity.Gerente;
//import entity.Venda;
//
//
//
//public class VendaView {
//
//	private VendaController vendaController;
//		
//	
//	public VendaView() {
//		this.vendaController = new VendaController();
//	}
//	
//	public  ArrayList<Venda> menuVenda(ArrayList<Venda> bdVenda, ArrayList<Automovel> bdAutomovel,
//			ArrayList<Cliente> bdCliente, ArrayList<Funcionario> bdFuncionario) {
//	        System.out.println("#Menu Venda");
//	        System.out.println("01- Listar");
//	        System.out.println("02- Cadastrar");
//	        System.out.println("03- Alterar");
//	        System.out.println("04- Buscar");
//	        System.out.println("05- Excluir");
//	        System.out.println("00- Voltar");
//
//	        @SuppressWarnings("resource")
//			Scanner sc = new Scanner(System.in);
//	        int op = sc.nextInt();
//
//	        switch (op){
//	            
//	        	case 1:{
//	            	
//		            	System.out.println("# Lista de Vendas");
//		            	
//		            	List<Venda> vendas = bdVenda;
//	
//		            	if(vendas.size() < 1) {
//		            		System.out.println("Não existem vendas cadastradas.");
//		            	}else {
//		            	for(int i = 0; i < bdVenda.size(); i++) {
//		            		System.out.println(" ID: " + vendas.get(i).getId() + " Marca: " + vendas.get(i).getAutomovel().getModelo().getMarca().getNomeMarca() + 
//	        				" Modelo: " + vendas.get(i).getAutomovel().getModelo().getNomeModelo() + " Valor da Venda: "+ vendas.get(i).getValor_venda()
//	                		+ " Cliente: "+ vendas.get(i).getCliente().getNome()+ " Funcionario: "+ vendas.get(i).getFuncionario().getNome()
//	                		+ " Data da Venda: "+ vendas.get(i).getDt_venda() +  " Comissão: "+ vendas.get(i).getComissao_venda());
//			            	}
//		            	}
//		            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		            	break;
//	                }
//	                
//	            case 2: {
//	            	Venda venda = new Venda();
//	            	System.out.println("# Cadastrar Venda");
//	            	
//	            	System.out.println("# Lista de Automoveis");
//	            	
//	            	List<Automovel> automoveis = bdAutomovel;
//
//	            	if(automoveis.size() < 1) {
//	            		System.out.println("Não existem automoveis cadastrados.");
//	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            		break;
//	            		
//	            	}else {
//	            		for(int i = 0; i < automoveis.size(); i++) {
//	            			System.out.println(" ID: " + automoveis.get(i).getId() + " MARCA: " + automoveis.get(i).getModelo().getMarca().getNomeMarca() + 
//    	            		" MODELO: " + automoveis.get(i).getModelo().getNomeModelo() + " COR: "+ automoveis.get(i).getCor()
//    	            		+ " PLACA: "+ automoveis.get(i).getPlaca()+ " ANO DE FABRICAÇÃO: "+ automoveis.get(i).getAno_fabricacao()
//    	            		+ " ANO DO MODELO: "+ automoveis.get(i).getAno_modelo());
//		            	}
//	            	}
//	            	
//	            	System.out.println("> Informe a placa do Automóvel:");
//	            	String placa = sc.next();
//	            	
//	            	Automovel auto = vendaController.buscarAutomovel(placa, bdAutomovel);
//	            	
//	            	
//	            	if(auto == null) {
//	            		System.out.println("Este automóvel não existe");
//	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            		break;
//	            	}
//	            
//	            	System.out.println("# Lista de Funcionarios");
//	            	
//	            	List<Funcionario> funcionarios = bdFuncionario;
//
//	            	if(funcionarios.size() < 1) {
//	            		System.out.println("Não existem funcionarios cadastradas.");
//	            	}else {
//	            		for(int i = 0; i < funcionarios.size(); i++) {
//		            		System.out.println(" ID: " + funcionarios.get(i).getId()+
//		            	    " \nCargo: "+funcionarios.get(i).getCargo() );
//		            		if(funcionarios.get(i).getCargo() == "Gerente") {
//		            			System.out.println(" Departamento: "+ ((Gerente)funcionarios.get(i)).getDepartamento());
//		            		}
//		            		if(funcionarios.get(i).getCargo() == "Badeco") {
//		            			System.out.println("\nFunção: "+ ((Badeco)funcionarios.get(i)).getFuncao());
//		            		}
//		            		System.out.println(" Nome: " + funcionarios.get(i).getNome()+
//		            	    " CPF: " + funcionarios.get(i).getCpf()+ " \nEndereço: " + funcionarios.get(i).getEndereco()
//		            	    + " Telefone: " + funcionarios.get(i).getTelefone()
//		            	    + " Data de Nascimento: " + funcionarios.get(i).getDt_nascimento()
//		            	    + " Codigo: " + funcionarios.get(i).getCodigo()+ " Usuario: " + funcionarios.get(i).getUsuario());
//		            	}
//	            	}
//	            	
//	            	
//	            	System.out.println("> Informe o Codigo do Funcionario:");
//	            	int codigo = sc.nextInt();
//	            	
//	            	Funcionario fun = vendaController.buscarFuncionario(codigo, bdFuncionario);
//	            	
//	            	
//	            	if(fun == null) {
//	            		System.out.println("Este Funcionario não existe");
//	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            		break;
//	            	}
//	            	
//	            	
//	            	System.out.println("# Lista de Clientes");
//	            	
//	            	List<Cliente> clientes = bdCliente;
//
//	            	if(clientes.size() < 1) {
//	            		System.out.println("Não existem clientes cadastradas.");
//	            	}else {
//	            		for(int i = 0; i < clientes.size(); i++) {
//	            			System.out.println(" ID: " + clientes.get(i).getId()+ "Nome: " + clientes.get(i).getNome()+
//	        	            	    " CPF: " + clientes.get(i).getCpf()+ " Endereço: " + clientes.get(i).getEndereco()
//	        	            	    + " Telefone: " + clientes.get(i).getTelefone()
//	        	            	    + " Data de Nascimento: " + clientes.get(i).getDt_nascimento()
//	        	            	    + " Codigo: " + clientes.get(i).getCodigo());
//		            	}
//	            	}
//	            	
//	            	System.out.println("> Informe o Codigo do Cliente:");
//	            	int codigoC = sc.nextInt();
//	            	
//	            	Cliente cliente = vendaController.buscarCliente(codigoC, bdCliente);
//	            	
//	            	
//	            	if(cliente == null) {
//	            		System.out.println("Este Funcionario não existe");
//	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            		break;
//	            	}
//	            	
//	            	
//
//	                System.out.println("> Informe o codigo da Venda: ");
//	                int codigoV = sc.nextInt();
//	                for(int i = 0; i < bdVenda.size(); i++) {
//	                	if(bdFuncionario.get(i).getCodigo() == codigoV) {
//	                		System.out.println("Erro: Este código já está cadastrado.");
//	                		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	    	                break;
//	                	}
//	                }
//	                
//	                
//	                try {
//	                    System.out.print("> Informe a data de Venda: ");
//	                    String data = sc.next();
//	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
//	                    venda.setDt_venda(dt);
//	                } catch (ParseException e){
//	                    System.out.println(e.getMessage());
//	                }
//	            	
//	                System.out.print("> Informe o valor da Venda: ");
//	                float valor = sc.nextFloat();
//	                venda.setValor_venda(valor);
//	                venda.setComissao_venda(venda.getValor_venda() / 20);
//	                
//	                System.out.print("A Comissão dessa venda é (5%) : " + venda.getComissao_venda());
//	                
//	            	int size = bdVenda.size();
//	            	bdVenda = this.vendaController.cadastrar(venda, bdVenda);
//	            	
//	            	if(bdVenda.size() > size) {
//	            		System.out.println("> Venda cadastrada com sucesso!");
//	            	} else {
//	            		System.out.println("> Erro ao cadastrar venda !");
//	            	}
//	            	
//	            		            	
//	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	                break;}
//	
//	            case 3:{
//	            	
//	            	System.out.println("# Alterar Venda");
//	            	
//	            	System.out.println("> Informe a	Placa:");
//	            	
//	            	int altera = sc.nextInt();
//	            	
//	            	Venda vendaAltera = this.vendaController.buscarPeloCodigo(altera, bdVenda);
//	            	
//	            	if(vendaAltera != null) {
//	            		System.out.println(" ID: " + vendaAltera.getId() + " Marca: " + vendaAltera.getAutomovel().getModelo().getMarca().getNomeMarca() + 
//	            				" Modelo: " + vendaAltera.getAutomovel().getModelo().getNomeModelo() + " Valor da Venda: "+ vendaAltera.getValor_venda()
//	    	            		+ " Cliente: "+ vendaAltera.getCliente().getNome()+ " Funcionario: "+ vendaAltera.getFuncionario().getNome()
//	    	            		+ " Data da Venda: "+ vendaAltera.getDt_venda() +  " Comissão: "+ vendaAltera.getComissao_venda());
//	            		
//	            		
//	            		System.out.println("# Lista de Automoveis");
//		            	
//		            	List<Automovel> automoveis = bdAutomovel;
//
//		            	if(automoveis.size() < 1) {
//		            		System.out.println("Não existem automoveis cadastrados.");
//		            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		            		break;
//		            		
//		            	}else {
//		            		for(int i = 0; i < automoveis.size(); i++) {
//		            			System.out.println(" ID: " + automoveis.get(i).getId() + " MARCA: " + automoveis.get(i).getModelo().getMarca().getNomeMarca() + 
//	    	            		" MODELO: " + automoveis.get(i).getModelo().getNomeModelo() + " COR: "+ automoveis.get(i).getCor()
//	    	            		+ " PLACA: "+ automoveis.get(i).getPlaca()+ " ANO DE FABRICAÇÃO: "+ automoveis.get(i).getAno_fabricacao()
//	    	            		+ " ANO DO MODELO: "+ automoveis.get(i).getAno_modelo());
//			            	}
//		            	}
//		            	
//		            	System.out.println("> Informe a placa do Automóvel(Alterado)(Alterado): ");
//		            	String placa = sc.next();
//		            	
//		            	Automovel auto = vendaController.buscarAutomovel(placa, bdAutomovel);
//		            	
//		            	
//		            	if(auto == null) {
//		            		System.out.println("Este automóvel não existe");
//		            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		            		break;
//		            	}
//		            
//		            	System.out.println("# Lista de Funcionarios");
//		            	
//		            	List<Funcionario> funcionarios = bdFuncionario;
//
//		            	if(funcionarios.size() < 1) {
//		            		System.out.println("Não existem funcionarios cadastradas.");
//		            	}else {
//		            		for(int i = 0; i < funcionarios.size(); i++) {
//			            		System.out.println(" ID: " + funcionarios.get(i).getId()+
//			            	    " \nCargo: "+funcionarios.get(i).getCargo() );
//			            		if(funcionarios.get(i).getCargo() == "Gerente") {
//			            			System.out.println(" Departamento: "+ ((Gerente)funcionarios.get(i)).getDepartamento());
//			            		}
//			            		if(funcionarios.get(i).getCargo() == "Badeco") {
//			            			System.out.println("\nFunção: "+ ((Badeco)funcionarios.get(i)).getFuncao());
//			            		}
//			            		System.out.println(" Nome: " + funcionarios.get(i).getNome()+
//			            	    " CPF: " + funcionarios.get(i).getCpf()+ " \nEndereço: " + funcionarios.get(i).getEndereco()
//			            	    + " Telefone: " + funcionarios.get(i).getTelefone()
//			            	    + " Data de Nascimento: " + funcionarios.get(i).getDt_nascimento()
//			            	    + " Codigo: " + funcionarios.get(i).getCodigo()+ " Usuario: " + funcionarios.get(i).getUsuario());
//			            	}
//		            	}
//		            	
//		            	
//		            	System.out.println("> Informe o Codigo do Funcionario(Alterado)(Alterado): ");
//		            	int codigo = sc.nextInt();
//		            	
//		            	Funcionario fun = vendaController.buscarFuncionario(codigo, bdFuncionario);
//		            	
//		            	
//		            	if(fun == null) {
//		            		System.out.println("Este Funcionario não existe");
//		            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		            		break;
//		            	}
//		            	
//		            	
//		            	System.out.println("# Lista de Clientes");
//		            	
//		            	List<Cliente> clientes = bdCliente;
//
//		            	if(clientes.size() < 1) {
//		            		System.out.println("Não existem clientes cadastradas.");
//		            	}else {
//		            		for(int i = 0; i < clientes.size(); i++) {
//		            			System.out.println(" ID: " + clientes.get(i).getId()+ "Nome: " + clientes.get(i).getNome()+
//		        	            	    " CPF: " + clientes.get(i).getCpf()+ " Endereço: " + clientes.get(i).getEndereco()
//		        	            	    + " Telefone: " + clientes.get(i).getTelefone()
//		        	            	    + " Data de Nascimento: " + clientes.get(i).getDt_nascimento()
//		        	            	    + " Codigo: " + clientes.get(i).getCodigo());
//			            	}
//		            	}
//		            	
//		            	System.out.println("> Informe o Codigo do Cliente(Alterado)(Alterado): ");
//		            	int codigoC = sc.nextInt();
//		            	
//		            	Cliente cliente = vendaController.buscarCliente(codigoC, bdCliente);
//		            	
//		            	
//		            	if(cliente == null) {
//		            		System.out.println("Este Funcionario não existe");
//		            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		            		break;
//		            	}
//		            	
//		            	
//
//		                System.out.println("> Informe o codigo(Alterado): ");
//		                int codigoV = sc.nextInt();
//		                for(int i = 0; i < bdVenda.size(); i++) {
//		                	if(bdFuncionario.get(i).getCodigo() == codigoV) {
//		                		System.out.println("Erro: Este código já está cadastrado.");
//		                		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//		    	                break;
//		                	}
//		                }
//		                
//		                
//		                try {
//		                    System.out.print("> Informe a data de Venda(Alterado): ");
//		                    String data = sc.next();
//		                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
//		                    vendaAltera.setDt_venda(dt);
//		                } catch (ParseException e){
//		                    System.out.println(e.getMessage());
//		                }
//		            	
//		                System.out.print("> Informe o valor da Venda(Alterado): ");
//		                float valor = sc.nextFloat();
//		                vendaAltera.setValor_venda(valor);
//		                vendaAltera.setComissao_venda(vendaAltera.getValor_venda() / 20);
//		                
//		                System.out.print("A Comissão dessa vendaAltera é (5%) : " + vendaAltera.getComissao_venda());
//	            		
//	            		bdVenda = this.vendaController.alterar(vendaAltera, bdVenda);
//	            		
//	            		
//	            	} else {
//	            		System.out.println("> OPS, venda não encontrada !");
//	            	}
//	            	
//	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            	
//	                break;}
//	            case 4:
//	                
//	            	System.out.println("# Buscar Venda pelo codigo");
//	            	
//	            	System.out.println("> Informe o codigo da Venda:");
//	            	sc.nextLine();
//	            	int busca = sc.nextInt();
//	            	
//	            	Venda vendaBusca = this.vendaController.buscarPeloCodigo(busca, bdVenda);
//	            	
//	            	if(vendaBusca != null) {
//	            		System.out.println(" ID: " + vendaBusca.getId() + " Marca: " + vendaBusca.getAutomovel().getModelo().getMarca().getNomeMarca() + 
//	            				" Modelo: " + vendaBusca.getAutomovel().getModelo().getNomeModelo() + " Valor da Venda: "+ vendaBusca.getValor_venda()
//	    	            		+ " Cliente: "+ vendaBusca.getCliente().getNome()+ " Funcionario: "+ vendaBusca.getFuncionario().getNome()
//	    	            		+ " Data da Venda: "+ vendaBusca.getDt_venda() +  " Comissão: "+ vendaBusca.getComissao_venda());
//	            	
//	            	} else {
//	            		System.out.println("> OPS, venda não encontrado !");
//	            	}
//	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            	
//	                break;
//	            case 5:
//	                
//	            	System.out.println("# Excluir Venda");
//	            	
//	            	System.out.println("> Informe o codigo do venda:");
//	            	
//	            	int exclui = sc.nextInt();
//	            	
//	            	Venda v = vendaController.buscarPeloCodigo(exclui, bdVenda);
//	            	
//	            	if(v == null) {
//	            		System.out.println("Venda não existe");;
//	            		menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	            		break;
//	            	}
//	            	
//	            	int size = bdVenda.size();
//	            	bdVenda = this.vendaController.remover(v, bdVenda);
//	            	
//	            	if( bdVenda.size() < size ) {
//	            		System.out.println("> Venda excluida com sucesso !");
//	            	} else {
//	            		System.out.println("> Venda não encontrada !");
//	            	}
//	            	
//	            	menuVenda(bdVenda, bdAutomovel, bdCliente, bdFuncionario);
//	                break;
//	                
//	            case 0: default:
//	            	break;
//	        }
//	        
//	        return bdVenda;
//
//	    }
//
//}
