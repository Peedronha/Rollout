package org.example.controller;

import org.example.model.Store;
import org.example.service.StoreService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StoreController {

    private final StoreService storeService;

    public StoreController() {
        this.storeService = new StoreService();
    }

    public boolean addStore(Store store) {
        if(validateFields(store).isEmpty()){
            return false;
        }
        storeService.saveStore(store);
        return true;
    }

    private Map<String, String> validateFields(Store store) {
        return storeService.validateGeneral(store.getEstado(), store.getCidade(), store.getDDD(), store.getCnl());
    }
}
