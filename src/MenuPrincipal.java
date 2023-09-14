import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends Menu{

    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;
    private VeiculoService veiculoService;
    private ClienteFisicoService clienteFisicoService;
    private ClienteJuridicoService clienteJuridicoService;
    private AluguelService aluguelService;

    public MenuPrincipal(List<Veiculo> veiculos, List<Cliente> clientes, List<Aluguel> alugueis) {
        this.veiculos = veiculos;
        this.veiculoService = new VeiculoService();
        this.clientes = clientes;
        this.clienteFisicoService = new ClienteFisicoService();
        this.clienteJuridicoService = new ClienteJuridicoService();
        this.alugueis = alugueis;
        this.aluguelService = new AluguelService();
        escreverMenu();
    }


    public void escreverMenu(){
        int opcao;
        List<String> textoOpcoes = new ArrayList<>();
        textoOpcoes.add("Opções de aluguel");
        textoOpcoes.add("Opções de clientes");
        textoOpcoes.add("Opções de veiculos");
        opcao = criarMenu(textoOpcoes);
        executarOpcao(opcao);
    }

    public void executarOpcao(int opcao) {
        if (opcao == 1) {
            Menu menu = new MenuAluguel(veiculos,clientes,alugueis);
        } else if (opcao == 2) {
            Menu menu = new MenuCliente(veiculos,clientes,alugueis);
        } else if (opcao == 3) {
            Menu menu = new MenuVeiculo(veiculos,clientes,alugueis);
        }
    }
}
