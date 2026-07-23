package com.crm.admin_app;

//import java.util.List;

//import java.util.List;
//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;      // 👈 追加
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;


public interface CostomerRepository extends JpaRepository<CustomerEntity, Long> {
    // 💡 名前（あいまい） AND アクティブ状態（完全一致）で検索
    Page<CustomerEntity> findByCustomerNameContainingAndActive(String customerName, Boolean active, Pageable pageable);

    Page<CustomerEntity> findByCustomerNameContaining(String customerName, Pageable pageable);
}

    



    

