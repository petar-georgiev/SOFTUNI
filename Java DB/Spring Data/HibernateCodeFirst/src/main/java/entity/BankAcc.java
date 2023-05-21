package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "bank_accounts")
public class BankAcc extends BillingDetail{
    private String name;
    private String swift;

    public BankAcc() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
