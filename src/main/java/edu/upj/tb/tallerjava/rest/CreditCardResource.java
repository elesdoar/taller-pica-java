package edu.upj.tb.tallerjava.rest;

import edu.upj.tb.tallerjava.rest.vm.CreditCardVM;
import edu.upj.tb.tallerjava.service.CreditCardService;
import edu.upj.tb.tallerjava.service.dto.ObjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/credit-card")
@RestController
public class CreditCardResource {
    private final CreditCardService service;

    public CreditCardResource(CreditCardService service) {
        this.service = service;
    }

    @GetMapping("/verify-credit-card")
    public ResponseEntity<ObjectDTO<Boolean>> verifyCreditCard(CreditCardVM creditCardVM) {
        Boolean isVerified =
                this.service.verifyCreditCard(creditCardVM.getNumber(), creditCardVM.getType());
        ObjectDTO<Boolean> dto = new ObjectDTO<>(isVerified);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/charge-credit-card")
    public ResponseEntity<ObjectDTO<Boolean>> chargeCreditCard(@RequestBody CreditCardVM creditCardVM) {
        Boolean isCharged =
                this.service.chargeCreditCard(creditCardVM.getNumber(), creditCardVM.getType(), creditCardVM.getMount());
        ObjectDTO<Boolean> dto = new ObjectDTO<>(isCharged);
        return ResponseEntity.ok(dto);
    }
}
