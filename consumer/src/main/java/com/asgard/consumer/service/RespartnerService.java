package com.asgard.consumer.service;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asgard.consumer.Repository.ResRepo;
import com.asgard.consumer.models.ResPartner;

@Service
public class RespartnerService {

    private final ResRepo resRepo;
    

    public RespartnerService(ResRepo resRepo) {
        this.resRepo = resRepo;
    }


    public ResPartner insert(ResPartner resPartner) {
        return resRepo.save(resPartner);
    }

    public List<ResPartner> findAllEmployee() {
        return resRepo.findAll();
    }
}
