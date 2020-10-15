package edu.upj.tb.tallerjava.ws;

import edu.upj.tb.tallerjava.ws.request.ChargeCreditCardElement;
import edu.upj.tb.tallerjava.ws.request.ChargeCreditCardResponseElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import edu.upj.tb.tallerjava.ws.request.VerifyCreditCardElement;
import edu.upj.tb.tallerjava.ws.request.VerifyCreditCardResponseElement;

@Endpoint
public class CreditCardDelegate {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardDelegate.class);
    private static final String NAMESPACE_URI = "http://services.creditverifier.com/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "verifyCreditCardElement")
    @ResponsePayload
    public VerifyCreditCardResponseElement verifyCreditCard(@RequestPayload VerifyCreditCardElement request) {
        logger.debug("Executing verifyCreditCard");
        VerifyCreditCardResponseElement response = new VerifyCreditCardResponseElement();
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "chargeCreditCardElement")
    @ResponsePayload
    public ChargeCreditCardResponseElement chargeCreditCard(@RequestPayload ChargeCreditCardElement request) {
        logger.debug("Executing chargeCreditCard");
        ChargeCreditCardResponseElement response = new ChargeCreditCardResponseElement();
        response.setResult(true);
        return response;
    }
}
