package pl.xsolve.dto;

import java.math.BigDecimal;

public class SnowReportDTO {

    private String reportDate;
    private String resortName;
    private String resortCountry;
    private String lastSnow;
    private BigDecimal newSnowCm;
    private BigDecimal lowerSnowDepth;
    private BigDecimal upperSnowDepth;
    private String conditions;

    public SnowReportDTO() {

    }

    public SnowReportDTO(String reportDate, String resortName, String resortCountry, String lastSnow, BigDecimal newSnowCm, BigDecimal lowerSnowDepth, BigDecimal upperSnowDepth, String conditions) {
        this.reportDate = reportDate;
        this.resortName = resortName;
        this.resortCountry = resortCountry;
        this.lastSnow = lastSnow;
        this.newSnowCm = newSnowCm;
        this.lowerSnowDepth = lowerSnowDepth;
        this.upperSnowDepth = upperSnowDepth;
        this.conditions = conditions;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getResortName() {
        return resortName;
    }

    public void setResortName(String resortName) {
        this.resortName = resortName;
    }

    public String getResortCountry() {
        return resortCountry;
    }

    public void setResortCountry(String resortCountry) {
        this.resortCountry = resortCountry;
    }

    public String getLastSnow() {
        return lastSnow;
    }

    public void setLastSnow(String lastSnow) {
        this.lastSnow = lastSnow;
    }

    public BigDecimal getNewSnowCm() {
        return newSnowCm;
    }

    public void setNewSnowCm(BigDecimal newSnowCm) {
        this.newSnowCm = newSnowCm;
    }

    public BigDecimal getLowerSnowDepth() {
        return lowerSnowDepth;
    }

    public void setLowerSnowDepth(BigDecimal lowerSnowDepth) {
        this.lowerSnowDepth = lowerSnowDepth;
    }

    public BigDecimal getUpperSnowDepth() {
        return upperSnowDepth;
    }

    public void setUpperSnowDepth(BigDecimal upperSnowDepth) {
        this.upperSnowDepth = upperSnowDepth;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
