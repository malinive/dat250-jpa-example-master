package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;

     @ManyToMany(mappedBy = "addresses")
    private Set<Person> owners;

     @Override
    public String toString(){
         return "Address" +
                 ", street='" + street + '\'' +
                 ", Number=" + number;
     }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street){
        this.street=street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number){
        this.number=number;
    }

/*
    public void setOwners(Collection<Person> owners) {
        this.owners = owners;
    }
    */

    public void setOwners(Set<Person> owners) {
        this.owners = owners;
    }

    public Collection<Person> getOwners() {
        return owners;
    }


}
