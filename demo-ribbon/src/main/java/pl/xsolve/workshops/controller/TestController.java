package pl.xsolve.workshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    protected RestTemplate restTemplate;

    @RequestMapping("/{url}")
    public String hi(@PathVariable String url) {
        return restTemplate.getForObject("http://booty/" + url, String.class);
    }
}
