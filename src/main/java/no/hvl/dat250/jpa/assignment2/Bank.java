package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "owningBank")
    private Set<CreditCard> ownedCards;

    @Override
    public String toString(){
        return "Bank" +
                "name='" + name + '\'';
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public void setOwnedCards(Set<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }
    /*
    public List<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }


    */

}
