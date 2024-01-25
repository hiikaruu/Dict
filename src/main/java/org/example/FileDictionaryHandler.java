package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileDictionaryHandler implements FileHandler {
    private String filename;
    final DictionaryType dictionaryType;
    public FileDictionaryHandler(String filename, DictionaryType dictionaryType) {
        this.filename = filename;
        this.dictionaryType = dictionaryType;
    }


    @Override
    public void readFromFile(Dictionary dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                String value = parts[0];
                String translation = parts[1];
                dictionary.addEntry(value, translation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(Dictionary dictionary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Word word : dictionary.getEntries().values()) {
                writer.write(word.getValue() + " - " + word.getTranslation() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removeEntryFromFile(Dictionary dictionary, String key) {

        Map<String, Word> entries = dictionary.getEntries();
        entries.remove(key);
        writeToFile(dictionary);
    }
}