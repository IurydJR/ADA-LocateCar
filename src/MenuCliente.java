import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashSet;

public class MenuCliente extends Menu{

    HashSet<Veiculo> veiculos;
    HashSet<Aluguel> alugueis;
    HashSet<Cliente> clientes;

    private ClienteService clienteService;
    public MenuCliente(HashSet<Veiculo> veiculos, HashSet<Cliente> clientes, HashSet<Aluguel> alugueis) {
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

    public void cadastrarCliente(HashSet<Cliente> clientes) {
        Scanner scan = new Scanner(System.in);
        ClienteFisicoService clienteFisicoService = new ClienteFisicoService();
        ClienteJuridicoService clienteJuridicoService = new ClienteJuridicoService();

        System.out.println("Nome do cliente:");
        String nomeCliente = scan.nextLine();

        System.out.println("Endereço do cliente:");
        String enderecoCliente = scan.nextLine();

        System.out.println("Telefone do cliente:");
        String telefoneCliente = scan.nextLine();

        System.out.println("Qual o cliente? (fisico ou juridico)");
        String tipoCliente = scan.nextLine();

        if (tipoCliente.equals("fisico")) {
            System.out.println("CPF do cliente:");
            String cpfCliente = scan.nextLine();

            boolean clienteJaCadastrado = false;
            for (Cliente cliente : clientes) {
                if (cliente instanceof ClienteFisico) {
                    ClienteFisico clienteFisico = (ClienteFisico) cliente;
                    if (clienteFisico.getCpf().equals(cpfCliente)) {
                        System.out.println("Cliente já cadastrado");
                        clienteJaCadastrado = true;
                        break;
                    }
                }
            }

            if (!clienteJaCadastrado) {
                clienteFisicoService.cadastrarCliente(clientes, nomeCliente, telefoneCliente, enderecoCliente, cpfCliente);
                System.out.println("Cliente cadastrado");
            }
        } else if (tipoCliente.equals("juridico")) {
            System.out.println("CNPJ do cliente:");
            String cnpjCliente = scan.nextLine();

            boolean clienteJaCadastrado = false;
            for (Cliente cliente : clientes) {
                if (cliente instanceof ClienteJuridico) {
                    ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
                    if (clienteJuridico.getCnpj().equals(cnpjCliente)) {
                        System.out.println("Cliente já cadastrado");
                        clienteJaCadastrado = true;
                        break;
                    }
                }
            }

            if (!clienteJaCadastrado) {
                clienteJuridicoService.cadastrarCliente(clientes, nomeCliente, telefoneCliente, enderecoCliente, cnpjCliente);
                System.out.println("Cliente cadastrado");
            }
        }

        Menu menu = new MenuCliente(veiculos, clientes, alugueis);
    }

    public void buscarCliente(HashSet<Cliente> clientes){
        String nome;
        String tipoCliente;
        Scanner scan = new Scanner(System.in);
        ClienteService clienteFisicoService = new ClienteFisicoService();
        ClienteService clienteJuridicoService = new ClienteJuridicoService();

        System.out.println("Insira o tipo de cliente (fisico/juridico):");
        tipoCliente = scan.nextLine().toLowerCase();

        System.out.println("Insira o nome do cliente:");
        nome = scan.nextLine().toLowerCase();

        if (tipoCliente.equals("fisico")) {
            clienteFisicoService.buscarCliente(clientes, nome);
        } else if(tipoCliente.equals("juridico")){
            clienteJuridicoService.buscarCliente(clientes, nome);
        } else {
            System.out.println("tipo de cliente inválido");
        }

        Menu menu = new MenuCliente(veiculos,clientes,alugueis);
    }
}
