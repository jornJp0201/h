package com.crm.admin_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

        if (model.containsAttribute("successSave")) {
                model.addAttribute("successSave", "保存に成功しました");
            }else{
                model.addAttribute("errorSave", "保存に失敗しました");
            }
       
        try{
            List<CustomerEntity> resultList = customerService.outputCustomer(); //顧客情報の出力
            model.addAttribute("successMessage","javaとの通信に成功しました");
            model.addAttribute("resultList", resultList);
            System.out.println("データ個数"+resultList.size());
            return "index";
        }catch(Exception e){
            model.addAttribute("errorMessage","javaとの通信に失敗しました");
            model.addAttribute("resultList", emptyList);
            return "index";
        }
     }
     
    
     @PostMapping("/create/All/Save")
         public String save(
            @ModelAttribute CustomerEntity customerEntity,
            RedirectAttributes redirectAttributes
         ){
            try{
                customerService.saveCustomer(customerEntity);   
                redirectAttributes.addFlashAttribute("successSave", "保存に成功しました");
                return "redirect:/customers/table";
            }catch(Exception e){
                System.err.println("============ ❌ 保存失敗のエラー内容 ============");
                e.printStackTrace(); 
                System.err.println("==================================================");
                return "redirect:/customers/table";
            }
    }


}


@Service
@Transactional
class CustomerService{
    private final CostomerRepository costomerRepository;

    public CustomerService(CostomerRepository costomerRepository){
        this.costomerRepository = costomerRepository;
    }

    @Transactional
    public void saveCustomer(CustomerEntity customerEntity){//顧客用法の保存
        costomerRepository.save(customerEntity);
    }
    @Transactional(readOnly = true)
    public  List<CustomerEntity> outputCustomer(){ //顧客情報の出力
        return costomerRepository.findAll();
    }
}

