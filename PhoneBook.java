import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    // Add Contact
    public void addContact(String name, String phoneNumber) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO contacts (name, phoneNumber) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, phoneNumber);
                stmt.executeUpdate();
                System.out.println("Contact added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Contact
    public void deleteContact(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM contacts WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Contact deleted successfully.");
                } else {
                    System.out.println("No contact found with the given ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Contact
    public void searchContact(String name) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM contacts WHERE name LIKE ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, "%" + name + "%");
                ResultSet rs = stmt.executeQuery();
                boolean found = false;
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Phone: " + rs.getString("phoneNumber"));
                    found = true;
                }
                if (!found) {
                    System.out.println("No contacts found with the name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Contact
    public void updateContact(int id, String newName, String newPhoneNumber) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE contacts SET name = ?, phoneNumber = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, newName);
                stmt.setString(2, newPhoneNumber);
                stmt.setInt(3, id);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Contact updated successfully.");
                } else {
                    System.out.println("No contact found with the given ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display All Contacts
    public void displayAllContacts() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM contacts";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(sql);
                boolean found = false;
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Phone: " + rs.getString("phoneNumber"));
                    found = true;
                }
                if (!found) {
                    System.out.println("No contacts available.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
