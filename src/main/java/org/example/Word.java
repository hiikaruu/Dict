package org.example;


public class Word {
    public Word(String value, String translation) {
        this.value = value;
        this.translation = translation;
    }

    private String value;
    private String translation;
    private WordType valueWordType;
    private WordType translationWordType;

    public String getTranslation() {
        return translation;
    }

    public String getValue() {
        return value;
    }

    public WordType getValueWordType() {
        return valueWordType;
    }
    public WordType getTranslationWordType() {
        return translationWordType;
    }
    public void getWordType() {
        if (value.matches("[0-9]+")&&translation.matches(("[a-zA-Z]+"))) {
             valueWordType=WordType.NUMBER;
             translationWordType=WordType.LETTER;
        } else if (value.matches("[a-zA-Z]+")&&value.matches("[0-9]+")) {
            valueWordType=WordType.LETTER;
            translationWordType=WordType.NUMBER;
        }
    }
}