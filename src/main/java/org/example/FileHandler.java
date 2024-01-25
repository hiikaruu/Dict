package org.example;

import java.io.IOException;

public interface FileHandler {

    void readFromFile(Dictionary dictionary);

    void writeToFile(Dictionary dictionary);

    void removeEntryFromFile(Dictionary dictionary, String key);
}
