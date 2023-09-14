import java.util.ArrayList;
import java.util.List;

public class MenuAluguel extends Menu{
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Aluguel> alugueis;
    private VeiculoService veiculoService;

    public MenuAluguel(List<Veiculo> veiculos, List<Cliente> clientes, List<Aluguel> alugueis){
        this.veiculos = veiculos;
        this.veiculoService = new VeiculoService();
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
            //Menu menu = new MenuAluguel();
        } else if (opcao == 2) {
            //Menu menu = new MenuCliente();
        } else if (opcao == 3) {
            //Menu menu = new MenuVeiculo(veiculos);
        }
    }

}
