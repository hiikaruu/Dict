package org.example;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public Dictionary(DictionaryType dictionaryType, FileHandler fileHandler) {
        this.dictionaryType = dictionaryType;
        this.entries = new HashMap<>();
        this.filename = "dictionary_" + dictionaryType.toString().toLowerCase() + ".txt";
        this.fileHandler = fileHandler;
        fileHandler.readFromFile(this);
    }

    private final DictionaryType dictionaryType;
    private Map<String, Word> entries;
    private String filename;
    private FileHandler fileHandler;


    public boolean containsEntry(String key) {
        return entries.containsKey(key);
    }
    public DictionaryType getType() {
        return dictionaryType;
    }
    public Map<String, Word> getEntries() {
        return entries;
    }
    public void removeEntry(String key) {
        entries.remove(key);
        System.out.println("Запись удалена: " + key);
        fileHandler.writeToFile(this);
    }

    public Word searchEntry(String key) {
        return entries.get(key);
    }

    public void addEntry(String value, String translation) {
        Word word = new Word(value, translation);
        word.determineWordType();
        entries.put(value, word);
        System.out.println("Запись добавлена: " + value + " - " + translation);
        fileHandler. writeToFile(this);
    }

    public void displayEntries() {
        System.out.println("Содержимое словаря:");
        for (Word word : entries.values()) {
            System.out.println(word.getValue() + " - " + word.getTranslation() + " - " + word.getWordType());
        }
    }

}




