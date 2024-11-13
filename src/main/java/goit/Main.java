package goit;

import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();


        ClientService clientService = new ClientService(connection);

        try {

            long clientId = clientService.create("Veronika Antonenko");
            System.out.println("Client created with ID: " + clientId);


            String clientName = clientService.getById(clientId);
            System.out.println("Client with ID " + clientId + " is: " + clientName);


            clientService.setName(clientId, "Veronika Antonenko Updated");
            System.out.println("Client with ID " + clientId + " updated.");


            clientName = clientService.getById(clientId);
            System.out.println("Updated client with ID " + clientId + " is: " + clientName);


            List<Client> clients = clientService.listAll();
            System.out.println("List of all clients:");
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + ", Name: " + client.getName());
            }

            // Удаляем клиента
            clientService.deleteById(clientId);
            System.out.println("Client with ID " + clientId + " deleted.");
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}
