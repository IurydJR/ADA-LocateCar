import java.util.HashSet;

public class ClienteJuridico extends Cliente {
    private String cnpj;
    private String tipoCliente;

    public ClienteJuridico(){}


    public ClienteJuridico(String nome, String telefone, String endereco, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.setTipoCliente("juridico");
    }
    public ClienteJuridico(String nome, String telefone, String endereco, String tipoCliente, String cnpj) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.setTipoCliente(tipoCliente);
    }



    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}