package pl.xsolve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.xsolve.model.TransactionDTO;
import pl.xsolve.model.PaymentAccountDTO;
import pl.xsolve.services.PaymentService;

@RestController
public class PaymentController {

    protected final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.POST)
    public PaymentAccountDTO createPaymentAccount(@PathVariable Long accountId) {
        return paymentService.create(accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public PaymentAccountDTO getOne(@PathVariable Long accountId) {
        return paymentService.getOne(accountId);
    }

    @RequestMapping(value = "/accounts/{accountId}/coins", method = RequestMethod.PUT)
    public TransactionDTO updateAccountBalance(@PathVariable Long accountId, @RequestBody TransactionDTO transactionDTO) {
        return paymentService.updateAccountBalance(accountId, transactionDTO);
    }
}
