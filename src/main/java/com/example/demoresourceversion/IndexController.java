package com.example.demoresourceversion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Index Controller
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
