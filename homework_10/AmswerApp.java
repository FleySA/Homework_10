package com.proftelran.org.homework_10;

import java.util.List;
import java.util.Scanner;

public class AmswerApp {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);


        String[] inputLines = {
                "User1;www.de.de;APPROVED",
                "User2;www.ebay.de;DENIED",
                "User2;www.amazon.de;DENIED",
                "User1;www.ebay.blabla;ERROR"
        };

        // Заполнение хранилища данными
        for (String inputLine : inputLines) {
            String[] parts = inputLine.split(";");
            String username = parts[0].trim();
            String address = parts[1].trim();
            Answer answer = getAnswer(parts[2].trim());

            storage.addRequest(username, address, answer);
        }

        // Предложение посмотреть статистику посещений по выбранному пользователю
        System.out.print("Введите имя пользователя для просмотра статистики: ");
        String selectedUser = scanner.nextLine().trim();

        List<UserRequest> userRequests = storage.getUserRequests(selectedUser);
        if (userRequests.isEmpty()) {
            System.out.println("Для выбранного пользователя нет данных о запросах.");
        } else {
            System.out.println("Статистика посещений для пользователя " + selectedUser + ":");
            for (UserRequest userRequest : userRequests) {
                System.out.println("Адрес: " + userRequest.getAddress() + ", Ответ: " + userRequest.getAnswer());
            }
        }
    }

    private static Answer getAnswer(String answer) {
        switch (answer) {
            case "APPROVED":
                return Answer.APPROVED;
            case "DENIED":
                return Answer.DENIED;
            case "ERROR":
                return Answer.ERROR;
            default:
                throw new IllegalArgumentException("Недопустимый ответ: " + answer);
        }
    }
}