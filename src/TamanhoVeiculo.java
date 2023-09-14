public enum TamanhoVeiculo {
    PEQUENO(100),
    MEDIO(150),
    SUV(200);

    private final int custoDia;

    TamanhoVeiculo(int custoDia) {
        this.custoDia = custoDia;
    }

    public int getCustoDia() {
        return custoDia;
    }
}
