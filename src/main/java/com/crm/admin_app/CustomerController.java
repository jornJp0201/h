package com.crm.admin_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private ArrayList<String> emptyList = new ArrayList<>();//落ちないように空のリストを作成

    public CustomerController(CustomerService customerService){
         this.customerService = customerService;
    } 

     @GetMapping("table")//ここにあとで顧客一覧を表示っせるためのmodelを作る
     public String getMethodName(Model model) { //
       
        try{
            List<CustomerEntity> resultList = customerService.outputCustomer(); //顧客情報の出力
            model.addAttribute("successMessage","javaとの通信に成功しました");
            model.addAttribute("customers", resultList);
            return "redirect:/index";
        }catch(Exception e){
            model.addAttribute("errorMessage","javaとの通信に失敗しました");
            model.addAttribute("customers",emptyList);
            return "redirect:/index";
        }
     }
     
    
     @PostMapping("/create/All/Save")
         public String save(
            @ModelAttribute CustomerEntity customerEntity,
            Model model
         ){
            try{
                customerService.saveCustomer(customerEntity);   
                model.addAttribute("successSave","保存に成功しました");
                return "redirect:/customers/table";
            }catch(Exception e){
                model.addAttribute("errorSave","保存に失敗しました");
                return "redirect:/customers/table";
            }
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

    public  List<CustomerEntity> outputCustomer(){ //顧客情報の出力
        return costomerRepository.findAll();
    }
}

