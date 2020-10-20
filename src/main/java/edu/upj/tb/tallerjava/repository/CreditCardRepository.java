package edu.upj.tb.tallerjava.repository;

import edu.upj.tb.tallerjava.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    Optional<CreditCard> findByTypeAndNumber(String type, String number);
}
