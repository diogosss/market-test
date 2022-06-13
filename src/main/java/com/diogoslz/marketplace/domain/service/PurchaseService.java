package com.diogoslz.marketplace.domain.service;

import com.diogoslz.marketplace.domain.Purchase;
import com.diogoslz.marketplace.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clienteId){
        return purchaseRepository.getByClient(clienteId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }


}
