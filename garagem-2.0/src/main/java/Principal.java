import java.util.List;
import java.util.Scanner;

import entity.Modelo;
import view.AutomovelView;
import view.MarcaView;
import view.ModeloView;


public class Principal {
	
	AutomovelView automovelView = new AutomovelView();
	MarcaView marcaView = new MarcaView();
	ModeloView modeloView = new ModeloView();

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
        System.out.println("06- Modelo");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                
                break;
            case 2:
               
                break;
            case 3:
            	
            	automovelView.menuAutomovel();
            	menuPrincipal();
                break;
            case 4:
              
                break;
            case 5:
            	
            	marcaView.menuMarca();
            	menuPrincipal();
                break;
            case 6:
            	
            	modeloView.menuModelo();  
            	menuPrincipal();
            	
                break;
            case 0: default:
                System.exit(0);
                break;
        }

    }




    
}
