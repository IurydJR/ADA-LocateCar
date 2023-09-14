public class ClienteFisico extends Cliente{
    private String cpf;

    public ClienteFisico(){
    }
    public ClienteFisico(String nome, String telefone, String endereco, String cpf){
        super(nome, telefone, endereco);
        this.setCpf(cpf);
        this.setTipoCliente("fisico");
    }
    public ClienteFisico(String nome, String telefone, String endereco, String tipoCliente, String cpf){
        super(nome, telefone, endereco);
        this.setCpf(cpf);
        this.setTipoCliente(tipoCliente);
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




}
