import interfaces.ContactService;
import interfaces.ContactStorage;
import models.Person;
import services.DirectoryService;
import services.FileStorageService;

import java.io.*;
import java.util.Scanner;

public class TelephoneDirectory {
    private static final Scanner scanner = new Scanner(System.in);
    private static ContactService contactService;
    private static ContactStorage contactStorage;

    public static void main(String[] args) {
        System.out.print("Enter the maximum number of entries you want to store: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        contactService = new DirectoryService(capacity);
        contactStorage = new FileStorageService();
        contactStorage.loadFromFile(contactService);

        int choice;
        do {
            choice = getMenuChoice();
            handleMenuChoice(choice);
        } while (choice != 6);
    }

    private static int getMenuChoice() {
        System.out.println("\n--- Telephone Directory ---");
        System.out.println("1. Add Entry");
        System.out.println("2. Retrieve Entry by Index");
        System.out.println("3. Retrieve Entries by Range");
        System.out.println("4. Display All Entries");
        System.out.println("5. Display Entries by Starting Character");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> addEntry();
            case 2 -> retrieveEntryByIndex();
            case 3 -> retrieveEntriesByRange();
            case 4 -> contactService.displayAllEntries();
            case 5 -> displayEntriesByStartingCharacter();
            case 6 -> {
                contactStorage.saveToFile(contactService);
                System.out.println("Exiting...");
            }
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addEntry() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        if (contactService.addEntry(new Person(name, age, contactNumber))) {
            contactStorage.saveToFile(contactService);
        }
    }

    private static void retrieveEntryByIndex() {
        System.out.print("Enter the index to retrieve: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        contactService.retrieveEntryByIndex(index);
    }

    private static void retrieveEntriesByRange() {
        System.out.print("Enter the start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter the end index: ");
        int end = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        contactService.retrieveEntriesByRange(start, end);
    }

    private static void displayEntriesByStartingCharacter() {
        System.out.print("Enter the starting character: ");
        char startChar = scanner.nextLine().charAt(0);
        contactService.displayEntriesByStartingCharacter(startChar);
    }
}
