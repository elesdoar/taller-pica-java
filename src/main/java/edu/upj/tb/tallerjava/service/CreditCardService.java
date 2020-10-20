package edu.upj.tb.tallerjava.service;

import edu.upj.tb.tallerjava.domain.CreditCard;
import edu.upj.tb.tallerjava.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreditCardService {
    private final CreditCardRepository repository;

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    public Boolean verifyCreditCard(String number, String type) {
        Optional<CreditCard> creditCard = this.repository.findByTypeAndNumber(type, number);
        return creditCard.isPresent();
    }

    public Boolean chargeCreditCard(String number, String type, Double amount) {
        Optional<CreditCard> creditCard = this.repository.findByTypeAndNumber(type, number);

        return creditCard
                .filter(card -> card.getAvailable().doubleValue() >= amount)
                .isPresent();
    }

    @Transactional
    public CreditCard save(CreditCard creditCard) {
        return this.repository.save(creditCard);
    }
}
