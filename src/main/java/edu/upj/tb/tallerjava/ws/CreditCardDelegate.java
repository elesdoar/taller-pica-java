package edu.upj.tb.tallerjava.ws;

import edu.upj.tb.tallerjava.service.CreditCardService;
import edu.upj.tb.tallerjava.ws.request.ChargeCreditCardElement;
import edu.upj.tb.tallerjava.ws.request.ChargeCreditCardResponseElement;
import edu.upj.tb.tallerjava.ws.request.CreditCard;
import edu.upj.tb.tallerjava.ws.request.VerifyCreditCardElement;
import edu.upj.tb.tallerjava.ws.request.VerifyCreditCardResponseElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CreditCardDelegate {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardDelegate.class);
    private static final String NAMESPACE_URI = "http://services.creditverifier.com/";
    private final CreditCardService service;

    public CreditCardDelegate(CreditCardService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "verifyCreditCardElement")
    @ResponsePayload
    public VerifyCreditCardResponseElement verifyCreditCard(@RequestPayload VerifyCreditCardElement request) {
        logger.debug("Executing verifyCreditCard");
        CreditCard creditCard = request.getCc();
        Boolean isVerified = service
                .verifyCreditCard(creditCard.getNumber(), creditCard.getType());
        VerifyCreditCardResponseElement response = new VerifyCreditCardResponseElement();
        response.setResult(isVerified);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "chargeCreditCardElement")
    @ResponsePayload
    public ChargeCreditCardResponseElement chargeCreditCard(@RequestPayload ChargeCreditCardElement request) {
        logger.debug("Executing chargeCreditCard");
        CreditCard creditCard = request.getCc();
        Boolean isCharged = service
                .chargeCreditCard(creditCard.getNumber(), creditCard.getType(), creditCard.getMount());
        ChargeCreditCardResponseElement response = new ChargeCreditCardResponseElement();
        response.setResult(isCharged);
        return response;
    }
}
