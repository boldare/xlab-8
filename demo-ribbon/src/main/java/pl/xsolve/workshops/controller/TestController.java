package pl.xsolve.workshops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private static final String HELLO_PATH = "/hello";
    private static final String REFRESH_PATH = "/refresh";

    private static final String BOOTY_HELLO_PATH = "http://booty/hello";
    private static final String CONFIG_SERVER_PATH = "http://config-server/refresh";

    @Autowired
    protected RestTemplate restTemplate;

    @RequestMapping(HELLO_PATH)
    public String hello() {
        return restTemplate.getForObject(BOOTY_HELLO_PATH, String.class);
    }

    @RequestMapping(REFRESH_PATH)
    public String refresh() {
        return restTemplate.getForObject(CONFIG_SERVER_PATH, String.class);
    }
}
