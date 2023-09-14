import java.util.List;

public interface ClienteService {
    void cadastrarCliente(String nomeCliente, String telefoneCliente, String enderecoCliente, String identificacao);

    void alterarCliente(Cliente clienteFisico, String nomeCliente, String telefoneCliente, String enderecoCliente, String identificacao);

    void buscarCliente(List<Cliente> listaClientes, String nome);

    void infoCliente(Cliente clienteFisico);
}


