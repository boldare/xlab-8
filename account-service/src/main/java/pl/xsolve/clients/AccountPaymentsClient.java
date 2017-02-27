package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment-service")
public interface AccountPaymentsClient {
    @RequestMapping(method = RequestMethod.POST, value = "/accounts/{accountId}")
    String createPaymentsAccount(@PathVariable("accountId") Long accountId);
}
