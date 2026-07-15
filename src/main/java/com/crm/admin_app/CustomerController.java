package com.crm.admin_app;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.Controller;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
@GetMapping("/test")//これはテスト用のエンドポイントです。実際のアプリケーションには不要です。
    public void test(){

    }


}


@Service
class CustomerService{
    private final CostomerRepository costomerRepository;

    public CustomerService(CostomerRepository costomerRepository){
        this.costomerRepository = costomerRepository;
    }

}

