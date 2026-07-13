package com.crm.admin_app;

import org.springframework.web.bind.annotation.GetMapping;

public class admin_app {

    @GetMapping("/")
     public String index(){
        return "index";
     }

     @GetMapping("/create")
        public String create(){
            return "create";
        }

     @GetMapping("edit")
        public String edit(){
            return "edit";
        }

    
}
