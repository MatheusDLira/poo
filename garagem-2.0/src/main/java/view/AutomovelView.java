package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controller.AutomovelController;
import entity.Automovel;

public class AutomovelView {
	
	AutomovelController automovelController;
	
	
	 public AutomovelView() {
		 
		this.automovelController = new  AutomovelController();
	}

	public void menuAutomovel() {
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
	                listarAutomovel();
	                break;
	            case 2:
	                cadastrarAutomovel();
	                break;
	            case 3:
	            	alterarAutomovel();
	                break;
	            case 4:
	                buscarAutomovel();
	                break;
	            case 5:
	                excluirAutomovel();
	                break;
	            case 0: default:
	                
	                break;
	        }

	        menuAutomovel();

	    }

	    public void cadastrarAutomovel()  {
	        Scanner sc = new Scanner(System.in);
	        Automovel automovel= new Automovel();

	        System.out.println("# Cadastro de Automovel");
	        

	        System.out.println("> Informe o nome da marca: ");
	        automovel.setNomeMarca(sc.nextLine());

	        System.out.println("> Informe o nome do modelo: ");
	        automovel.setNomeModelo(sc.nextLine());

	        System.out.println("> Informe a cor do automovel: ");
	        automovel.setCor(sc.nextLine());

	        System.out.println("> Informe o numero do chassi: ");
	        automovel.setChassi(sc.nextLine());

	        System.out.println("> Informe o numero da placa: ");
	        automovel.setPlaca(sc.nextLine());

	        try {
	            System.out.print("> Informe a data de fabricacao: ");
	            String data = sc.nextLine();
	            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	            automovel.setAno_fabricacao (dt);
	            System.out.print("> Informe o ano do modelo: ");
	            String data2 = sc.nextLine();
	            Date dt2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
	            automovel.setAno_modelo(dt2);
	        } catch (ParseException e){
	            System.out.println(e.getMessage());
	        }

	        System.out.println("> Informe a nova kilometragem do automovel: ");
	        automovel.setKm(sc.nextFloat());

	        System.out.println("> Informe o valor do automovel: ");
	        automovel.setValor(sc.nextFloat());

	        automovelController.cadastrarAutomovel(automovel);
	    }

	    public void alterarAutomovel() {
	    	
	    	System.out.println("# Alteracao de Automovel");
	    	
	    	Scanner sc = new Scanner(System.in);
	        System.out.println("Informe o id do automovel que deseja alterar: ");
	        int busca = sc.nextInt();
	        Automovel a = new Automovel();
	        a.setIdAutomovel(busca);   
	        
	        		sc.nextLine();
	                System.out.println("> Informe o novo nome da marca: ");
	                a.setNomeMarca(sc.nextLine());

	                System.out.println("> Informe o novo nome do modelo: ");
	                a.setNomeModelo(sc.nextLine());

	               // System.out.println("> Informe o novo tipo do modelo: ");
	               // a.setTipo(sc.nextLine());

	                System.out.println("> Informe a cor do automovel: ");
	                a.setCor(sc.nextLine());

	                System.out.println("> Informe o novo numero do chassi: ");
	                a.setChassi(sc.nextLine());

	                System.out.println("> Informe o novo numero da placa: ");
	                a.setPlaca(sc.nextLine());

	                try {
	                    System.out.print("> Informe a data de fabricacao: ");
	                    String data = sc.nextLine();
	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                    a.setAno_fabricacao(dt);
	                    System.out.print("> Informe o novo ano do modelo: ");
	                    String data2 = sc.nextLine();
	                    Date dt2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
	                    a.setAno_modelo(dt2);
	                } catch (ParseException e){
	                    System.out.println(e.getMessage());
	                }

	                System.out.println("> Informe a nova kilometragem do automovel: ");
	                a.setKm(sc.nextFloat());

	                System.out.println("> Informe o novo valor do automovel: ");
	                a.setValor(sc.nextFloat());
	                automovelController.alterarAutomovel(a);
	            }
	          	
	    
	    
	   public void listarAutomovel(){
	        System.out.println("#Lista de Automoveis");
	        for(Automovel a:automovelController.listarAutomovel()){
	            System.out.println("Marca: " + a.getNomeMarca() + " |\nModelo: " + a.getNomeModelo() + " |\nCor " + a.getCor() + " |\nAno de Fabricação: " + a.getAno_fabricacao() + " |\nAno do Modelo: " + a.getAno_modelo()) ;
	            System.out.println("---------------------------");
	        }
	    }

	    public void buscarAutomovel(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("# Busca de Automoveis");
	        System.out.println("Informe o id do automovel que deseja visualizar: ");
	        int busca = sc.nextInt();
	        Automovel a = automovelController.buscarAutomovel(busca);
	            
	        System.out.println("Marca: " + a.getNomeMarca() + " |\nModelo: " + a.getNomeModelo() + " |\nCor " + a.getCor() + " |\nAno de Fabricação: " + a.getAno_fabricacao() + " |\nAno do Modelo: " + a.getAno_modelo()) ;
            
	            
	        
	    }

	    public void excluirAutomovel(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("# Exclusao de Automovel");
	        System.out.println("Informe o id do automovel que deseja remover: ");
	        int busca = sc.nextInt();
	        automovelController.excluirAutomovel(busca);

	        

	        
	           
	        
	    }

}
