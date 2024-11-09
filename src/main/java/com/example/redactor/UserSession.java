package com.example.redactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSession {
    private static int userId;
    private static Connection connOfUser;
    private static boolean isLogged;

    public static HashMap<String, String> patientFirstName = new HashMap<>();
    public static HashMap<String, String> patientLastName = new HashMap<>();
    public static HashMap<String, String> patientPatronymicName = new HashMap<>();
    public static ArrayList<String> nameOfReport = new ArrayList<>();

    public static boolean isIsLogged() {
        return isLogged;
    }

    public static int getUserId() {
        return userId;
    }

    public static void connectToDb() {
        try {
            connOfUser = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pathologywarden", "editor_user", "Pbp4LfKpLyfo");
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
            rs.next();
            userId = rs.getInt("id");
            isLogged = true;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean getUserIdByLoginEmailPassword(String LoginOrEmail, String password) {
        Pattern patternForRegex = Pattern.compile("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)");
        Matcher matcherForEmail = patternForRegex.matcher(LoginOrEmail);
        String query;
        try {
            if(matcherForEmail.find()) {
                query = "SELECT id from users WHERE email = ? AND password = ?";
            }
            else {
                query = "SELECT id from users WHERE username = ? AND password = ?";
            }
            PreparedStatement ps = connOfUser.prepareStatement(query);
            ps.setString(1, LoginOrEmail);
            ps.setString(2, String.valueOf(password.hashCode()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            userId = rs.getInt("id");
            isLogged = true;
            return isLogged;
        } catch (Exception e) {
            System.out.println("Ошибка при получении названия отдела: " + e.getMessage());
            return isLogged;
        }
    }

    public static void addResearch(String[] nameParts, String nameOfReport) {
        String queryForDB = "INSERT INTO report (doctor, name, patient_first_name, patient_last_name, patient_patronymic_name, verdict, image, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try {
            String patient_last_name = nameParts[0];
            String patient_first_name = nameParts[1];
            String patient_patronymic = "";
            for(int i = 2; i < nameParts.length; i++ ) {
                patient_patronymic += nameParts[i];
            }
            String verdict = "Здоров";
            String pathToImage = "\"C:\\Users\\abcd\\Pictures\\research_number_1.jpg\"";

            PreparedStatement ps = connOfUser.prepareStatement(queryForDB);
            ps.setInt(1, userId);
            ps.setString(2, nameOfReport);
            ps.setString(3, patient_first_name);
            ps.setString(4, patient_last_name);
            ps.setString(5, patient_patronymic);
            ps.setString(6, verdict);
            ps.setString(7, pathToImage);
            ps.setObject(8, LocalDateTime.now());
            ps.setObject(9, LocalDateTime.now());
            ResultSet rs = ps.executeQuery();
            rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getResearches() {
        String queryForDB = "SELECT name, patient_first_name, patient_last_name, patient_patronymic_name FROM report WHERE report.doctor = ?";
        try {
            PreparedStatement ps = connOfUser.prepareStatement(queryForDB);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            patientFirstName.clear();
            patientLastName.clear();
            patientPatronymicName.clear();
            nameOfReport.clear();

            String nameOfCurrentReport;

            while(rs.next()){
                nameOfCurrentReport = rs.getString("name");
                patientFirstName.put(nameOfCurrentReport, rs.getString("patient_first_name"));
                patientLastName.put(nameOfCurrentReport, rs.getString("patient_last_name"));
                patientPatronymicName.put(nameOfCurrentReport, rs.getString("patient_patronymic_name"));
                nameOfReport.add(nameOfCurrentReport);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteReport(String nameOfReport) {
        String queryForDB = "DELETE FROM report WHERE name = ?";
        try {
            PreparedStatement ps = connOfUser.prepareStatement(queryForDB);
            ps.setString(1, nameOfReport);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
