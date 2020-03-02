package com.threading.Test.Controller;


import com.threading.Test.Domains.Number;
import com.threading.Test.Service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebController {
    @Autowired
    private WebService webService;

    @GetMapping("/status/{status}")
    public List<Number> getData(@PathVariable(value = "status") int status){
        return webService.getData(status);
    }
}
