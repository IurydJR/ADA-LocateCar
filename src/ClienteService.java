import java.util.HashSet;
import java.util.List;

public interface ClienteService {
    void cadastrarCliente(String nomeCliente, String telefoneCliente, String enderecoCliente, String identificacao);

    void alterarCliente(Cliente clienteFisico, String nomeCliente, String telefoneCliente, String enderecoCliente, String identificacao);

    void buscarCliente(HashSet<Cliente> listaClientes, String nomeCliene);

    void infoCliente(Cliente clienteFisico);
}


