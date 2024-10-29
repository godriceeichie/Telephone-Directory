package interfaces;

import models.Person;

public interface ContactStorage {
    void saveToFile(ContactService service);
    void loadFromFile(ContactService service);
}

