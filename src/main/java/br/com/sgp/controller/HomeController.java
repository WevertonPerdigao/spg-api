package br.com.sgp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.util.Constants;

@RestController
@CrossOrigin(origins = "http://localhost:"+Constants.PORTA)
public class HomeController {

    @RequestMapping("/")
    public String irParaHome() {
        return "index";
    }
}