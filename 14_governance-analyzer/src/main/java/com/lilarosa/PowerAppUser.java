package com.lilarosa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This annotation tells Jackson to ignore unknown JSON fields
// If the JSON contains extra fields that are not defined here,
// the program will not throw an error
@JsonIgnoreProperties(ignoreUnknown = true)
public class PowerAppUser {

    // User ID (unique identifier)
    private String id;

    // User name
    private String name;

    // User role (e.g., ADMIN, USER)
    private String role;

    // Last login date in format yyyy-MM-dd
    private String lastLoginDate;

    // Indicates if Multi-Factor Authentication is enabled
    private boolean hasMFA;

    // Default constructor (required for Jackson)
    public PowerAppUser() {}

    // Getter and Setter methods

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getLastLoginDate() { return lastLoginDate; }
    public void setLastLoginDate(String lastLoginDate) { this.lastLoginDate = lastLoginDate; }

    public boolean isHasMFA() { return hasMFA; }
    public void setHasMFA(boolean hasMFA) { this.hasMFA = hasMFA; }
}
