import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluguel<T> {
    private List<Veiculo> veiculo;
    private List<Cliente> cliente;

    LocalDateTime dataInicioAluguel;
    LocalDateTime dataFimAluguel;



    int idAluguel;

    public Aluguel(Cliente cliente, Veiculo veiculo) {
        List<Veiculo> veiculos = new ArrayList();
        this.dataInicioAluguel = LocalDateTime.now();
        this.dataFimAluguel = null;
    }

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataInicioAluguel) {
        List<Veiculo> veiculos = new ArrayList();
        this.dataInicioAluguel = dataInicioAluguel;
        this.dataFimAluguel = null;
    }

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel) {
        List<Veiculo> veiculos = new ArrayList();
        this.dataInicioAluguel = dataInicioAluguel;
        this.dataFimAluguel = dataFimAluguel;
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
}
