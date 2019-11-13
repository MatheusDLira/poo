import java.util.Scanner;

import view.MarcaView;

public class Principal {

    public static void main(String[] args){
    	
    	Principal principal = new Principal();
    	principal.menuPrincipal();
    	


      
    }
    
    
    public void menuPrincipal(){



        System.out.println("#Menu Principal");
        System.out.println("01- Funcionario");
        System.out.println("02- Cliente");
        System.out.println("03- Automovel");
        System.out.println("04- Vendas");
        System.out.println("05- Marcas");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                
                break;
            case 2:
               
                break;
            case 3:
                
                break;
            case 4:
              
                break;
            case 5:
            	MarcaView marcaView = new MarcaView();
            	marcaView.menuMarca();
                break;
            case 0: default:
                System.exit(0);
                break;
        }

    }




    
}
