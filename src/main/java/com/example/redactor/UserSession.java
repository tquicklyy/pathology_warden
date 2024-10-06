package com.example.redactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSession {
    private static int userId;
    private static Connection connOfUser;
    private static boolean isLogged;

    public static boolean isIsLogged() {
        return isLogged;
    }

    public static int getUserId() {
        return userId;
    }

    public static void connectToDb() {
        try {
            connOfUser = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pathologywarden", "editor_user", "Pbp4LfKpLyfo");
            if (connOfUser != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void addUser(String userName, String email, int password, String first_name, String last_name, String patronymic) {
        String queryForDB = "INSERT INTO users (username, email, password, first_name, last_name, patronymic) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
        try {
            PreparedStatement ps = connOfUser.prepareStatement(queryForDB);
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, String.valueOf(password));
            ps.setString(4, first_name);
            ps.setString(5, last_name);
            ps.setString(6, patronymic);
            ResultSet rs = ps.executeQuery();
            System.out.println(2);
            rs.next();
            userId = rs.getInt("id");
            isLogged = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
