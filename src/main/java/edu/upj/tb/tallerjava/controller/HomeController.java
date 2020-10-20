package edu.upj.tb.tallerjava.controller;

import edu.upj.tb.tallerjava.domain.Payment;
import edu.upj.tb.tallerjava.service.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final PaymentService paymentService;

    public HomeController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public String home(Model model, Pageable pageable) {
        Page<Payment> payments = paymentService.findAll(pageable);
        model.addAttribute("payments", payments);
        return "index.html";
    }
}
