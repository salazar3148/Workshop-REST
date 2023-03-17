package com.christian.workshop.Linea;
import com.fasterxml.jackson.databind.JsonNode;

public class LineaExcel implements Linea {
    private double date;
    private String injuryLocation;
    private String gender;
    private String ageGroup;
    private String incidentType;
    private double daysLost;
    private String plant;
    private String reportType;
    private String shift;
    private String department;
    private double incidentCost;
    private String wkDay;
    private double month;
    private double year;

    public LineaExcel(){
    }
    public LineaExcel(String[] linea) {
        this.date = Double.parseDouble(linea[0]);
        this.injuryLocation = linea[1];
        this.gender = linea[2];
        this.ageGroup = linea[3];
        this.incidentType = linea[4];
        this.daysLost = Double.parseDouble(linea[5]);
        this.plant = linea[6];
        this.reportType = linea[7];
        this.shift = linea[8];
        this.department = linea[9];
        this.incidentCost = Double.parseDouble(linea[10]);
        this.wkDay = linea[11];
        this.month = Double.parseDouble(linea[12]);
        this.year = Double.parseDouble(linea[13]);
    }
    public double getDate() {
        return date;
    }

    public String getInjuryLocation() {
        return injuryLocation;
    }

    public String getGender() {
        return gender;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public double getDaysLost() {
        return daysLost;
    }

    public String getPlant() {
        return plant;
    }

    public String getReportType() {
        return reportType;
    }

    public String getShift() {
        return shift;
    }

    public String getDepartment() {
        return department;
    }

    public double getIncidentCost() {
        return incidentCost;
    }

    public String getWkDay() {
        return wkDay;
    }

    public double getMonth() {
        return month;
    }

    public double getYear() {
        return year;
    }

    @Override
    public String getType() {
        return "xlsx";
    }

}
