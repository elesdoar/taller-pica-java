package edu.upj.tb.tallerjava.rest.vm;

import edu.upj.tb.tallerjava.domain.enumeration.PaymentState;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

public class PaymentVM implements Serializable {
    @NotNull
    private BigDecimal value;

    @NotNull
    private Long orderId;

    @NotNull
    private Long clientId;

    @Size(max = 255)
    private String clientName;

    @NotNull
    private PaymentState state;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public PaymentState getState() {
        return state;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}
