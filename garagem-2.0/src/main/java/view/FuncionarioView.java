package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import controller.FuncionarioController;
import entity.Badeco;
import entity.Funcionario;
import entity.Gerente;

public class FuncionarioView {

	private FuncionarioController funcionarioController;
	
	public FuncionarioView() {
		this.funcionarioController = new FuncionarioController();
	}
	
	public ArrayList<Funcionario> menuFuncionario(ArrayList<Funcionario> bdFuncionario) {
	        System.out.println("#Menu Funcionario");
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
	            	
	            	System.out.println("# Lista de Funcionarios");
	            	
	            	List<Funcionario> funcionarios = bdFuncionario;

	            	if(funcionarios.size() < 1) {
	            		System.out.println("Não existem funcionarios cadastradas.");
	            	}else {
	            		for(int i = 0; i < funcionarios.size(); i++) {
		            		System.out.println(" ID: " + funcionarios.get(i).getId()+
		            	    " \nCargo: "+funcionarios.get(i).getCargo() );
		            		if(funcionarios.get(i).getCargo() == "Gerente") {
		            			System.out.println(" Departamento: "+ ((Gerente)funcionarios.get(i)).getDepartamento());
		            		}
		            		if(funcionarios.get(i).getCargo() == "Badeco") {
		            			System.out.println("\nFunção: "+ ((Badeco)funcionarios.get(i)).getFuncao());
		            		}
		            		System.out.println(" Nome: " + funcionarios.get(i).getNome()+
		            	    " CPF: " + funcionarios.get(i).getCpf()+ " \nEndereço: " + funcionarios.get(i).getEndereco()
		            	    + " Telefone: " + funcionarios.get(i).getTelefone()
		            	    + " Data de Nascimento: " + funcionarios.get(i).getDt_nascimento()
		            	    + " Codigo: " + funcionarios.get(i).getCodigo()+ " Usuario: " + funcionarios.get(i).getUsuario());
		            	}
	            	}
	            	
	            	menuFuncionario(bdFuncionario);
	                
	                break;
	            case 2:
	            	Funcionario funcionario = null;
	            	
	                
	                System.out.println("# Cadastro de funcionario ");
	                System.out.println("Informe o tipo de funcionario que deseja cadastrar: ");
	                System.out.println("1 - Funcionario comum ");
	                System.out.println("2 - Gerente ");
	                System.out.println("3 - Badeco ");
	                int v = sc.nextInt();
	                switch (v){
	                case 1: 
	                	funcionario = new Funcionario();
	                    funcionario.setCargo("funcionario Comum");
	                    break;
	                case 2:
	                	funcionario = new Gerente();
	                	funcionario.setCargo("Gerente");
	                    break;
	                case 3:
	                	funcionario = new Badeco();
	                	funcionario.setCargo("Badeco");
	                    break;
	                default:
	                	System.out.println("Entrada inválida!");
	                	menuFuncionario(bdFuncionario);
	                    break;}
	                
	                
	                System.out.println("> Informe o nome: ");
	                funcionario.setNome(sc.next());

	                System.out.println("> Informe o cpf: ");
	                funcionario.setCpf(sc.next());

	                System.out.println("> Informe o endereco: ");
	                funcionario.setEndereco(sc.next());

	                System.out.println("> Informe o telefone: ");
	                funcionario.setTelefone(sc.next());

	                try {
	                    System.out.print("> Informe a data de nascimento: ");
	                    String data = sc.next();
	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                    funcionario.setDt_nascimento(dt);
	                } catch (ParseException e){
	                    System.out.println(e.getMessage());
	                }

	                System.out.println("> Informe o codigo: ");
	                int codigo = sc.nextInt();
	                for(int i = 0; i < bdFuncionario.size(); i++) {
	                	if(bdFuncionario.get(i).getCodigo() == codigo) {
	                		System.out.println("Erro: Este código já está cadastrado.");
	                		menuFuncionario(bdFuncionario);
	    	                break;
	                	}
	                }
	                
	                funcionario.setCodigo(codigo);
	                //sc.nextLine();
	                
	                System.out.println("> Informe o usuario: ");
	                funcionario.setUsuario(sc.next());

	                System.out.println("> Informe a senha: ");
	                funcionario.setSenha(sc.next());
	                
	                System.out.println("> Informe o salário: ");
	                funcionario.setSalario(funcionario.calculaSalario(sc.nextFloat()));
	                System.out.println("Salário calculado: \n"+funcionario.getSalario());
	                
	                if(funcionario.getCargo() == "Gerente") {
	                	System.out.println("> Informe o departamento: ");
	                	((Gerente)funcionario).setDepartamento(sc.next());
            		}
	                
	                if(funcionario.getCargo() == "Badeco") {
	                	System.out.println("> Informe a função: ");
	                	((Badeco)funcionario).setFuncao(sc.next());
            		}
	                
	                int size = bdFuncionario.size();
	            	bdFuncionario = this.funcionarioController.cadastrar(funcionario, bdFuncionario);
	            	
	            	if(bdFuncionario.size() > size) {
	            		System.out.println("> Funcionario cadastrado com sucesso!");
	            	} else {
	            		System.out.println("> Erro ao cadastrar funcionario !");
	            	}
	            	menuFuncionario(bdFuncionario);
	                break;
	               
	            case 3:
	            	
	            	System.out.println("# Alterar Funcionario");
	            	
	            	System.out.println("> Informe o codigo do funcionario:");
	            	sc.nextLine();
	            	int altera = sc.nextInt();
	            	
	            	Funcionario funcionarioAltera = this.funcionarioController.buscarPeloCodigo(altera, bdFuncionario);
	            	
	            	if(funcionarioAltera != null) {
	            		System.out.println(" ID: " + funcionarioAltera.getId()+
	            	    " Cargo: "+funcionarioAltera.getCargo() );
	            		if(funcionarioAltera.getCargo() == "Gerente") {
	            			System.out.println("Departamento: "+ ((Gerente)funcionarioAltera).getDepartamento());
	            		}
	            		if(funcionarioAltera.getCargo() == "Badeco") {
	            			System.out.println("Função: "+ ((Badeco)funcionarioAltera).getFuncao());
	            		}
	            		System.out.println(" Nome: " + funcionarioAltera.getNome()+
	            	    " CPF: " + funcionarioAltera.getCpf()+ " Endereço: " + funcionarioAltera.getEndereco()
	            	    + " Telefone: " + funcionarioAltera.getTelefone()
	            	    + " Data de Nascimento: " + funcionarioAltera.getDt_nascimento()
	            	    + " Codigo: " + funcionarioAltera.getCodigo()+ " Usuario: " + funcionarioAltera.getUsuario());
	            		
	            		
	            		System.out.println("> Informe o nome (Alterado): ");
		                funcionarioAltera.setNome(sc.next());

		                System.out.println("> Informe o cpf (Alterado): ");
		                funcionarioAltera.setCpf(sc.next());

		                System.out.println("> Informe o endereco (Alterado): ");
		                funcionarioAltera.setEndereco(sc.next());

		                System.out.println("> Informe o telefone (Alterado): ");
		                funcionarioAltera.setTelefone(sc.next());

		                try {
		                    System.out.print("> Informe a data de nascimento (Alterado): ");
		                    String data = sc.nextLine();
		                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		                    funcionarioAltera.setDt_nascimento(dt);
		                } catch (ParseException e){
		                    System.out.println(e.getMessage());
		                }

		                

		                
		                System.out.println("> Informe o usuario (Alterado): ");
		                funcionarioAltera.setUsuario(sc.next());

		                System.out.println("> Informe a senha (Alterado): ");
		                funcionarioAltera.setSenha(sc.next());
		                
		                System.out.println("> Informe o salário (Alterado): ");
		                funcionarioAltera.setSalario(funcionarioAltera.calculaSalario(sc.nextFloat()));
		                System.out.println("Salário calculado (Alterado): \n"+funcionarioAltera.getSalario());
		                
		                if(funcionarioAltera.getCargo() == "Gerente") {
		                	System.out.println("> Informe o departamento (Alterado): ");
		                	((Gerente)funcionarioAltera).setDepartamento(sc.next());
	            		}
		                
		                if(funcionarioAltera.getCargo() == "Badeco") {
		                	System.out.println("> Informe a função (Alterado): ");
		                	((Badeco)funcionarioAltera).setFuncao(sc.next());
	            		}
	            		
	            		this.funcionarioController.alterar(funcionarioAltera, bdFuncionario);
	            		
	            		
	            	} else {
	            		System.out.println("> OPS, funcionario não encontrada !");
	            	}
	            	
	            	menuFuncionario(bdFuncionario);
	            	
	                break;
	            case 4:
	                
	            	System.out.println("# Buscar Funcionario pelo codigo");
	            	
	            	System.out.println("> Informe o codigo do funcionario:");
	            	sc.nextLine();
	            	int busca = sc.nextInt();
	            	
	            	Funcionario funcionarioBusca = this.funcionarioController.buscarPeloCodigo(busca, bdFuncionario);
	            	
	            	if(funcionarioBusca != null) {
	            		System.out.println(" ID: " + funcionarioBusca.getId()+
	            	    " Cargo: "+funcionarioBusca.getCargo() );
	            		if(funcionarioBusca.getCargo() == "Gerente") {
	            			System.out.println("Departamento: "+ ((Gerente)funcionarioBusca).getDepartamento());
	            		}
	            		if(funcionarioBusca.getCargo() == "Badeco") {
	            			System.out.println("Função: "+ ((Badeco)funcionarioBusca).getFuncao());
	            		}
	            		System.out.println(" Nome: " + funcionarioBusca.getNome()+
	            	    " CPF: " + funcionarioBusca.getCpf()+ " Endereço: " + funcionarioBusca.getEndereco()
	            	    + " Telefone: " + funcionarioBusca.getTelefone()
	            	    + " Data de Nascimento: " + funcionarioBusca.getDt_nascimento()
	            	    + " Codigo: " + funcionarioBusca.getCodigo()+ " Usuario: " + funcionarioBusca.getUsuario());
		            	
	            	} else {
	            		System.out.println("> OPS, funcionario não encontrado !");
	            	}
	            	
	            	menuFuncionario(bdFuncionario);
	                break;
	            case 5:
	                
	            	System.out.println("# Excluir Funcionario");
	            	
	            	System.out.println("> Informe o codigo do funcionario:");
	            	
	            	int exclui = sc.nextInt();
	            	
	            	Funcionario f = funcionarioController.buscarPeloCodigo(exclui, bdFuncionario);
	            	
	            	if(f == null) {
	            		System.out.println("Funcionario não existe");;
	            		menuFuncionario(bdFuncionario);
	            		break;
	            	}
	            	
	            	if( this.funcionarioController.remover(f, bdFuncionario) != null ) {
	            		System.out.println("> Funcionario excluido com sucesso !");
	            	} else {
	            		System.out.println("> Funcionario não encontrada !");
	            	}
	            	
	            	menuFuncionario(bdFuncionario);
	                break;
	            case 0: default:
	                break;
	        }
	        
	        return bdFuncionario;
	        //menuFuncionario();

	    }

}
