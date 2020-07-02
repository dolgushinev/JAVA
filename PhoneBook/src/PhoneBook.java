public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        String FIO = "Иван Иванович иванов";
        String phone = "8(926)280-03-03";
        System.out.println("checkName(FIO): " + checkName(FIO));
        System.out.println("formatName(FIO): " + formatName(FIO));
        System.out.println("checkPhoneNumber(phone): " + checkPhoneNumber(phone));
        phone = formatPhoneNumber(phone);
        System.out.println(phone);
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
        number = number.replaceAll("[^0-9]", "");
        number = "+7" + " " + number.substring(1, 4) + " " +
                number.substring(4, 7) + " " + number.substring(7, 9) + " " + number.substring(9);
        return number;
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
