package com.crm.admin_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.Controller;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
@GetMapping("/test")
    public void test(){

    }


}
