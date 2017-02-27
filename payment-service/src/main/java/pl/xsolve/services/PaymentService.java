package pl.xsolve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.xsolve.model.TransactionDTO;
import pl.xsolve.model.PaymentAccount;
import pl.xsolve.model.PaymentAccountDTO;
import pl.xsolve.repository.PaymentAccountRepository;

@Service
public class PaymentService {

    protected final PaymentAccountRepository paymentAccountRepository;

    @Value("${payment.account.defaultBalance}")
    protected Integer accountDefaultBalance;

    @Autowired
    public PaymentService(final PaymentAccountRepository paymentAccountRepository) {
        this.paymentAccountRepository = paymentAccountRepository;
    }

    public PaymentAccountDTO getOne(Long accountId) {
        return create(paymentAccountRepository.getOneByAccountId(accountId));
    }

    public PaymentAccountDTO create(Long accountId) {
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setAccountId(accountId);
        paymentAccount.setBalance(accountDefaultBalance);

        PaymentAccount savePaymentAccount = paymentAccountRepository.save(paymentAccount);
        return create(savePaymentAccount);
    }

    public PaymentAccountDTO create(PaymentAccount paymentAccount) {
        PaymentAccountDTO paymentAccountDTO = new PaymentAccountDTO();
        paymentAccountDTO.setId(paymentAccount.getId());
        paymentAccountDTO.setBalance(paymentAccount.getBalance());
        paymentAccountDTO.setAccountId(paymentAccount.getAccountId());

        return paymentAccountDTO;
    }

    public TransactionDTO updateAccountBalance(Long accountId, TransactionDTO transactionDTO) {
        PaymentAccount account = paymentAccountRepository.getOneByAccountId(accountId);
        transactionDTO.setStatusFlag(true);
        transactionDTO.setStatusMessage("Operacja powiodła się");

        if (hasEnoughMoney(transactionDTO, account) && transactionDTO.getAction().equals("DECREASE")) {
            account.setBalance(account.getBalance() - transactionDTO.getCoins());
            paymentAccountRepository.save(account);
        } else if (transactionDTO.getAction().equals("INCREASE")) {
            account.setBalance(account.getBalance() + transactionDTO.getCoins());
            paymentAccountRepository.save(account);
        } else {
            transactionDTO.setStatusMessage("Operacja nie powiodła się. Brak środków na koncie.");
            transactionDTO.setStatusFlag(false);
        }

        return transactionDTO;
    }

    private Boolean hasEnoughMoney(TransactionDTO transactionDTO, PaymentAccount paymentAccount) {
        return paymentAccount.getBalance() >= transactionDTO.getCoins();
    }
}
