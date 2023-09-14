import java.util.HashSet;

public class ClienteJuridicoService implements ClienteService{
    @Override
    public void cadastrarCliente(String nomeCliente, String telefoneCliente, String enderecoCliente, String cnpjCliente){
        Cliente clienteJuridico = new ClienteFisico(nomeCliente, telefoneCliente, enderecoCliente, cnpjCliente);
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
        for (Cliente clienteJuridico : listaClientes) {
            if (clienteJuridico.getNome().toLowerCase().contains(nomeCliente.toLowerCase())) {
                infoCliente(clienteJuridico);
                clienteJuridicoNaoEncontrado = false;
            }
        }
        if (clienteJuridicoNaoEncontrado){
            System.out.println("Veículo não encontrado.");
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
