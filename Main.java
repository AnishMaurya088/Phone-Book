import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("\nPhonebook Management");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(name, phoneNumber);
                    break;

                case 2:
                    // Delete Contact
                    System.out.print("Enter contact ID to delete: ");
                    int deleteId = scanner.nextInt();
                    phoneBook.deleteContact(deleteId);
                    break;

                case 3:
                    // Search Contact
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    phoneBook.searchContact(searchName);
                    break;

                case 4:
                    // Update Contact
                    System.out.print("Enter contact ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    phoneBook.updateContact(updateId, newName, newPhoneNumber);
                    break;

                case 5:
                    // Display All Contacts
                    phoneBook.displayAllContacts();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
