package view;

public class ClienteView {
	
	/*public void menuCliente() {
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
                listarCliente();
                break;
            case 2:
                cadastrarCliente();
                break;
            case 3:
            	alterarCliente();
                break;
            case 4:
                buscarCliente();
                break;
            case 5:
                excluirCliente();
                break;
            case 0: default:
                menuPrincipal();
                break;
        }

        menuCliente();

    }

    public void cadastrarCliente()  {
        Scanner sc = new Scanner(System.in);
        Cliente cliente= new Cliente();

        System.out.println("# Cadastro de Cliente");

        System.out.println("> Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("> Informe o endereco: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.setDt_nascimento(dt);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        cliente.setCodigo(sc.nextLine());

        listaClientes.add(cliente);
    }
    
    public void alterarCliente() {
    	
    	System.out.println("# Alteracao de Cliente");
    	
    	Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do cliente que deseja alterar: ");
        String busca = sc.nextLine();
        for (Cliente c : listaClientes){
            if(c.getNome().equals(busca)){

                System.out.println("> Informe o novo nome: ");
                c.setNome(sc.nextLine());

                System.out.println("> Informe o novo cpf: ");
                c.setCpf(sc.nextLine());

                System.out.println("> Informe o novo endereco: ");
                c.setEndereco(sc.nextLine());

                System.out.println("> Informe o novo telefone: ");
                c.setTelefone(sc.nextLine());

                try {
                    System.out.print("> Informe a nova data de nascimento: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    c.setDt_nascimento(dt);
                } catch (ParseException e){
                    System.out.println(e.getMessage());
                }

                System.out.println("> Informe o novo codigo: ");
                c.setCodigo(sc.nextLine());
            }
        }    	
    }

    public void listarCliente(){
        System.out.println("#Lista de Cliente");
        for(Cliente c:listaClientes){
            System.out.println("Código: " + c.getCodigo() + " |\nNome: " + c.getNome() + " |\nCPF: " + c.getCpf()) ;
        }
    }

    public void buscarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de Cliente");
        System.out.println("Informe o nome do cliente que deseja visualizar: ");
        String busca = sc.nextLine();
        for (Cliente c : listaClientes){
            if(c.getNome().equals(busca)){
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
            }
        }
    }

    public void excluirCliente(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Exclusao de Cliente");
        System.out.println("Informe o nome do cliente que deseja remover: ");
        String busca = sc.nextLine();

        List<Cliente> listaParaRemover = new ArrayList<>();

        for (Cliente c : listaClientes){
            if(c.getNome().equals(busca)){
                listaParaRemover.add(c);
            }
        }

        listaClientes.removeAll(listaParaRemover);
    }
*/
}
