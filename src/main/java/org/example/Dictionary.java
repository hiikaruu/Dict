package org.example;

import org.example.validator.InputValidator;
import org.example.validator.ValidationException;

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
        searchEntry(key);
        fileHandler.removeEntryFromFile(this, key);
        System.out.println("Запись удалена: " + key);
    }

    public Word searchEntry(String key) {
        return entries.get(key);
    }

    public void addEntry(String value, String translation) {
        Word word = new Word(value, translation);
        word.getWordType();
        try {
            getType();
            word.getWordType();
            InputValidator.validateTranslationLength(translation, word.getTranslationWordType());
            InputValidator.validateValueLength(value, word.getValueWordType());
            InputValidator.validateEntry(value, translation,word.getValueWordType(),word.getTranslationWordType(),getType(),this);
            entries.put(value, word);
            System.out.println("Запись добавлена: " + value + " - " + translation);
            fileHandler. writeToFile(this);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

    }

    public void displayEntries() {
        System.out.println("Содержимое словаря:");
        for (Word word : entries.values()) {
            System.out.println(word.getValue() + " - " + word.getTranslation());
        }
    }
}




