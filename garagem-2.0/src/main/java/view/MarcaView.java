package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import controller.MarcaController;
import entity.Marca;

public class MarcaView {
	
	MarcaController marcaController;
	
	
	 public MarcaView() {
		 
		this.marcaController = new  MarcaController();
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
	                //listarMarca();
	                break;
	            case 2:
	                cadastrarMarca();
	                break;
	            case 3:
	            	//alterarMarca();
	                break;
	            case 4:
	                //buscarMarca();
	                break;
	            case 5:
	                //excluirMarca();
	                break;
	            case 0: default:
	                
	                break;
	        }

	        menuMarca();

	    }

	    public void cadastrarMarca()  {
	        Scanner sc = new Scanner(System.in);
	        Marca marca= new Marca();

	        System.out.println("# Cadastro de Marca");

	        System.out.println("> Informe o nome da marca: ");
	        marca.setNomeMarca(sc.nextLine());

	       

	        marcaController.cadastrarMarca(marca);
	    }

	   /* public void alterarMarca() {
	    	
	    	System.out.println("# Alteracao de Marca");
	    	
	    	Scanner sc = new Scanner(System.in);
	        System.out.println("Informe o chassi do marca que deseja alterar: ");
	        String busca = sc.nextLine();
	        for (Marca a : listaAutomoveis){
	            if(a.getChassi().equals(busca)){

	                System.out.println("> Informe o novo nome da marca: ");
	                a.setNomeMarca(sc.nextLine());

	                System.out.println("> Informe o novo nome do modelo: ");
	                a.setNomeModelo(sc.nextLine());

	                System.out.println("> Informe o novo tipo do modelo: ");
	                a.setTipo(sc.nextLine());

	                System.out.println("> Informe a cor do marca: ");
	                a.setCor(sc.nextLine());

	                System.out.println("> Informe o novo numero do chassi: ");
	                a.setChassi(sc.nextLine());

	                System.out.println("> Informe o novo numero da placa: ");
	                a.setPlaca(sc.nextLine());

	                try {
	                    System.out.print("> Informe a data de fabricacao: ");
	                    String data = sc.nextLine();
	                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	                    a.setAno_fab(dt);
	                    System.out.print("> Informe o novo ano do modelo: ");
	                    String data2 = sc.nextLine();
	                    Date dt2 = new SimpleDateFormat("dd/MM/yyyy").parse(data2);
	                    a.setAno_modelo(dt2);
	                } catch (ParseException e){
	                    System.out.println(e.getMessage());
	                }

	                System.out.println("> Informe a nova kilometragem do marca: ");
	                a.setKm(sc.nextFloat());

	                System.out.println("> Informe o novo valor do marca: ");
	                a.valor = sc.nextFloat();
	            }
	        }  	
	    }
	    */
	  /* public void listarMarca(){
	        System.out.println("#Lista de Automoveis");
	        for(Marca a:listaAutomoveis){
	            System.out.println("Marca: " + a.getNomeMarca() + " |\nModelo: " + a.getNomeModelo() + " |\nCor " + a.getCor() + " |\nAno de Fabricação: " + a.getAno_fabricacao() + " |\nAno do Modelo: " + a.getAno_modelo()) ;
	        }
	    }

	    /*public void buscarMarca(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("# Busca de Automoveis");
	        System.out.println("Informe o chassi do marca que deseja visualizar: ");
	        String busca = sc.nextLine();
	        for (Marca a : listaAutomoveis){
	            if(a.getChassi().equals(busca)){
	                System.out.println("Nome Marca: " + a.getNomeMarca());
	                System.out.println("Nome Modelo: " + a.getNomeModelo());
	            }
	        }
	    }

	    public void excluirMarca(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("# Exclusao de Marca");
	        System.out.println("Informe o chassi do marca que deseja remover: ");
	        String busca = sc.nextLine();

	        List<Marca> listaParaRemover = new ArrayList<>();

	        for (Marca a : listaAutomoveis){
	            if(a.getChassi().equals(busca)){
	                listaParaRemover.add(a);
	            }
	        }

	        listaAutomoveis.removeAll(listaParaRemover);
	 
	    }
*/
}
