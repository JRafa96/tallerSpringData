package org.springframework.samples.petclinic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class WelcomeController {

    @RequestMapping("/")
    public @ResponseBody String welcome() {
        return "Welcome Helder";
    }
}
