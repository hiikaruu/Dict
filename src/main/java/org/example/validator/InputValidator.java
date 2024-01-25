package org.example.validator;

import org.example.Dictionary;
import org.example.DictionaryType;
import org.example.Word;
import org.example.WordType;

public class InputValidator {


    public static void validateWordLength(String word, WordType wordType) throws ValidationException {
        if (wordType == WordType.NUMBER && word.length() != 5) {
            throw new ValidationException("Длина слова для Цифр должна быть 5 символов.");
        } else if (wordType == WordType.LETTER && word.length() != 4) {
            throw new ValidationException("Длина слова для Букв должна быть 4 символа.");
        }
    }

    public static void validateEntry(String value, String translation, WordType wordType, Dictionary dictionary) throws ValidationException {
        validateWordLength(value, wordType);
        validateWordLength(translation, wordType);

        if (wordType == WordType.LETTER) {
            if (!value.matches("[0-9]+") || !translation.matches("[a-zA-Z]+")) {
                throw new ValidationException("Некорректные символы для словаря букв.");
            }
        } else if (wordType == WordType.NUMBER) {
            if (!value.matches("[a-zA-Z]+") || !translation.matches("[0-9]+")) {
                throw new ValidationException("Некорректные символы для словаря цифр.");
            }
        }

        if (dictionary.containsEntry(value)) {
            throw new ValidationException("Запись с таким значением уже существует в словаре.");
        }
    }
}
