package services;

import interfaces.ContactService;
import models.Person;

import java.util.ArrayList;
import java.util.List;

public class DirectoryService implements ContactService {
    private final List<Person> directory;
    private final int maxCapacity;

    public DirectoryService(int capacity) {
        this.directory = new ArrayList<>(capacity);
        this.maxCapacity = capacity;
    }

    @Override
    public boolean addEntry(Person person) {
        if (directory.size() >= maxCapacity) {
            System.out.println("Directory is full. Cannot add more entries.");
            return false;
        }
        directory.add(person);
        return true;
    }

    @Override
    public void displayAllEntries() {
        if (directory.isEmpty()) {
            System.out.println("No entries in the directory.");
            return;
        }
        for (Person person : directory) {
            System.out.println(person);
        }
    }

    @Override
    public Person retrieveEntryByIndex(int index) {
        if (index >= 0 && index < directory.size()) {
            return directory.get(index);
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    @Override
    public void retrieveEntriesByRange(int start, int end) {
        if (start >= 0 && end < directory.size() && start <= end) {
            for (int i = start; i <= end; i++) {
                System.out.println(directory.get(i));
            }
        } else {
            System.out.println("Invalid range.");
        }
    }

    @Override
    public void displayEntriesByStartingCharacter(char startChar) {
        boolean found = false;
        for (Person person : directory) {
            if (person.getName().charAt(0) == startChar) {
                System.out.println(person);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No entries found starting with '" + startChar + "'.");
        }
    }

    @Override
    public int getDirectorySize() {
        return directory.size();
    }

    @Override
    public Person[] getAllEntries() {
        return directory.toArray(new Person[0]);
    }
}
