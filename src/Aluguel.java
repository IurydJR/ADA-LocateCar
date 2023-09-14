import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Aluguel {
    private HashSet<Veiculo> veiculos;
    private HashSet<Cliente> clientes;
    private int idAluguel;
    private Cliente cliente;
    private Veiculo veiculo;

    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime dataInicioAluguel;
    LocalDateTime dataFimAluguel;


    String localAluguel;
    String localDevolucao;


    public Aluguel(int id, Cliente cliente, Veiculo veiculo, String localAluguel) {
        HashSet<Veiculo> veiculos = new HashSet<>();
        this.dataInicioAluguel = LocalDateTime.now();
        this.dataFimAluguel = null;
        this.idAluguel = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.localAluguel = localAluguel;

    }

    public Aluguel(int id, Cliente cliente, Veiculo veiculo, String localAluguel, LocalDateTime dataInicioAluguel) {
        HashSet<Veiculo> veiculos = new HashSet<>();
        this.dataInicioAluguel = dataInicioAluguel;
        this.dataFimAluguel = null;
        this.idAluguel = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.localAluguel = localAluguel;
    }

    public Aluguel(int id, Cliente cliente, Veiculo veiculo, String localAluguel, String localDevolucao, LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel) {
        HashSet<Veiculo> veiculos = new HashSet<>();
        this.dataInicioAluguel = dataInicioAluguel;
        this.dataFimAluguel = dataFimAluguel;
        this.idAluguel = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.localAluguel = localAluguel;
        this.localDevolucao = localDevolucao;
    }
    public LocalDateTime getDataInicioAluguel() {
        return dataInicioAluguel;
    }

    public void setDataInicioAluguel(LocalDateTime dataInicioAluguel) {
        this.dataInicioAluguel = dataInicioAluguel;
    }

    public LocalDateTime getDataFimAluguel() {
        return dataFimAluguel;
    }

    public void setDataFimAluguel(LocalDateTime dataFimAluguel) {
        this.dataFimAluguel = dataFimAluguel;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public String getLocalAluguel() {
        return localAluguel;
    }

    public void setLocalAluguel(String localAluguel) {
        this.localAluguel = localAluguel;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }
}
