package pl.xsolve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.xsolve.clients.PaymentsClient;
import pl.xsolve.model.TransactionDTO;

@Service
public class CoinService {

    @Value("${payment.cost.email}")
    protected Integer emailCost;

    @Value("${payment.cost.sms}")
    protected Integer smsCost;

    protected final PaymentsClient paymentsClient;

    @Autowired
    public CoinService(PaymentsClient paymentsClient) {
        this.paymentsClient = paymentsClient;
    }

    public TransactionDTO payForEmail(Long accountId) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAction("DECREASE");
        transactionDTO.setCoins(emailCost);
        return paymentsClient.payCoinsIfUserHasAny(accountId, transactionDTO);
    }
}
