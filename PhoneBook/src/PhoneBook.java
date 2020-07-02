import java.util.Arrays;

public class PhoneBook {

    private static String[][] book = new String[3][3];
    private static int nextIndex = 0;

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
/*        String FIO = "Иван Иванович иванов";
        String phone = "8(926)280-03-03";
        System.out.println("checkName(FIO): " + checkName(FIO));
        System.out.println("formatName(FIO): " + formatName(FIO));
        System.out.println("checkPhoneNumber(phone): " + checkPhoneNumber(phone));
        System.out.println("formatPhoneNumber(phone): " + formatPhoneNumber(phone));*/

        System.out.println("Первый вызов add");
        add(book, formatName("Иванов иван Иванович"), formatPhoneNumber("8(926)280-03-03"));
        System.out.println("Второй вызов add");
        add(book, formatName("Петров Иван иванович"), formatPhoneNumber("8(926)111-11-11"));
        System.out.println("Третий вызов add");
        add(book, formatName("сидоров Иван Иванович"), formatPhoneNumber("8(926)280-03-03"));

        System.out.println("Итого: ");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println(book[i][0] + " " + book[i][1]);
        }
        System.out.println("");
    }

    public static boolean checkName(String name) {
        String[] words = name.trim().split(" ");
        System.out.println(words.length);
        return words.length == 3;
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
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }

    public static String formatPhoneNumber(String number) {
        String clean = number.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
        return result;
    }

/*    public static void add(String[][] book, String name, String number) {
        boolean nameIsExist = false;
        int indexOfCopy = -1;
        for (int i = 0; i < nextIndex; i++) {
            if (book[i][0].equals(name)) {
                System.out.println(book[i][0] + " " + book[i][1]);
                indexOfCopy = i;
                nameIsExist = true;
                break;
            }
        }
        if (!nameIsExist) {
            book[nextIndex][0] = name;
            book[nextIndex][1] = number;
            nextIndex++;
        } else System.out.println("ФИО присутствует в справочнике, телефон: " + book[indexOfCopy][1]);

        System.out.println("Итого: ");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println(book[i][0] + " " + book[i][1]);
        }
        System.out.println("");*/

    public static void add(String[][] book, String name, String number) {
            book[nextIndex][0] = name;
            book[nextIndex][1] = number;
            nextIndex++;
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
