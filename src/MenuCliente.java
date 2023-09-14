import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuCliente extends Menu{
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;
    private ClienteService clienteService;
    public MenuCliente(List<Veiculo> veiculos, List<Cliente> clientes, List<Aluguel> alugueis) {
        this.clientes = clientes;
        this.clienteService = new ClienteFisicoService();
        int opcao;

        List<String> textoOpcoes = new ArrayList<>();
        textoOpcoes.add("Buscar cliente");
        textoOpcoes.add("Cadastrar cliente");
        textoOpcoes.add("Voltar");
        opcao = criarMenu(textoOpcoes);
        executarOpcao(opcao);
    }

    public void executarOpcao(int opcao) {
        if (opcao == 1) {
            buscarCliente(clientes);
        } else if (opcao == 2) {
            cadastrarCliente(clientes);
        } else if (opcao == 3) {
            Menu menu = new MenuPrincipal(veiculos,clientes,alugueis);
        }
    }

    public void cadastrarCliente(List<Cliente> clientes){
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome do cliente:");
        String nomeCliente = scan.nextLine();

        System.out.println("Endereço do cliente:");
        String enderecoCliente = scan.nextLine();

        System.out.println("Telefone do cliente:");
        String telefoneCliente = scan.nextLine();

        System.out.println("Qual o cliente? (fisico ou juridico)");
        String tipoCliente = scan.nextLine();

        if (tipoCliente == "fisico"){
            System.out.println("CPF do cliente:");
            String cpfCliente = scan.nextLine();

            clienteService.cadastrarCliente(nomeCliente, telefoneCliente, enderecoCliente, cpfCliente);

        }else if(tipoCliente == "juridico"){
            System.out.println("CNPJ do cliente:");
            String cnpjCliente = scan.nextLine();

            clienteService.cadastrarCliente(nomeCliente, telefoneCliente, enderecoCliente, cnpjCliente);
        }

        System.out.println("Cliente cadastrado");
        Menu menu = new MenuCliente(veiculos,clientes,alugueis);
    }

    public void buscarCliente(List<Cliente> clientes){
        String nome;
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o nome do cliente:");
        nome = scan.nextLine();

        clienteService.buscarCliente(clientes, nome);

        Menu menu = new MenuCliente(veiculos,clientes,alugueis);
    }
}
