import java.util.List;
public class VeiculoService extends Veiculo{

    public void cadastrarVeiculo(List<Veiculo> veiculos, TamanhoVeiculo tamanhoVeiculo, String placaVeiculo, String marcaVeiculo, String modeloVeiculo, String anoVeiculo, int quilometragemVeiculo){
        Veiculo veiculo = new Veiculo();
        alterarVeiculo(veiculo, tamanhoVeiculo, placaVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, quilometragemVeiculo);
        veiculos.add(veiculo);

    }
    public void alterarVeiculo(Veiculo veiculo, TamanhoVeiculo tamanhoVeiculo, String placaVeiculo, String marcaVeiculo, String modeloVeiculo, String anoVeiculo, int quilometragemVeiculo){
        veiculo.setTamanhoVeiculo(tamanhoVeiculo);
        veiculo.setPlacaVeiculo(placaVeiculo);
        veiculo.setMarcaVeiculo(marcaVeiculo);
        veiculo.setModeloVeiculo(modeloVeiculo);
        veiculo.setAnoVeiculo(anoVeiculo);
        veiculo.setQuilometragemVeiculo(quilometragemVeiculo);
    }


    public void buscarVeiculo(List<Veiculo> listaVeiculos, String placa) {
        boolean veiculoNaoEncontrado = true;
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlacaVeiculo().equals(placa)) {
                infoVeiculo(veiculo);
                veiculoNaoEncontrado = false;
            }
        }
        if (veiculoNaoEncontrado){
            System.out.println("Veículo não encontrado.");
        }
    }

    public void infoVeiculo(Veiculo veiculo) {
        TamanhoVeiculo tamanhoVeiculo = veiculo.getTamanhoVeiculo();
        String placaVeiculo = veiculo.getPlacaVeiculo();
        String marcaVeiculo = veiculo.getMarcaVeiculo();
        String modeloVeiculo = veiculo.getModeloVeiculo();
        String anoVeiculo = veiculo.getAnoVeiculo();
        int quilometragemVeiculo = veiculo.getQuilometragemVeiculo();

        System.out.println("Informações do Veículo:");
        System.out.println("Tamanho: " + tamanhoVeiculo);
        System.out.println("Placa: " + placaVeiculo);
        System.out.println("Marca: " + marcaVeiculo);
        System.out.println("Modelo: " + modeloVeiculo);
        System.out.println("Ano: " + anoVeiculo);
        System.out.println("Quilometragem: " + quilometragemVeiculo);
    }
        //

}