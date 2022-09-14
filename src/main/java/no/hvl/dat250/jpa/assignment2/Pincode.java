package no.hvl.dat250.jpa.assignment2;

import lombok.Data;

import javax.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pincode;
    private int count;

/*
    @Override
    public String toString(){
        return "Todo [id=" + id+ ", pincode=" + pincode + ", count=" + count
                + "]";
    }

 */



    public Long getId() {
        return id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
