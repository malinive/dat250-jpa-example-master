package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public class CreditCard {
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private int balance;
    private int limit;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "owningBank_id")
    private Bank owningBank;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="pincode_id")
    private Pincode pincode;



    @Override
    public String toString(){
        return "CreditCard" +
                "number=" + number +
                ", limit=" + limit +
                ", balance=" + balance +
                ", bank=" + owningBank +
                ", pinCode=****" ;
    }




    public int getNumber() {
        return number;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {

        return owningBank;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }

    /*

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

     */




}
