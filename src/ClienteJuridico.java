public class ClienteJuridico extends Cliente {
    private String cnpj;

    public ClienteJuridico(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}