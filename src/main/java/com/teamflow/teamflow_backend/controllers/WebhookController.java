package com.teamflow.teamflow_backend.controllers;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/webhook")
@CrossOrigin
public class WebhookController {

    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping
    public String receiveWebhook(@RequestBody String payload) {
        logger.info("Webhook ontvangen: {}", payload);

        return "Webhook processed successfully";
    }
}