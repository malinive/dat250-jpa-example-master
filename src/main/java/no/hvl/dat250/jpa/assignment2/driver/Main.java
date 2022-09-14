package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;
import java.util.List;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";
    private static EntityManagerFactory factory;
    public static void main(String[] args) {


        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select p from Person p");
        List<Person> personList = q.getResultList();
        for (Person person : personList) {
            System.out.println(personList);
        }
        System.out.println("Size: " + personList.size());


        Person person = new Person();
        person.setName("Max Mustermann");


        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        creditCard1.setPincode(pincode);

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);

        creditCard2.setPincode(pincode);


        Set<CreditCard> creditCards = new HashSet<>();
        creditCards.add(creditCard1);
        creditCards.add(creditCard2);
        //person.setCreditCards(List<CreditCard> creditCards);
        person.setCreditCards(new ArrayList<>(Collections.singleton(creditCard1)));
        person.getCreditCards().add(creditCard2);



        Bank bank = new Bank();
        bank.setName("Pengebank");

        em.getTransaction().begin();

        em.persist(person);
        em.persist(address);
        em.persist(creditCard1);
        em.persist(creditCard2);

        em.persist(bank);

        em.getTransaction().commit();
        em.close();





    }
}
