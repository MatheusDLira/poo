import config.SQLConnection;
import view.AutomovelView;
import view.FuncionarioView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

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
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                FuncionarioView f = new FuncionarioView();
                f.menuFuncionario();
                break;
            case 2:
               
                break;
            case 3:
                AutomovelView a = new AutomovelView();
                a.menuAutomovel();
                break;
            case 4:
              //  menuVenda();
                break;
            case 0: default:
                System.exit(0);
                break;
        }

    }




    
}
