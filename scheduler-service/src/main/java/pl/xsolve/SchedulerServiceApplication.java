package pl.xsolve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableAutoConfiguration
public class SchedulerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerServiceApplication.class, args);
	}

	@Bean
    public RestOperations getRestOperations() {
	    return new RestTemplate();
    }

    @RestController
    class ServiceInstanceRestController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping("/service-instances/{applicationName}")
        public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
            return this.discoveryClient.getInstances(applicationName);
        }

        @RequestMapping(method = RequestMethod.GET, value = "/test")
        public String serviceInstancesByApplicationName() {
            return "OK";
        }
    }
}
