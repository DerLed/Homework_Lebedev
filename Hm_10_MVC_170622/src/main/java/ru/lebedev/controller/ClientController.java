package ru.lebedev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ClientController {

    @RequestMapping("/")
    public String showFirstView() {
        return "index";
    }
}
