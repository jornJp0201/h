package com.crm.admin_app;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.Controller;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
     @GetMapping("/create/All")
         public void save(
            @ModelAttribute CustomerEntity customerEntity,
            Model model
         ){
             
    }


}
　

@Service
class CustomerService{
    private final CostomerRepository costomerRepository;

    public CustomerService(CostomerRepository costomerRepository){
        this.costomerRepository = costomerRepository;
    }

    public void saveCustomer(CustomerEntity customerEntity){//顧客用法の保存
        costomerRepository.save(customerEntity);
    }

}

