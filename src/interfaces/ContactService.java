package interfaces;

import models.Person;

// Defines contact management operations
public interface ContactService {
    boolean addEntry(Person person);

    void displayAllEntries();

    Person retrieveEntryByIndex(int index);

    void retrieveEntriesByRange(int start, int end);

    void displayEntriesByStartingCharacter(char startChar);

    int getDirectorySize();

    Person[] getAllEntries();
}
