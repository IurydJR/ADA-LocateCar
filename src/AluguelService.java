import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class AluguelService {

    public void cadastrarAluguel(List<Aluguel> alugueis, Cliente cliente, Veiculo veiculo,
                                 LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel,
                                 String nome, String tipoCliente, String placaVeiculo, TamanhoVeiculo tamanhoVeiculo){
        Aluguel aluguel = new Aluguel(cliente, veiculo);
        alterarAluguel(aluguel, cliente, veiculo, dataInicioAluguel, dataFimAluguel, nome, tipoCliente, placaVeiculo, tamanhoVeiculo);
        alugueis.add(aluguel);

    }
    public void alterarAluguel(Aluguel aluguel,Cliente cliente, Veiculo veiculo,
                               LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel,
                               String nome, String tipoCliente, String placaVeiculo, TamanhoVeiculo tamanhoVeiculo){
        aluguel.setDataInicioAluguel(dataInicioAluguel);
        aluguel.setDataFimAluguel(dataFimAluguel);
        cliente.setNome(nome);
        cliente.setTipoCliente(tipoCliente);
        veiculo.setPlacaVeiculo(placaVeiculo);
        veiculo.setTamanhoVeiculo(tamanhoVeiculo);
    }

    public void devolverAluguel(Aluguel aluguel, LocalDateTime dataFimAluguel){
        aluguel.setDataFimAluguel(dataFimAluguel);
    }
    public void devolverAluguel(Aluguel aluguel){
        aluguel.setDataFimAluguel(LocalDateTime.now());
    }
    public double calcularValorAluguel(Aluguel aluguel, LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel, TamanhoVeiculo tamanhoVeiculo, String tipoCliente) {
        double custoDiaria = 0;
        int numDiarias;
        double descontoTempo = 1;

        if (tamanhoVeiculo == TamanhoVeiculo.PEQUENO) {
            custoDiaria = TamanhoVeiculo.PEQUENO.getCustoDia();
        } else if (tamanhoVeiculo == TamanhoVeiculo.MEDIO) {
            custoDiaria = TamanhoVeiculo.MEDIO.getCustoDia();
        } else if (tamanhoVeiculo == TamanhoVeiculo.SUV) {
            custoDiaria = TamanhoVeiculo.SUV.getCustoDia();
        }

        numDiarias = (int) ChronoUnit.DAYS.between(dataInicioAluguel, dataFimAluguel);
        if (dataInicioAluguel.getHour() <= dataFimAluguel.getHour() && dataInicioAluguel.getMinute() < dataFimAluguel.getMinute()) {
            numDiarias += 1;
        }


        if (tipoCliente.equals("fisico") && numDiarias < 5) {
            descontoTempo = 0.95;
        } else if (tipoCliente.equals("juridico") && numDiarias < 3) {
            descontoTempo = 0.5;
        }

        return custoDiaria * numDiarias * descontoTempo;
    }


    public void buscarAluguel(List<Aluguel> listaAlugueis, int idAluguel, Veiculo veiculo, Cliente cliente) {
        boolean aluguelNaoEncontrado = true;
        for (Aluguel aluguel : listaAlugueis) {
            if (aluguel.getIdAluguel() == idAluguel) {
                infoAluguel(aluguel, veiculo, cliente);
                aluguelNaoEncontrado = false;
            }
        }
        if (aluguelNaoEncontrado){
            System.out.println("Veículo não encontrado.");
        }
    }

    public void infoAluguel(Aluguel aluguel, Veiculo veiculo, Cliente cliente) {
        LocalDateTime dataInicioAluguel = aluguel.getDataInicioAluguel();
        LocalDateTime dataFimAluguel = aluguel.getDataFimAluguel();
        String nomeCliente = cliente.getNome();
        String tipoCliente = cliente.getTipoCliente();
        String placaVeiculo = veiculo.getPlacaVeiculo();
        String tipoVeiculo = String.valueOf(veiculo.getTamanhoVeiculo());


        System.out.println("Informações do Aluguel:");
        System.out.println("Nome do cliente: " + nomeCliente);//
        System.out.println("Tipo do cliente: " + tipoCliente);//
        System.out.println("placa do carro: " + placaVeiculo);//
        System.out.println("tipo do carro: " + tipoVeiculo);
        System.out.println("Inicio: " + dataFimAluguel);//
        System.out.println("Fim: " + dataInicioAluguel);//

    }
    //
}
