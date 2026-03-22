package com.example.demo.dto;

public class HealthRecordForm {

    private Boolean dangerSign;
    private Double temperature;
    private Integer heartRate;
    private Integer oxygenLevel;
    private String symptomNote;

    public Boolean getDangerSign() {
        return dangerSign;
    }

    public void setDangerSign(Boolean dangerSign) {
        this.dangerSign = dangerSign;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public Integer getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(Integer oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public String getSymptomNote() {
        return symptomNote;
    }

    public void setSymptomNote(String symptomNote) {
        this.symptomNote = symptomNote;
    }
}