import java.util.HashMap;
import java.util.HashSet;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


// 1 Реализовать телефонный справочник
// HashMap<Login, Список телефонов>
//- добавлять телефон
//- удалять телефон
//- находить по логину телефон/список телефонов

public class PhoneBook {
    public static HashMap<String, HashSet<String>> phoneMap;
    public static void main(String[] args) throws IOException {
        menu();
    }
    public static void menu() throws IOException {
        new PhoneBook();
        loadFromFile(new File("PhoneBook.txt"));
        Scanner sc = new Scanner(System.in);
        String button = "0";
        String login = "";
        String phone = "";
        while (!button.equals("6")) {
            System.out.println("Выберите действие: \n1. Показать все контакты \n2. Добавить новый контакт/телефон " +
                    "\n3. Найти контакт \n4. Удалить номер телефона \n5. Удалить контакт \n6. Выход \n");
            button = sc.nextLine();
            switch (button) {
                case ("1"):
                    getAllData();
                    break;
                case ("2"):
                    System.out.println("Введите имя: ");
                    login = sc.nextLine();
                    System.out.println("Введите номер телефона: ");
                    phone = sc.nextLine();
                    addNumber(login, phone);
                    break;
                case ("3"):
                    System.out.println("Введите имя: ");
                    getPhone(sc.nextLine());
                    break;
                case ("4"):
                    System.out.println("Введите имя: ");
                    login = sc.nextLine();
                    System.out.println("Введите номер телефона: ");
                    phone = sc.nextLine();
                    deletePhone(login, phone);
                    break;
                case ("5"):
                    System.out.println("Введите контакт, который вы хотите удалить:\n");
                    login = sc.nextLine();
                    System.out.printf("\nУдалить %s Да 1, нет 0\n", login);
                    String yon = sc.nextLine();
                    if (Objects.equals(yon, "1")) {
                        phoneMap.remove(login);
                        System.out.println("Контакт успешно удален!");

                    } else {
                        System.out.println("Удаление отменено");
                    }
                    break;
                case ("6"):
                    System.out.println("");
                    button = "6";
                    break;
                default:
                    System.out.println("Некорректное значение. Попробуйте еще раз!");
                    break;
            }
            System.out.println();
        }
        saveToFile(new File("PhoneBook.txt"));
        sc.close();
    }

    public PhoneBook() {
        phoneMap = new HashMap<>();
    }

    public static void addNumber(String login, String phone) {
        HashSet<String> currentPhone = phoneMap.getOrDefault(login, new HashSet<>());
        currentPhone.add(phone);
        phoneMap.put(login, currentPhone);
        currentPhone.add(phone);
        System.out.println("Номер телефона успешно добавлен!");
    }

    public static void deletePhone(String login, String phone) {
        HashSet<String> currentPhone = phoneMap.getOrDefault(login, new HashSet<>());
        if(currentPhone.isEmpty()){
            phoneMap.remove(login);
            System.out.println("Введенного вами контакта нет в телефонной книге, удаление отменено");
            return;
        }
        else{
            if (currentPhone.remove(phone)){
                System.out.println("Номер телефона успешно удален из справочника");
                return;
            }
            else {
                System.out.println(String.format("указанный номер телефона отсутствует для %s", login));
                return;
            }}}


    public static void getPhone(String login) {
        if(phoneMap.containsKey(login)) {
            String temp = phoneMap.get(login).toString();
            String numbers = temp.substring(1, temp.length() - 1);
            System.out.println(login + " телефон/ы >> " + numbers);
        } else {
            System.out.println("Такого контакта нет");
        }
    }



    public static void getAllData() {
        String[] array = phoneMap.keySet().toArray(new String[phoneMap.size()]);
        for (String login : array) {
            String temp = phoneMap.get(login).toString();
            String numbers = temp.substring(1, temp.length() - 1);
            System.out.println(login +" телефон/ы: >> " + numbers);
        }
    }

    public static void saveToFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String login : phoneMap.keySet()) {
                writer.write(login + ":");
                for (String text : phoneMap.get(login))
                {
                    writer.write(text + ",");
                }
                writer.newLine();
            }
        }
    }

    public static void loadFromFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String login = parts[0];
                    List<String> listParts = Arrays.asList(parts[1].split(","));
                    HashSet<String> phone = new HashSet<String>(listParts);
                    phoneMap.put(login, phone);
                }
            }
        }
    }
}
