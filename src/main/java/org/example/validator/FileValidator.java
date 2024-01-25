package org.example.validator;

import java.io.File;
import java.io.IOException;

public class FileValidator {
    public static void validateDictionaryFiles() {
        validateDictionaryFile("dictionary_letters.txt");
        validateDictionaryFile("dictionary_numbers.txt");
    }

    private static void validateDictionaryFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Файл " + filename + " создан.");
                } else {
                    System.out.println("Не удалось создать файл " + filename + ".");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

