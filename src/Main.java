import java.time.LocalDateTime;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        List<Veiculo> veiculos = new ArrayList();
        List<Aluguel> alugueis = new ArrayList();
        List<Cliente> clientes = new ArrayList();


        veiculos.add(new Veiculo(TamanhoVeiculo.PEQUENO, "ABC123", "Toyota", "Corolla", "2022", 15000));
        veiculos.add(new Veiculo(TamanhoVeiculo.MEDIO, "XYZ789", "Honda", "Civic", "2021", 20000));
        veiculos.add(new Veiculo(TamanhoVeiculo.SUV, "DEF456", "Ford", "Escape", "2023", 8000));
        veiculos.add(new Veiculo(TamanhoVeiculo.PEQUENO, "GHI789", "Volkswagen", "Gol", "2020", 30000));
        veiculos.add(new Veiculo(TamanhoVeiculo.MEDIO, "JKL123", "Hyundai", "Elantra", "2022", 18000));
        veiculos.add(new Veiculo(TamanhoVeiculo.SUV, "MNO456", "Kia", "Sportage", "2021", 21000));
        veiculos.add(new Veiculo(TamanhoVeiculo.PEQUENO, "PQR789", "Nissan", "Versa", "2023", 5000));
        veiculos.add(new Veiculo(TamanhoVeiculo.MEDIO, "STU123", "Chevrolet", "Cruze", "2022", 22000));
        veiculos.add(new Veiculo(TamanhoVeiculo.SUV, "VWX456", "Subaru", "Outback", "2020", 25000));
        veiculos.add(new Veiculo(TamanhoVeiculo.PEQUENO, "YZA789", "Mazda", "Mazda3", "2021", 12000));

        clientes.add(new ClienteFisico("João Silva", "123456789", "Rua A, 123", "fisico", "123.456.789-01"));
        clientes.add(new ClienteFisico("Maria Santos", "987654321", "Avenida B, 456", "fisico", "987.654.321-02"));
        clientes.add(new ClienteFisico("Pedro Souza", "111222333", "Rua C, 789", "fisico", "111.222.333-03"));
        clientes.add(new ClienteFisico("Ana Pereira", "444555666", "Avenida D, 101", "fisico", "444.555.666-04"));
        clientes.add(new ClienteFisico("Luiz Oliveira", "777888999", "Rua E, 202", "fisico", "777.888.999-05"));
        clientes.add(new ClienteFisico("Sara Martins", "555444333", "Avenida F, 303", "fisico", "555.444.333-06"));
        clientes.add(new ClienteFisico("Marcos Ferreira", "666777888", "Rua G, 404", "fisico", "666.777.888-07"));
        clientes.add(new ClienteFisico("Lucia Rodrigues", "333222111", "Avenida H, 505", "fisico", "333.222.111-08"));
        clientes.add(new ClienteFisico("Ricardo Costa", "888999777", "Rua I, 606", "fisico", "888.999.777-09"));
        clientes.add(new ClienteFisico("Catarina Nunes", "222333444", "Avenida J, 707", "fisico", "222.333.444-10"));

        clientes.add(new ClienteJuridico("Tech Solutions Inc.", "123-456-7890", "123 Tech Street", "12345678/0001-01"));
        clientes.add(new ClienteJuridico("Green Eco Corp.", "987-654-3210", "456 Green Avenue", "98765432/0001-02"));
        clientes.add(new ClienteJuridico("Global Finance Group", "555-123-4567", "789 Finance Road", "55512345/0001-03"));
        clientes.add(new ClienteJuridico("Food Delights LLC", "777-888-9999", "101 Food Plaza", "77788899/0001-04"));
        clientes.add(new ClienteJuridico("Swift Logistics Ltd.", "222-333-4444", "303 Logistics Lane", "22233344/0001-05"));
        clientes.add(new ClienteJuridico("Creative Design Studio", "999-000-1111", "404 Design Street", "99900011/0001-06"));
        clientes.add(new ClienteJuridico("Healthcare Innovations", "666-555-4444", "505 Health Avenue", "66655544/0001-07"));
        clientes.add(new ClienteJuridico("Legal Services Inc.", "111-222-3333", "606 Legal Road", "11122233/0001-08"));
        clientes.add(new ClienteJuridico("Artistic Creations Ltd.", "888-999-7777", "707 Art Avenue", "88899977/0001-09"));
        clientes.add(new ClienteJuridico("Future Tech Enterprises", "444-555-6666", "909 Future Lane", "44455566/0001-10"));


        Random random = new Random();
        List<String> locais = new ArrayList<>();
        locais.add("RJ");
        locais.add("SP");
        locais.add("ES");
        locais.add("MG");
        locais.add("BH");

        int id=0;
        for (int i = 0; i < 15; i++) {
            id +=1;
            Veiculo veiculo = veiculos.get(random.nextInt(veiculos.size()));
            Cliente cliente = clientes.get(random.nextInt(clientes.size()));
            String localAluguel = locais.get(random.nextInt(locais.size()));
            String localDevolucao = locais.get(random.nextInt(locais.size()));
            LocalDateTime dataInicio = LocalDateTime.now().minusDays(random.nextInt(30)).withHour(random.nextInt(10)+9).withMinute(random.nextInt(59));
            LocalDateTime dataFim = dataInicio.plusDays(random.nextInt(14)+1).withHour(random.nextInt(10)+9).withMinute(random.nextInt(59));
            Aluguel aluguel = new Aluguel(id, cliente, veiculo, localAluguel, localDevolucao, dataInicio, dataFim);
            alugueis.add(aluguel);
        }
        for (int i = 0; i < 15; i++) {
            id +=1;
            Veiculo veiculo = veiculos.get(random.nextInt(veiculos.size()));
            Cliente cliente = clientes.get(random.nextInt(clientes.size()));
            String localAluguel = locais.get(random.nextInt(locais.size()));
            LocalDateTime dataInicio = LocalDateTime.now().minusDays(random.nextInt(7)).withHour(random.nextInt(10)+9).withMinute(random.nextInt(59));
            Aluguel aluguel = new Aluguel(id, cliente, veiculo, localAluguel, dataInicio);
            alugueis.add(aluguel);
        }
        HashSet<Veiculo> listaVeiculos = new LinkedHashSet<>(veiculos);
        HashSet<Aluguel> listaAlugueis = new LinkedHashSet<>(alugueis);
        HashSet<Cliente> listaClientes = new LinkedHashSet<>(clientes);

        Menu menuPrincipal = new MenuPrincipal(listaVeiculos, listaClientes, listaAlugueis);

    }
}