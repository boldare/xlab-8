package pl.xsolve.serivces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.xsolve.clients.AccountPaymentsClient;
import pl.xsolve.model.UserAccount;
import pl.xsolve.model.UserAccountDTO;
import pl.xsolve.repository.UserAccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService {


    protected final UserAccountRepository accountRepository;
    protected final AccountPaymentsClient accountPaymentsClient;

    @Autowired
    public UserAccountService(UserAccountRepository accountRepository, AccountPaymentsClient accountPaymentsClient) {
        this.accountRepository = accountRepository;
        this.accountPaymentsClient = accountPaymentsClient;
    }


    public UserAccountDTO create(final UserAccountDTO accountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(accountDTO.getEmail());
        userAccount.setLogin(accountDTO.getLogin());
        userAccount.setPassword(accountDTO.getPassword());
        userAccount.setName(accountDTO.getName());
        userAccount.setLastName(accountDTO.getLastName());
        userAccount.setAge(accountDTO.getAge());
        userAccount.setImageUrl(accountDTO.getImageUrl());
        userAccount.setCity(accountDTO.getCity());

        UserAccount saved = accountRepository.save(userAccount);
        accountDTO.setId(saved.getId());

        accountPaymentsClient.createPaymentsAccount(saved.getId());

        return accountDTO;
    }


    public List<UserAccountDTO> getAll() {
        List<UserAccount> allUserAccounts = accountRepository.findAll();

        return allUserAccounts.stream()
                          .map(this::create)
                          .collect(Collectors.toList());
    }

    public UserAccountDTO create(UserAccount userAccount) {
        UserAccountDTO accountDTO = new UserAccountDTO();
        accountDTO.setLogin(userAccount.getLogin());
        accountDTO.setEmail(userAccount.getEmail());
        accountDTO.setPassword(userAccount.getPassword());
        accountDTO.setId(userAccount.getId());
        accountDTO.setName(userAccount.getName());
        accountDTO.setLastName(userAccount.getLastName());
        accountDTO.setAge(userAccount.getAge());
        accountDTO.setImageUrl(userAccount.getImageUrl());
        accountDTO.setCity(userAccount.getCity());

        return accountDTO;
    }

    public String getEmail(Long accountId) {
        UserAccount userAccount = accountRepository.getOne(accountId);

        return userAccount.getEmail();
    }
}
