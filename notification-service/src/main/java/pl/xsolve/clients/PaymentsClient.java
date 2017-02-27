package pl.xsolve.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.xsolve.model.TransactionDTO;

@FeignClient(name = "payment-service")
public interface PaymentsClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/coins")
    TransactionDTO payCoinsIfUserHasAny(@PathVariable("accountId") Long accountId, @RequestBody TransactionDTO transactionDTO);
}
