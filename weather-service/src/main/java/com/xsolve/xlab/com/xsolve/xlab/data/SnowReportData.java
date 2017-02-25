package com.xsolve.xlab.com.xsolve.xlab.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SnowReportData {


    private String resortname;
    private String resortcountry;
    private BigDecimal newsnow_cm;
    private BigDecimal lowersnow_cm;
    private BigDecimal uppersnow_cm;
    private String lastsnow;
    private String reportdate;
    private String conditions;

    public String getResortname() {
        return resortname;
    }

    public void setResortname(String resortname) {
        this.resortname = resortname;
    }

    public String getResortcountry() {
        return resortcountry;
    }

    public void setResortcountry(String resortcountry) {
        this.resortcountry = resortcountry;
    }

    public BigDecimal getNewsnow_cm() {
        return newsnow_cm;
    }

    public void setNewsnow_cm(BigDecimal newsnow_cm) {
        this.newsnow_cm = newsnow_cm;
    }

    public BigDecimal getLowersnow_cm() {
        return lowersnow_cm;
    }

    public void setLowersnow_cm(BigDecimal lowersnow_cm) {
        this.lowersnow_cm = lowersnow_cm;
    }

    public BigDecimal getUppersnow_cm() {
        return uppersnow_cm;
    }

    public void setUppersnow_cm(BigDecimal uppersnow_cm) {
        this.uppersnow_cm = uppersnow_cm;
    }

    public String getLastsnow() {
        return lastsnow;
    }

    public void setLastsnow(String lastsnow) {
        this.lastsnow = lastsnow;
    }

    public String getReportdate() {
        return reportdate;
    }

    public void setReportdate(String reportdate) {
        this.reportdate = reportdate;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "SnowReportData{" +
                "resortname='" + resortname + '\'' +
                ", resortcountry='" + resortcountry + '\'' +
                ", newsnow_cm=" + newsnow_cm +
                ", lowersnow_cm=" + lowersnow_cm +
                ", uppersnow_cm=" + uppersnow_cm +
                ", lastsnow='" + lastsnow + '\'' +
                ", reportdate='" + reportdate + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}



