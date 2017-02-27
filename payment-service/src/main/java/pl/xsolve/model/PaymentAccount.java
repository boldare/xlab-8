package pl.xsolve.model;

import javax.persistence.*;

@Entity
public class PaymentAccount {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(unique=true)
    protected Long accountId;
    protected Integer balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
