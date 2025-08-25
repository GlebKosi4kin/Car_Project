package org.example;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

public class Main{
    private static final String URL = "jdbc:mysql://localhost:3311/CARS?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "DgL7IqfAsQ4apjZUKjM7WxDgh9A+EG0i";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println("Введите номер действия \n 1) Просмотр всех автомобилей \n 2) Добавить свой автомобиль ");

            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();

            if (n == 1) {
                CarManager.showCars();
            } else if (n == 2) {
                CarManager.addCar(scanner, conn);
            }
        }
    }
}