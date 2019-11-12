package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controller.AutomovelController;
import controller.FuncionarioController;
import entity.Badeco;
import entity.Funcionario;
import entity.Gerente;

public class FuncionarioView {
	FuncionarioController funcionarioController;
	
	
	public FuncionarioView(){
		
		
		this.funcionarioController = new FuncionarioController();
	}
	
	
	public void menuFuncionario() {
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
                listarFuncionario();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
            	 alterarFuncionario();
                break;
            case 4:
               // buscarFuncionario();
                break;
            case 5:
                //excluirFuncionario();
                break;
            case 0: default:
                //menuPrincipal();
                break;
        }

        menuFuncionario();

    }
	public void cadastrarFuncionario()  {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("# Cadastro de funcionario ");

        System.out.println("Informe o tipo de funcionario que deseja cadastrar: ");
        System.out.println("1 - Funcionario comum ");
        System.out.println("2 - Gerente ");
        System.out.println("3 - Badeco ");
        int v = sc.nextInt();
        
        switch (v){
        case 1:{
            Funcionario funcionario = new Funcionario();
            funcionario.setCargo("funcionario");
            armazena(funcionario);
            break;}
        case 2:{
        	Funcionario funcionario = new Gerente();
        	funcionario.setCargo("Gerente");
        	armazena(funcionario);
            break;}
        case 3:{
        	Funcionario funcionario = new Badeco();
        	funcionario.setCargo("Badeco");
        	armazena(funcionario);
            break;}
        default:{
        	System.out.println("Entrada inválida!");
            menuFuncionario();}
            break;
        }
        
    }
    
    public void armazena(Funcionario f) {
    	Scanner sc = new Scanner(System.in);
    	
    	
    	System.out.println("> Informe o nome: ");
        f.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        f.setCpf(sc.nextLine());

        System.out.println("> Informe o endereco: ");
        f.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        f.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            f.setDt_nascimento(dt);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        f.setCodigo(sc.nextInt());
        
       /* if(f instanceof Gerente) {
        	System.out.println("> Informe o departamento: ");
            ((Gerente) f).setDepartamento(sc.nextLine());
        }
        
        if(f instanceof Badeco) {
        	System.out.println("> Informe a função: ");
            ((Badeco) f).setFuncao(sc.nextLine());
        }*/

        
        
        //f.setSalario(1000);
        //f.setSalario(f.calcularSalario());
        sc.nextLine();
        System.out.println("> Informe o usuario: ");
        f.setUsuario(sc.nextLine());

        System.out.println("> Informe a senha: ");
        f.setSenha(sc.nextLine());
        

        
        funcionarioController.cadastrarFuncionario(f);
        
    }
    
    
    public void alterarFuncionario() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("# Alteracao de funcionario ");
    	
    	System.out.println("Informe o id do funcionario que deseja alterar");
        int busca = sc.nextInt();
        Funcionario a = new Funcionario();
        a.setCodigo(busca);
        /*for (Funcionario f : listaFuncionarios){
            if(f.getNome().equals(busca)){*/
                sc.nextLine();
            	System.out.println("> Informe o novo nome: ");
                a.setNome(sc.nextLine());

                System.out.println("> Informe o novo cpf: ");
                a.setCpf(sc.nextLine());

                System.out.println("> Informe o novo endereco: ");
                a.setEndereco(sc.nextLine());

                System.out.println("> Informe o novo telefone: ");
                a.setTelefone(sc.nextLine());

                try {
                    System.out.print("> Informe a nova data de nascimento: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    a.setDt_nascimento(dt);
                } catch (ParseException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("> Informe o novo codigo: ");
                a.setCodigo(sc.nextInt());
                sc.nextLine();
                System.out.println("> Informe o novo usuario: ");
                a.setUsuario(sc.nextLine());

                System.out.println("> Informe a nova senha: ");
                a.setSenha(sc.nextLine());
            }
        
    

    public void listarFuncionario(){
        System.out.println("#Lista de funcionarios");
        for(Funcionario f:funcionarioController.listarFuncionario()){
            System.out.println("Código: "+ f.getCodigo() + " |\nNome: " + f.getNome() + " |\nCPF: " + f.getCpf() + " |\nUsuário: " + f.getUsuario() + " |\nCargo: "  + f.getCargo()) ;
            System.out.println("---------------------------");
}
        }
    

   /* public void buscarFuncionario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        System.out.println("Informe o nome do funcionario que deseja visualizar: ");
        String busca = sc.nextLine();
        for (Funcionario f : listaFuncionarios){
            if(f.getNome().equals(busca)){
                System.out.println("Nome: " + f.getNome());
                System.out.println("CPF: " + f.getCpf());
            }
        }
    }

    public void excluirFuncionario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Exclusao de funcionario");
        System.out.println("Informe o nome do funcionario que deseja remover: ");
        String busca = sc.nextLine();

        List<Funcionario> listaParaRemover = new ArrayList<>();

        for (Funcionario f : listaFuncionarios){
            if(f.getNome().equals(busca)){
                listaParaRemover.add(f);
            }
        }

        listaFuncionarios.removeAll(listaParaRemover);
    }
*/

}
