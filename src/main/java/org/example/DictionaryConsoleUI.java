package org.example;

import org.example.validator.InputValidator;
import org.example.validator.ValidationException;

import java.util.Scanner;

public class DictionaryConsoleUI {

    private FileDictionaryHandler fileHandler;
    private Dictionary dictionary;
    private Scanner scanner;

    private Word word;

    public DictionaryConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.dictionary = null;
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    chooseDictionaryType();
                    break;
                case 2:
                    operateOnDictionary();
                    break;
                case 3:
                    System.out.println("Выход из программы. До свидания!");
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Выбор словаря");
        System.out.println("2. Работа с текущим словарем");
        System.out.println("3. Выход");
        System.out.print("Выберите действие: ");
    }
    private void chooseDictionaryType() {
            System.out.println("Выберите тип словаря:");
            System.out.println("1. Буквы");
            System.out.println("2. Цифры");

            int choice = scanner.nextInt();

            if (choice == 1) {
                fileHandler = new FileDictionaryHandler("dictionary_letters.txt", DictionaryType.LETTERS);
                dictionary = new Dictionary(DictionaryType.values()[choice - 1], fileHandler);
            } else if (choice == 2) {
                fileHandler = new FileDictionaryHandler("dictionary_numbers.txt", DictionaryType.NUMBERS);
                dictionary = new Dictionary(DictionaryType.values()[choice - 2], fileHandler);
            } else {
                System.out.println("Некорректный выбор. Возвращение в главное меню.");
                return;
            }

            System.out.println("Словарь успешно выбран.");
    }

        private void operateOnDictionary() {
        if (dictionary == null) {
            System.out.println("Сначала выберите словарь. Возвращение в главное меню.");
            return;
        }

        while (true) {
            displayDictionaryMenu();
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    removeEntry();
                    break;
                case 3:
                    searchEntry();
                    break;
                case 4:
                    dictionary.displayEntries();
                    break;
                case 5:
                    System.out.println("Смена словаря.");
                    chooseDictionaryType();
                    return;
                case 6:
                    System.out.println("Возврат в главное меню.");
                    return;
                default:
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }
        }
    }

    private void displayDictionaryMenu() {
        System.out.println("Меню работы со словарем:");
        System.out.println("1. Добавить запись");
        System.out.println("2. Удалить запись");
        System.out.println("3. Поиск записи");
        System.out.println("4. Просмотр словаря");
        System.out.println("5. Сменить словарь");
        System.out.println("6. Возврат в главное меню");
        System.out.print("Выберите действие: ");
    }

    private void addEntry() {
        System.out.println("Введите значение: ");
        String value = scanner.next();

        System.out.println("Введите перевод: ");
        String translation = scanner.next();
        dictionary.addEntry(value, translation);
    }

    private void removeEntry() {
        System.out.print("Введите значение для удаления: ");
        String key = scanner.next();
        dictionary.removeEntry(key);
    }

    private void searchEntry() {
        System.out.print("Введите значение для поиска: ");
        String key = scanner.next();
        Word result = dictionary.searchEntry(key);
        if (result != null) {
            System.out.println("Найдено: " + result.getValue() + " - " + result.getTranslation());
        } else {
            System.out.println("Запись не найдена.");
        }
    }
}



