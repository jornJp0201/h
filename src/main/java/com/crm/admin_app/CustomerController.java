package com.crm.admin_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private ArrayList<String> emptyList = new ArrayList<>();//落ちないように空のリストを作成

    public CustomerController(CustomerService customerService){
         this.customerService = customerService;
    } 

    @GetMapping("/create")
        public String create(Model model){
            if (!model.containsAttribute("customerEntity")) {  
            model.addAttribute("customerEntity", new CustomerEntity());
        }
            return "create";
    }

     @GetMapping("/table")//ここにあとで顧客一覧を表示っせるためのmodelを作る
     public String getMethodName(Model model) { //

       
        try{
            List<CustomerEntity> resultList = customerService.outputCustomer(); //顧客情報の出力
            model.addAttribute("successMessage","javaとの通信に成功しました");
            model.addAttribute("resultList", resultList);
            System.out.println("データ個数"+resultList.size());//データ確認用
            return "index";
        }catch(Exception e){
            System.err.println("============ ❌ 保存失敗のエラー内容 ============");
            e.printStackTrace(); 
            System.err.println("==================================================");
            model.addAttribute("errorMessage","javaとの通信に失敗しました");
            //model.addAttribute("re", emptyList);
            return "index";
        }
     }
     
    
     @PostMapping("/create/All/Save")
         public String save(
            @Valid @ModelAttribute("customerEntity") CustomerEntity customerEntity, // ① @Valid でチェック実行
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model
         ){

            if (bindingResult.hasErrors()) {
                System.out.println("⚠️ 入力チェックエラーが発生しました（件数: " + bindingResult.getErrorCount() + "）");
            
                // 💡 ポイント: "redirect:" を使わず、直接 "create" (HTML) を返す！
                // これにより入力途中の値とエラー情報が保持されたまま登録画面が再表示される
                 model.addAttribute("errorSave", "不正な入力が検知されました");
                return "create";
        }


            try{
                customerService.saveCustomer(customerEntity);   
                redirectAttributes.addFlashAttribute("successSave", "保存に成功しました");
                return "redirect:/customers/table";
            }catch(Exception e){
                System.err.println("============ ❌ 保存失敗のエラー内容 ============");
                e.printStackTrace(); 
                System.err.println("==================================================");
                model.addAttribute("errorSave", "保存に失敗しました");
                return "create";
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

