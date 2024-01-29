package org.example.validator;

import org.example.Dictionary;
import org.example.DictionaryType;
import org.example.Word;
import org.example.WordType;

public class InputValidator {


    public static void validateValueLength(String value, WordType valueWordType) throws ValidationException {
        if (valueWordType == WordType.NUMBER && value.length() != 5) {
            throw new ValidationException("Длина слова для Цифр должна быть 5 символов.");
        } else if (valueWordType == WordType.LETTER && value.length() != 4) {
            throw new ValidationException("Длина слова для Букв должна быть 4 символа.");
        }
    }
    public static void validateTranslationLength( String translation, WordType translationWordType) throws ValidationException {
        if (translationWordType == WordType.NUMBER && translation.length() != 5) {
            throw new ValidationException("Длина слова для Цифр должна быть 5 символов.");
        } else if (translationWordType == WordType.LETTER && translation.length() != 4) {
            throw new ValidationException("Длина слова для Букв должна быть 4 символа.");
        }
    }

    public static void validateEntry(String value, String translation, WordType valueWordType, WordType translationWordType, DictionaryType dictionaryType, Dictionary dictionary) throws ValidationException {
        validateTranslationLength(translation, translationWordType);
        validateValueLength(value, valueWordType);

        if (dictionaryType == DictionaryType.LETTERS) {
            if (!value.matches("[0-9]+")&&!translation.matches("[a-zA-Z]+")) {
                throw new ValidationException("Некорректные символы для словаря цифр.");
            }
        } else if (dictionaryType == DictionaryType.NUMBERS) {
            if (!value.matches("[a-zA-Z]+")&& !translation.matches("[0-9]+")) {
                throw new ValidationException("Некорректные символы для словаря букв.");
            }
        }

        if (dictionary.containsEntry(value)) {
            throw new ValidationException("Запись с таким значением уже существует в словаре.");
        }
    }
}
