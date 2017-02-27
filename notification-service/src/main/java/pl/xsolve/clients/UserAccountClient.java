package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.xsolve.model.UserAccountDTO;

@FeignClient(name = "user-account-service")
public interface UserAccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user-accounts/{accountId}")
    UserAccountDTO getUserAccount(@PathVariable("accountId") Long accountId);
}
