package com.crm.admin_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class admin_app {

    @GetMapping("/index")
     public String index(){
        return "index";
     }

     @GetMapping("/")
     public String first_index(){
        return "redirect:/customers/table";
     }

     

     @GetMapping("edit")
        public String edit(){
            return "edit";
        }

    
}
