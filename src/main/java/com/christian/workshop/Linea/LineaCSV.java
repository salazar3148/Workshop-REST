package com.christian.workshop.Linea;
import java.time.LocalDate;

public class LineaCSV implements Linea{
    private int index;
    private String userID;
    private String firstName;
    private String lastName;
    private String sex;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private  String jobTitle;
    private String type = "";
    public LineaCSV() {
    }

    public LineaCSV(String linea) {
        String[] line = linea.split(",");
        this.index = Integer.parseInt(line[0]);
        this.userID = line[1];
        this.firstName = line[2];
        this.lastName = line[3];
        this.sex = line[4];
        this.email = line[5];
        this.phone = line[6];
        String[] fecha = line[7].split("-");
        this.dateOfBirth = LocalDate.of(Integer.parseInt(fecha[0]), Integer.parseInt(fecha[1]), Integer.parseInt(fecha[2]));
        this.jobTitle = line[8];
        this.type="csv";
    }
    public int getIndex() {
        return index;
    }
    public String getUserID() {
        return userID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSex() {
        return sex;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    @Override
    public String getType() {
        return type;
    }
}
