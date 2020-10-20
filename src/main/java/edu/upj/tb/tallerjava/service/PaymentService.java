package edu.upj.tb.tallerjava.service;

import edu.upj.tb.tallerjava.domain.Payment;
import edu.upj.tb.tallerjava.repository.PaymentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Transactional
    public Page<Payment> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
