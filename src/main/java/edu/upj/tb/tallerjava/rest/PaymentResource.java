package edu.upj.tb.tallerjava.rest;

import edu.upj.tb.tallerjava.domain.Payment;
import edu.upj.tb.tallerjava.rest.vm.PaymentVM;
import edu.upj.tb.tallerjava.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/payment")
@RestController
public class PaymentResource {
    private final PaymentService service;

    public PaymentResource(PaymentService service) {
        this.service = service;
    }


    @PostMapping
    @Transactional
    public Payment save(@RequestBody @Valid PaymentVM paymentVM) {
        Payment payment = new Payment();
        payment.setClientId(paymentVM.getClientId());
        payment.setClientName(paymentVM.getClientName());
        payment.setOrderId(paymentVM.getOrderId());
        payment.setState(paymentVM.getState());
        payment.setValue(paymentVM.getValue());
        return service.save(payment);
    }

    @GetMapping
    @Transactional
    public ResponseEntity<Page<Payment>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }
}
