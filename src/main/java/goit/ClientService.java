package goit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final Connection connection;

    public ClientService(Connection connection) {
        this.connection = connection;
    }

    public long create(String name) throws SQLException {
        validateName(name);

        String sql = "INSERT INTO client (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("creating client failed, no id obtained.");
                }
            }
        }
    }

    public String getById(long id) throws SQLException {
        validateId(id);

        String sql = "SELECT name FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                } else {
                    throw new SQLException("Client with ID " + id + " not found.");
                }
            }
        }
    }

    public void setName(long id, String name) throws SQLException {
        validateId(id);
        validateName(name);

        String sql = "UPDATE client SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setLong(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("client with id " + id + " not found.");
            }
        }
    }

    public void deleteById(long id) throws SQLException {
        validateId(id);

        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted == 0) {
                throw new SQLException("client with ID " + id + " not found.");
            }
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();

        String sql = "SELECT id, name FROM client";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                clients.add(new Client(id, name));
            }
        }
        return clients;
    }

    private void validateName(String name) {
        if (name == null || name.length() <= 2 || name.length() > 50) {
            throw new IllegalArgumentException("client name must be between 3 and 50 characters.");
        }
    }

    private void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be positive.");
        }
    }
}
