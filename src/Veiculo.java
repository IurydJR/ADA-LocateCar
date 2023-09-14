public class Veiculo {

    private TamanhoVeiculo tamanhoVeiculo;
    private String placaVeiculo;

    private String marcaVeiculo;
    private String modeloVeiculo;
    private String anoVeiculo;
    private int quilometragemVeiculo;


    private boolean disponivel;

    public Veiculo(){}
    public Veiculo(TamanhoVeiculo tamanhoVeiculo, String placaVeiculo, String marcaVeiculo, String modeloVeiculo, String anoVeiculo,int quilometragemVeiculo) {
        this.tamanhoVeiculo = tamanhoVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.quilometragemVeiculo = quilometragemVeiculo;
        this.disponivel = true;
    }



    public TamanhoVeiculo getTamanhoVeiculo() {
        return tamanhoVeiculo;
    }

    public void setTamanhoVeiculo(TamanhoVeiculo tamanhoVeiculo) {
        this.tamanhoVeiculo = tamanhoVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public void setMarcaVeiculo(String marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }

    public int getQuilometragemVeiculo() {
        return quilometragemVeiculo;
    }

    public void setQuilometragemVeiculo(int quilometragemVeiculo) {
        this.quilometragemVeiculo = quilometragemVeiculo;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }




}
