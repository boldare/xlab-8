package com.xsolve.xlab.com.xsolve.xlab.restClient;

import com.xsolve.xlab.com.xsolve.xlab.data.SnowReportData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Configuration
public class WeatherServiceClient {

    @Value("${api.uri}")
    private String apiURI;

    @Value("${app.id}")
    private String appId;

    @Value("${app.key}")
    private String appKey;

    @Value("${api.resource}")
    private String apiResource;



    public SnowReportData getSnowReport() {

        RestTemplate restTemplate = new RestTemplate();
        URI targetUrl= UriComponentsBuilder.fromUriString(apiURI)
                .path(apiResource)
                .queryParam("app_id", appId)
                .queryParam("app_key", appKey)
                .build()
                .toUri();

        return restTemplate.getForObject(targetUrl, SnowReportData.class);
    }


}