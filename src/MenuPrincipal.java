import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MenuPrincipal extends Menu{

    HashSet<Veiculo> veiculos;
    HashSet<Aluguel> alugueis;
    HashSet<Cliente> clientes;

    //private HashSet<Veiculo> veiculos;
    //private HashSet<Cliente> clientes;
    //private HashSet<Aluguel> alugueis;
    private VeiculoService veiculoService;
    private ClienteFisicoService clienteFisicoService;
    private ClienteJuridicoService clienteJuridicoService;
    private AluguelService aluguelService;

    public MenuPrincipal(HashSet<Veiculo> veiculos, HashSet<Cliente> clientes, HashSet<Aluguel> alugueis) {
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
