package com.example.demo.repository;


import com.example.demo.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {

}
