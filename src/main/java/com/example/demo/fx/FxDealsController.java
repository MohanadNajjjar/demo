package com.example.demo.fx;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/fx")
public class FxDealsController {
    private final FxDealsServices services;

    public FxDealsController(FxDealsServices services) {
        this.services = services;
    }

    @GetMapping
    public List<FxDeals> getDeals(){
        System.out.println("Test");
        return services.getAll();
    }

    @PostMapping
    public void addDeal(@Valid @RequestBody FxDeals deal){
        services.addDeal(deal);
    }

}
