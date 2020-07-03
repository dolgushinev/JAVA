import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {

    private static String[][] book = new String[10][2];
    private static int nextIndex = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exitFlag = false;


    public static void main(String[] args) {

        String name = "";
        String phoneNumber = "";
        int indexOfCopy = -1;
        String[][] tempBook;

        System.out.println("Добро пожаловать в телефонный справочник.");
        System.out.println("Для выхода введите \"!\"\n");

        do {

            if (nextIndex == book.length) {
                tempBook = new String[book.length * 2][2];

                for (int j = 0; j < nextIndex; j++) {
                    tempBook[j] = book[j];
                }
                book = tempBook;
            }

            do {
                System.out.println("Введите ФИО в формате: Фамилия Имя Отчество");
                name = scanner.nextLine();
            }
            while (!checkName(name));

            if (exitFlag) break;

            name = formatName(name);
            indexOfCopy = findName(name);

            if (indexOfCopy == -1) {
                do {
                    System.out.println("Введите номер телефона, например: 8(926)234-51-18");
                    phoneNumber = scanner.nextLine();
                }
                while (!checkPhoneNumber(phoneNumber));

                if (exitFlag) break;

                phoneNumber = formatPhoneNumber(phoneNumber);
                add(book, name, phoneNumber);
            } else
                System.out.println("ФИО присутствует в справочнике, телефон: " + book[indexOfCopy][1]);

        } while (!exitFlag);

        if(nextIndex >= 1) list(book);
    }

    private static int findName(String name) {
        int indexOfCopy = -1;
        for (int i = 0; i < nextIndex; i++) {
            if (book[i][0].equals(name)) {
                indexOfCopy = i;
                break;
            }
        }
        return indexOfCopy;
    }

    public static boolean checkName(String name) {
        if (name.equals("!")) {
            exitFlag = true;
            return true;
        } else {
            String[] words = name.trim().split(" ");
            if (words.length != 3) System.out.println("Неверный формат, повторите ввод.");
            return words.length == 3;
        }
    }

    public static String formatName(String name) {
        String[] words = name.trim().split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                result += Character.toUpperCase(firstChar) + str.substring(1) + " ";
            } else {
                result += str + " ";
            }
        }
        return result;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.equals("!")) {
            exitFlag = true;
            return true;
        } else {
            String clean = phoneNumber.replaceAll("[^0-9]", "");
            if (clean.length() != 11) System.out.println("Неверный формат, повторите ввод.");
            return clean.length() == 11;
        }
    }

    public static String formatPhoneNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
        return result;
    }

    public static void add(String[][] book, String name, String number) {
        book[nextIndex][0] = name;
        book[nextIndex][1] = number;
        nextIndex++;
    }

    public static void list(String[][] book) {
        System.out.println("Полный список абоненов телефонного справочника:");
        String[] sortBook = new String[nextIndex];

        for (int i = 0; i < nextIndex; i++) {
            sortBook[i] = book[i][0] + " : " + book[i][1];
        }

        Arrays.sort(sortBook);

        for (int i = 0; i < nextIndex; i++) {
            System.out.println(sortBook[i]);
        }
        System.out.println("");

    }
}
