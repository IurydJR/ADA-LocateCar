import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuVeiculo extends Menu{

    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;
    private VeiculoService veiculoService;

    public MenuVeiculo(List<Veiculo> veiculos, List<Cliente> clientes, List<Aluguel> alugueis) {
        this.veiculos = veiculos;
        this.veiculoService = new VeiculoService();
        int opcao;

        List<String> textoOpcoes = new ArrayList<>();
        textoOpcoes.add("Buscar Veiculo");
        textoOpcoes.add("Cadastrar Veiculo");
        textoOpcoes.add("Voltar");
        opcao = criarMenu(textoOpcoes);
        executarOpcao(opcao);
    }
    public void executarOpcao(int opcao){
        Scanner scan = new Scanner(System.in);
        if(opcao == 1){
            buscarVeiculo(veiculos);
        } else if(opcao == 2){
            cadastrarVeiculo(veiculos);
        } else if(opcao == 3){
            Menu menu = new MenuPrincipal(veiculos,clientes,alugueis);
        }
    }

    public void cadastrarVeiculo(List<Veiculo> veiculos){
        Scanner scan = new Scanner(System.in);

        System.out.println("Tamanho do veículo (PEQUENO, MEDIO, SUV:");
        TamanhoVeiculo tamanhoVeiculo = TamanhoVeiculo.valueOf(scan.nextLine());

        System.out.println("Placa do veículo:");
        String placaVeiculo = scan.nextLine();

        System.out.println("Marca do veículo:");
        String marcaVeiculo = scan.nextLine();

        System.out.println("Modelo do veículo:");
        String modeloVeiculo = scan.nextLine();

        System.out.println("Ano do veículo:");
        String anoVeiculo = scan.nextLine();

        System.out.println("Quilometragem do veículo:");
        int quilometragemVeiculo = scan.nextInt();

        veiculoService.cadastrarVeiculo(veiculos, tamanhoVeiculo, placaVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, quilometragemVeiculo);

        System.out.println("Veiculo cadastrado");
        Menu menu = new MenuVeiculo(veiculos,clientes,alugueis);

    }

    public void buscarVeiculo(List<Veiculo> veiculos){
        String placa;
        Scanner scan = new Scanner(System.in);

        System.out.println("Insira a placa do veículo:");
        placa = scan.nextLine();

        veiculoService.buscarVeiculo(veiculos, placa);

        Menu menu = new MenuVeiculo(veiculos,clientes,alugueis);
    }
}


