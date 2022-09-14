package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Address_Person",
            joinColumns = { @JoinColumn(name = "person_id") },
            inverseJoinColumns = { @JoinColumn(name = "address_id") }
    )
    private Collection<Address> addresses;

    @OneToMany
    private Collection<CreditCard> creditCards;

    @Override
    public String toString(){
        return "Person:" +
                ", name='" + name + '\'' +
                ", creditCard=" + creditCards +
                ", address=" + addresses;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }


    public List<CreditCard> getCreditCards(){
            return creditCards;
        }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

     */


    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;

    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
