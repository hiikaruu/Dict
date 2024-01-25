package org.example;


public class Word {
    private String value;
    private String translation;
    private WordType wordType;

    public Word(String value, String translation) {
        this.value = value;
        this.translation = translation;
        determineWordType();
    }

    public String getValue() {
        return value;
    }

    public String getTranslation() {
        return translation;
    }

    public WordType getWordType() {
        return wordType;
    }
    public WordType determineWordType() {
        if (value.matches("[0-9]+")) {
            wordType = WordType.NUMBER;
            return WordType.NUMBER;
        } else if (value.matches("[a-zA-Z]+")) {
            wordType = WordType.LETTER;
            return WordType.LETTER;
        }
        return WordType.UNKNOWN;
    }
}