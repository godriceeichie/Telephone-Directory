package services;

import interfaces.ContactService;
import interfaces.ContactStorage;
import models.Person;

import java.io.*;

public class FileStorageService implements ContactStorage {
    private static final String FILE_PATH = "telephone_directory.txt";

    @Override
    public void saveToFile(ContactService service) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < service.getDirectorySize(); i++) {
                Person person = service.getAllEntries()[i];
                writer.write(person.getName() + ", " + person.getAge() + ", " + person.getContactNumber());
                writer.newLine();
            }
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving to file.");
        }
    }

    @Override
    public void loadFromFile(ContactService service) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                if (data.length == 3) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String contactNumber = data[2];
                    service.addEntry(new Person(name, age, contactNumber));
                }
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading from file.");
        }
    }
}
