package com.lilarosa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {

        try {
            // Create an ObjectMapper instance
            // This class is used to convert JSON data into Java objects
            ObjectMapper mapper = new ObjectMapper();

            // Read the JSON file and convert it into a List of PowerAppUser objects
            // TypeReference is required because we are reading a List, not a single object
            List<PowerAppUser> users = mapper.readValue(
                new File("data/users.json"),
                new TypeReference<List<PowerAppUser>>() {}
            );

            // Print all users with their MFA status
            System.out.println("=== All Users ===");
            for (PowerAppUser user : users) {
                System.out.println(user.getName() + " - MFA: " + user.isHasMFA());
            }

            // --------------------------------------------------
            // SECURITY ANALYSIS 1: Find users without MFA
            // MFA (Multi-Factor Authentication) is important for security
            // Users without MFA are considered a security risk
            // --------------------------------------------------
            System.out.println("\n=== Risk Users (MFA disabled) ===");

            for (PowerAppUser user : users) {
                // If MFA is not enabled, print warning
                if (!user.isHasMFA()) {
                    System.out.println("⚠️ Risk User: "
                            + user.getId() + " | "
                            + user.getName() + " | "
                            + user.getRole());
                }
            }

            // --------------------------------------------------
            // SECURITY ANALYSIS 2: Count users by role
            // Example: ADMIN, USER, etc.
            // This helps understand system structure and permissions
            // --------------------------------------------------
            Map<String, Integer> roleCount = new HashMap<>();

            for (PowerAppUser user : users) {
                // Increase count for each role
                roleCount.put(
                    user.getRole(),
                    roleCount.getOrDefault(user.getRole(), 0) + 1
                );
            }

            System.out.println("\n=== Role Statistics ===");
            System.out.println(roleCount);

            // --------------------------------------------------
            // SECURITY ANALYSIS 3: Find inactive users
            // Users who have not logged in for more than 90 days
            // These accounts may be unused or risky
            // --------------------------------------------------
            System.out.println("\n=== Inactive Users (over 90 days) ===");

            LocalDate today = LocalDate.now();

            for (PowerAppUser user : users) {

                // Convert string date to LocalDate
                LocalDate lastLogin = LocalDate.parse(user.getLastLoginDate());

                // Calculate the difference in days
                long daysInactive = ChronoUnit.DAYS.between(lastLogin, today);

                // Check if user is inactive
                if (daysInactive > 90) {
                    System.out.println("🕒 Inactive User: "
                            + user.getName()
                            + " | Last Login: " + user.getLastLoginDate()
                            + " (" + daysInactive + " days ago)");
                }
            }

        } catch (Exception e) {
            // Print full error stack trace for debugging
            e.printStackTrace();
        }
    }
}
