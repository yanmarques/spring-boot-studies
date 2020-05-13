package com.api.unisul.apiunisul.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String pingPong(@RequestParam(name="action", required=false) String action) {
        if (action == null) {
            return "home";
        }

        switch (action) {
            case "ping": return "pong"; // no-break
            default: return "404"; // no-break
        }
    }
}
