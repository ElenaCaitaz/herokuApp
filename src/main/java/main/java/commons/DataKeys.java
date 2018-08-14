package main.java.commons;

public enum DataKeys {
    EMPLOYEE_FIRSTNAME("EMPLOYEE_FIRSTNAME"),
    EMPLOYEE_LASTNAME("EMPLOYEE_LASTNAME");

    private String description;

    DataKeys(String description) {
        this.description = description;
    }
}
