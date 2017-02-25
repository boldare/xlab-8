package com.xsolve.xlab.com.xsolve.xlab.controller;

import com.xsolve.xlab.com.xsolve.xlab.data.SnowReportDTO;
import com.xsolve.xlab.com.xsolve.xlab.data.SnowReportData;
import com.xsolve.xlab.com.xsolve.xlab.restClient.WeatherServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WeatherServiceController {

    @Autowired
    private WeatherServiceClient client;

    @RequestMapping(method = RequestMethod.GET, value = "snowreports/report")
    public SnowReportDTO snowReport() {

        SnowReportData snowReportData = client.getSnowReport();

        return new SnowReportDTO(
                snowReportData.getReportdate(),
                snowReportData.getResortname(),
                snowReportData.getResortcountry(),
                snowReportData.getLastsnow(),
                snowReportData.getNewsnow_cm(),
                snowReportData.getLowersnow_cm(),
                snowReportData.getUppersnow_cm(),
                snowReportData.getConditions()
                );
    }
}
