import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.HashSet;

public class MenuAluguel extends Menu{

    HashSet<Veiculo> veiculos;
    HashSet<Aluguel> alugueis;
    HashSet<Cliente> clientes;

    //private HashSet<Veiculo> veiculos;
    //private HashSet<Cliente> clientes;
    //private HashSet<Aluguel> alugueis;
    private AluguelService aluguelService;


    public MenuAluguel(HashSet<Veiculo> veiculos, HashSet<Cliente> clientes, HashSet<Aluguel> alugueis){
        this.alugueis = alugueis;
        this.aluguelService = new AluguelService();
        this.clientes = clientes;
        this.veiculos = veiculos;
        int opcao;


        List<String> textoOpcoes = new ArrayList<>();
        textoOpcoes.add("Buscar Aluguel");
        textoOpcoes.add("Cadastrar Aluguel");
        textoOpcoes.add("Finalizar Aluguel");
        textoOpcoes.add("Voltar");
        opcao = criarMenu(textoOpcoes);
        executarOpcao(opcao);
    }
    public void executarOpcao(int opcao) {
        if (opcao == 1) {
            buscarAluguel(alugueis);
        } else if (opcao == 2) {
            cadastrarAluguel(veiculos, clientes, alugueis);
        } else if (opcao == 3) {
            finalizarAluguel();
        } else if (opcao == 4) {
            Menu menu = new MenuPrincipal(veiculos,clientes,alugueis);
        }
    }

    public void cadastrarAluguel(HashSet<Veiculo> veiculos, HashSet<Cliente> clientes, HashSet<Aluguel> alugueis) {
        Scanner scan = new Scanner(System.in);
        Cliente clienteEncontrado = null;
        Veiculo veiculoEncontrado = null;
        boolean encontrado = false;

        System.out.println("Nome do cliente:");
        String nomeCliente = scan.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(nomeCliente.toLowerCase())) {
                clienteEncontrado = cliente;
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Cliente não encontrado");
            Menu menu = new MenuAluguel(veiculos, clientes, alugueis);
        }

        System.out.println("Placa do veículo:");
        String placaVeiculo = scan.nextLine();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlacaVeiculo().toLowerCase().equals(placaVeiculo.toLowerCase())) {
                if(veiculo.isDisponivel()) {
                    veiculoEncontrado = veiculo;

                } else {
                    System.out.println("Veículo indisponivel no momento");
                }
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Veículo não encontrado");
            Menu menu = new MenuAluguel(veiculos, clientes, alugueis);
        }

        System.out.println("Local de aluguel:");
        String localAluguel = scan.nextLine();

        aluguelService.cadastrarAluguel(alugueis, clienteEncontrado, veiculoEncontrado, localAluguel);

        System.out.println("Aluguel cadastrado");
        veiculoEncontrado.setDisponivel(false);
        Menu menu = new MenuAluguel(veiculos, clientes, alugueis);

    }

    public void buscarAluguel(HashSet<Aluguel> alugueis){
        int idAluguel;
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o id do Aluguel:");
        idAluguel = scan.nextInt();

        aluguelService.buscarAluguel(alugueis, idAluguel);

        Menu menu = new MenuAluguel(veiculos,clientes,alugueis);
    }

    public void finalizarAluguel(){
        Scanner scan = new Scanner(System.in);
        Aluguel aluguelEncontrado = null;

        System.out.println("digite o id do Aluguel:");
        int idAluguel = scan.nextInt();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getIdAluguel() == (idAluguel)) {
                aluguelEncontrado = aluguel;
            }
        }
        System.out.println("Local de devolução:");
        String localDevolucao = scan.nextLine();
        aluguelEncontrado.setLocalDevolucao(localDevolucao);

        aluguelEncontrado.setDataFimAluguel(LocalDateTime.now());

        LocalDateTime dataInicioAluguel = aluguelEncontrado.getDataInicioAluguel();
        LocalDateTime dataFimAluguel = aluguelEncontrado.getDataFimAluguel();

        Veiculo veiculo = aluguelEncontrado.getVeiculo();
        TamanhoVeiculo tamanhoVeiculo = veiculo.getTamanhoVeiculo();

        Cliente cliente = aluguelEncontrado.getCliente();
        String tipoCliente = cliente.getTipoCliente();




        aluguelService.calcularValorAluguel(aluguelEncontrado, dataInicioAluguel, dataFimAluguel, tamanhoVeiculo, tipoCliente);

        Menu menu = new MenuAluguel(veiculos,clientes,alugueis);
    }

}
