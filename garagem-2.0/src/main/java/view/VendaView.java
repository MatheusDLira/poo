package view;

public class VendaView {
	
	 /*public void menuVenda() {
	        System.out.println("#Menu Venda");
	        System.out.println("01- Registrar");
	        System.out.println("02- Listar");
	        System.out.println("03- Buscar");
	        System.out.println("04- Cancelar");
	        System.out.println("00- Voltar");

	        Scanner sc = new Scanner(System.in);
	        int op = sc.nextInt();

	        switch (op){
	            case 1:
	                registrarVenda();
	                break;
	            case 2:
	                listarVenda();
	                break;
	            case 3:
	                buscarVenda();
	                break;
	            case 4:
	                cancelarVenda();
	                break;
	            case 0: default:
	                menuPrincipal();
	                break;
	        }

	        menuVenda();

	    }

	    public void registrarVenda()  {
	        Scanner sc = new Scanner(System.in);
	        Venda venda= new Venda();

	        System.out.println("# Registro de Venda");
	        
	        boolean placa = false;
	        boolean	codCliente = false;
	        boolean codFuncionario = false;

	        System.out.println("> Informe a placa do veiculo: ");
	        String tmp = sc.nextLine();
	        for (Automovel a : listaAutomoveis){
	            if(a.getPlaca().equals(tmp)){
	            	placa = true;
	                venda.setAutomovel(a);
	                break;
	            }
	        }

	        if(placa == false){
	            System.out.println("Dados invalidos, o registro de venda foi cancelado.\n");
	            menuVenda();
	        }

	        System.out.println("> Informe o codigo do cliente: ");
	        tmp = sc.nextLine();
	        for (Cliente c : listaClientes){
	            if(c.getCodigo().equals(tmp)) {
	            	codCliente = true;
	                venda.setCliente(c);
	                break;
	            }
	        }

	        if(codCliente == false){
	            System.out.println("Dados invalidos, o registro de venda foi cancelado.\n");
	            menuVenda();
	        }
	        
	        System.out.println("> Informe o codigo do funcionario: ");
	        tmp = sc.nextLine();
	        for (Funcionario f : listaFuncionarios){
	            if(f.getCodigo().equals(tmp)){
	            	codFuncionario = true;
	                venda.setFuncionario(f);
	                break;
	            }
	        }
	        
	        if(codFuncionario == false){
	            System.out.println("Dados invalidos, o registro de venda foi cancelado.\n");
	            menuVenda();
	        }
	        
	        System.out.println("> Informe o codigo da venda: ");
	        venda.setCodigo(sc.nextLine());

	        try {
	            System.out.print("> Informe a data da venda: ");
	            String data = sc.nextLine();
	            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
	            venda.setDt_venda(dt);
	        } catch (ParseException e){
	            System.out.println(e.getMessage());
	        }

	        System.out.println("> Informe o valor da venda: ");
	        venda.setValor_venda(sc.nextFloat());
	        
	        venda.setComissao_venda(venda.getValor_venda()/20);
	        
	        listaVendas.add(venda);

	    }

	    public void listarVenda(){
	        System.out.println("#Lista de Vendas");
	        for(Venda v:listaVendas){
	            System.out.println("Código: " + v.getCodigo() + " |\nMarca " + v.getAutomovel().getNomeMarca() + " |\nModelo " + v.getAutomovel().getNomeModelo()
	            + " |\nValor " + v.getValor_venda() + " |\nVendedor " + v.getFuncionario().getNome() + " |\nCliente " + v.getCliente().getNome() + " |\nComissão " + v.getComissao_venda() + "|\n") ;
	        }
	    }

	    public void buscarVenda(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("# Busca de Venda");
	        System.out.println("Informe o código da venda que deseja visualizar: ");
	        String busca = sc.nextLine();
	        for (Venda v : listaVendas){
	            if(v.getCodigo().equals(busca)){
	            	System.out.println("Código: " + v.getCodigo() + " |\nMarca " + v.getAutomovel().getNomeMarca() + " |\nModelo " + v.getAutomovel().getNomeModelo()
	                + " |\nValor " + v.getValor_venda()  + " |\nComissão " + v.getComissao_venda()) ;
	            }
	        }
	    }

	    public void excluirVenda(String codigo){

	        List<Venda> listaParaRemover = new ArrayList<>();

	        for (Venda v : listaVendas){
	            if(v.getCodigo().equals(codigo)){
	                listaParaRemover.add(v);
	            }
	        }

	        listaVendas.removeAll(listaParaRemover);
	    }

	    public void cancelarVenda(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("# Cancelamento de Venda");
	        System.out.println("Informe o código da venda que deseja cancelar: ");
	        String busca = sc.nextLine();

	        List<Venda> listaParaRemover = new ArrayList<>();

	        for (Venda v : listaVendas){
	            if(v.getCodigo().equals(busca)){
	                listaParaRemover.add(v);
	            }
	        }

	        listaVendas.removeAll(listaParaRemover);
	    }

*/
}
