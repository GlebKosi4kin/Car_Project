package org.example;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
import java.util.Scanner;

public class CarManager {

    protected static void showCars(PrintWriter writer) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://bold_johnson:3306/CARS?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "root";
        String password = "DgL7IqfAsQ4apjZUKjM7WxDgh9A+EG0i";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            writer.println("Успешно подключено к базе 'cars'!");
            writer.println("Машины, добавленные в базу данных: ");
            // Пример: вывод всех автомобилей
            String sql = "SELECT id, brand, model, year, engine, gearbox FROM car";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    writer.printf(" %d | %s %s | %d год | Двигатель: %s | КПП: %s%n",
                            rs.getInt("id"),
                            rs.getString("brand"),
                            rs.getString("model"),
                            rs.getInt("year"),
                            rs.getString("engine"),
                            rs.getString("gearbox"));
                }
            }

        } catch (SQLException e) {
            writer.println("Ошибка подключения к базе данных:" + e.getMessage());
        }
    }

    protected static void showCars() {
        String url = "jdbc:mysql://localhost:3311/CARS?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "DgL7IqfAsQ4apjZUKjM7WxDgh9A+EG0i";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Успешно подключено к базе 'cars'!");
            System.out.println("Машины, добавленные в базу данных: ");
            // Пример: вывод всех автомобилей
            String sql = "SELECT id, brand, model, year, engine, gearbox FROM car";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    System.out.printf(" %d | %s %s | %d год | Двигатель: %s | КПП: %s%n",
                            rs.getInt("id"),
                            rs.getString("brand"),
                            rs.getString("model"),
                            rs.getInt("year"),
                            rs.getString("engine"),
                            rs.getString("gearbox"));
                }
            }

        } catch (SQLException e) {
            System.err.println("Ошибка подключения к базе данных:");
        }
    }

    protected static void addCar(Scanner scanner, Connection conn) {
        try {
            System.out.print("Введите марку: ");
            String brand = scanner.nextLine();

            System.out.print("Введите модель: ");
            String model = scanner.nextLine();

            System.out.print("Введите год выпуска: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите тип двигателя (например, 2.0L): ");
            String engine = scanner.nextLine();

            System.out.print("Введите тип КПП (например, Automatic): ");
            String gearbox = scanner.nextLine();


            String sql = "INSERT INTO car (brand, model, year, engine, gearbox) VALUES (?, ?, ?, ?, ?)" ;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, brand);
                pstmt.setString(2, model);
                pstmt.setInt(3, year);
                pstmt.setString(4, engine);
                pstmt.setString(5, gearbox);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Автомобиль успешно добавлен!");
                }
            }

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат года.");
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении автомобиля:");
        }
    }
}
