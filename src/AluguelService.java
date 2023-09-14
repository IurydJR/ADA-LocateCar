import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class AluguelService {

    DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public void cadastrarAluguel(HashSet<Aluguel> alugueis, Cliente cliente, Veiculo veiculo, String localAluguel){
        int idAluguel;
        if (!alugueis.isEmpty()) {
            idAluguel = alugueis.size()+1;
        } else {
            idAluguel = 1;
        }
            Aluguel aluguel = new Aluguel(idAluguel, cliente, veiculo, localAluguel);
            alugueis.add(aluguel);

    }

    public void alterarAluguel(Aluguel aluguel,Cliente cliente, Veiculo veiculo,
                               LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel){

        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);
        aluguel.setDataInicioAluguel(dataInicioAluguel);
        aluguel.setDataFimAluguel(dataFimAluguel);

    }

    public void devolverAluguel(Aluguel aluguel, LocalDateTime dataFimAluguel){
        aluguel.setDataFimAluguel(dataFimAluguel);
    }
    public void devolverAluguel(Aluguel aluguel){
        aluguel.setDataFimAluguel(LocalDateTime.now());
    }
    public void calcularValorAluguel(Aluguel aluguel, LocalDateTime dataInicioAluguel, LocalDateTime dataFimAluguel, TamanhoVeiculo tamanhoVeiculo, String tipoCliente) {
        double custoDiaria = 0;
        int numDiarias;
        double descontoTempo = 1;
        double custoParcial;
        double custoFinal;

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


        if (tipoCliente.equals("fisico") && numDiarias > 5) {
            descontoTempo = 0.95;
        } else if (tipoCliente.equals("juridico") && numDiarias > 3) {
            descontoTempo = 0.9;
        }
        custoParcial =  custoDiaria * numDiarias;
        custoFinal =  custoDiaria * numDiarias * descontoTempo;


        System.out.println("Inicio do aluguel:  "+dataInicioAluguel.format(formatoData));
        System.out.println("Fim do aluguel:     "+dataFimAluguel.format(formatoData));
        System.out.println("Total de diárias:   "+numDiarias);
        System.out.println("Tipo de cliente:    "+tipoCliente);
        System.out.println("Tipo de carro:      "+tamanhoVeiculo.toString().toLowerCase());
        System.out.println("valor diária:       R$ "+String.format("%.2f", custoDiaria));
        System.out.println("Desconto:           "+String.format("%.2f", ((1-descontoTempo)*100))+"%");
        System.out.println();
        System.out.println("Subtotal:           R$ "+String.format("%.2f", custoParcial));
        System.out.println("Total:              R$ "+String.format("%.2f", custoFinal));
    }


    public void buscarAluguel(HashSet<Aluguel> alugueis, int idAluguel) {
        boolean aluguelNaoEncontrado = true;
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getIdAluguel() == idAluguel) {
                infoAluguel(aluguel);
                aluguelNaoEncontrado = false;
            }
        }
        if (aluguelNaoEncontrado){
            System.out.println("Veículo não encontrado.");
        }
    }

    public void infoAluguel(Aluguel aluguel) {
        Cliente cliente = aluguel.getCliente();
        Veiculo veiculo = aluguel.getVeiculo();
        LocalDateTime dataInicioAluguel = aluguel.getDataInicioAluguel();
        LocalDateTime dataFimAluguel = aluguel.getDataFimAluguel();
        String dataInicioAluguelFormatada;
        String dataFimAluguelFormatada;
        String nomeCliente = cliente.getNome();
        String tipoCliente = cliente.getTipoCliente();
        String placaVeiculo = veiculo.getPlacaVeiculo();
        String tipoVeiculo = String.valueOf(veiculo.getTamanhoVeiculo());
        String localAluguel = aluguel.getLocalAluguel();
        String localDevolucao = aluguel.getLocalDevolucao();

        if(dataInicioAluguel != null){
            dataInicioAluguelFormatada = dataInicioAluguel.format(formatoData);
        } else{ dataInicioAluguelFormatada = null;}
        if(dataFimAluguel != null){
            dataFimAluguelFormatada = dataFimAluguel.format(formatoData);
        } else{ dataFimAluguelFormatada = null;}


        System.out.println("Informações do Aluguel:");
        System.out.println("Nome do cliente: " + nomeCliente);//
        System.out.println("Tipo do cliente: " + tipoCliente);//
        System.out.println("placa do carro: " + placaVeiculo);//
        System.out.println("tipo do carro: " + tipoVeiculo);
        System.out.println("Local de aluguel: " + localAluguel);
        System.out.println("Inicio: " + dataInicioAluguelFormatada);//
        System.out.println("Local de devolução: " + localDevolucao);
        System.out.println("Fim: " + dataFimAluguelFormatada);//

    }
    //
}
