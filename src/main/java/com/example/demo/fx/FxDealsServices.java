package com.example.demo.fx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FxDealsServices {
    @Autowired
    private final FxDealsRepo repo;

    public FxDealsServices(FxDealsRepo repo) {
        this.repo = repo;
    }

    public List<FxDeals> getAll(){
        return repo.findAll();
    }

    public Boolean isDealExist(Integer dealId){
        return Optional.of(repo.findById(dealId).isPresent()).orElse(false);
    }

    public void addDeal(FxDeals fxDeals){
        System.out.println(fxDeals.toString());
        if(isDealExist(fxDeals.getDealId())){
            log.error("Deal with Id ={} has been already created ",fxDeals.getDealId());
            throw new RuntimeException("Deal Already Exists");
        }
        repo.save(fxDeals);
        log.info("Deal has been added successfully");
    }
}
