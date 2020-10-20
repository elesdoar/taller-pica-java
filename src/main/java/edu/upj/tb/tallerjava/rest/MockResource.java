package edu.upj.tb.tallerjava.rest;

import com.github.javafaker.Faker;
import edu.upj.tb.tallerjava.domain.CreditCard;
import edu.upj.tb.tallerjava.service.CreditCardService;
import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RequestMapping("/api/mock")
@RestController
public class MockResource {
    private final CreditCardService creditCardService;
    private final Faker faker = new Faker(new Locale("en"));

    public MockResource(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/create-credit-cards")
    @Transactional
    public ResponseEntity<List<CreditCard>> createCreditCards(@RequestParam(required = false, defaultValue = "10") Integer size) {
        List<CreditCard> creditCards = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            CreditCard creditCard = new CreditCard();
            creditCard.setNumber(faker.business().creditCardNumber().replace("-", ""));
            creditCard.setType(faker.business().creditCardType());
            BigDecimal available = BigDecimal.valueOf(faker.number().randomDouble (0, 2000L, 2000000L));
            creditCard.setAvailable(available);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-M-dd" );
            Date start = Date.from(LocalDate.of(2019, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC));
            Date end = Date.from(LocalDate.of(2030, 12, 31).atStartOfDay().toInstant(ZoneOffset.UTC));
            Date expiredDate = faker.date().between(start, end);
            creditCard.setExpirationDate(expiredDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            creditCard = this.creditCardService.save(creditCard);
            creditCards.add(creditCard);
        }

        return ResponseEntity.ok(creditCards);
    }
}
