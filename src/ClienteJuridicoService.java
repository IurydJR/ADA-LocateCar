import java.sql.SQLOutput;
import java.util.HashSet;

public class ClienteJuridicoService implements ClienteService{
    @Override
    public void cadastrarCliente(HashSet<Cliente> clientes, String nomeCliente, String telefoneCliente, String enderecoCliente, String cnpjCliente){

        Cliente clienteJuridico = new ClienteJuridico(nomeCliente, telefoneCliente, enderecoCliente, cnpjCliente);
        clientes.add(clienteJuridico);
    }
    @Override
    public void alterarCliente(Cliente cliente, String nomeCliente, String telefoneCliente, String enderecoCliente, String cnpjCliente){
        ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
        clienteJuridico.setNome(nomeCliente);
        clienteJuridico.setTelefone(telefoneCliente);
        clienteJuridico.setEndereco(enderecoCliente);
        clienteJuridico.setCnpj(cnpjCliente);
    }

    @Override
    public void buscarCliente(HashSet<Cliente> listaClientes, String nomeCliente) {
        boolean clienteJuridicoNaoEncontrado = true;
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().toLowerCase().contains(nomeCliente.toLowerCase())) {
                infoCliente(cliente);
                clienteJuridicoNaoEncontrado = false;
            }
        }
        System.out.println();
        if (clienteJuridicoNaoEncontrado){
            System.out.println("Cliente não encontrado.");
        }
    }

    @Override
    public void infoCliente(Cliente cliente) {
        ClienteJuridico clienteJuridico = (ClienteJuridico) cliente;
        String nomeCliente = clienteJuridico.getNome();
        String telefoneCliente = clienteJuridico.getTelefone();
        String enderecoCliente = clienteJuridico.getEndereco();
        String cnpjCliente = clienteJuridico.getCnpj();

        System.out.println("Informações do Cliente:");
        System.out.println("Nome: " + nomeCliente);
        System.out.println("CNPJ: "+ cnpjCliente);
        System.out.println("Telefone: " + telefoneCliente);
        System.out.println("Endereço: " + enderecoCliente);
    }
    //





}
