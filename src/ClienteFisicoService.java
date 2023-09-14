import java.util.HashSet;

public class ClienteFisicoService implements ClienteService{
    @Override
    public void cadastrarCliente(String nomeCliente, String telefoneCliente, String enderecoCliente, String cpfCliente){

        ClienteFisico clienteFisico = new ClienteFisico(nomeCliente, telefoneCliente, enderecoCliente, cpfCliente);
    }
    @Override
    public void alterarCliente(Cliente cliente, String nomeCliente, String telefoneCliente, String enderecoCliente, String cpfCliente){
        ClienteFisico clienteFisico = (ClienteFisico) cliente;
        clienteFisico.setNome(nomeCliente);
        clienteFisico.setTelefone(telefoneCliente);
        clienteFisico.setEndereco(enderecoCliente);
        clienteFisico.setCpf(cpfCliente);
    }

    @Override
    public void buscarCliente(HashSet<Cliente> listaClientes, String nomeCliente) {
        boolean clienteFisicoNaoEncontrado = true;
            for (Cliente cliente : listaClientes) {
                if (cliente.getNome().toLowerCase().contains(nomeCliente.toLowerCase())) {
                    infoCliente(cliente);
                    clienteFisicoNaoEncontrado = false;
                }
            }
            if (clienteFisicoNaoEncontrado) {
                System.out.println("Veículo não encontrado.");
            }

    }

    @Override
    public void infoCliente(Cliente cliente) {
        ClienteFisico clienteFisico = (ClienteFisico) cliente;
        String nomeCliente = clienteFisico.getNome();
        String telefoneCliente = clienteFisico.getTelefone();
        String enderecoCliente = clienteFisico.getEndereco();
        String cpfCliente = clienteFisico.getCpf();


        System.out.println("Informações do Cliente");
        System.out.println("Nome: " + nomeCliente);
        System.out.println("CPF: " + cpfCliente);
        System.out.println("Telefone: " + telefoneCliente);
        System.out.println("Endereço: " + enderecoCliente);
    }
    //





}
