package edu.upj.tb.tallerjava.rest.vm;

import java.io.Serializable;

public class CreditCardVM implements Serializable {
    private String type;
    private Double mount;
    private String number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
