package com.threading.Test.Service.Implementations;

import com.threading.Test.Domains.Number;
import com.threading.Test.Repository.WebRepository;
import com.threading.Test.Service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebServiceImp implements WebService {
    @Autowired
    private WebRepository webRepository;

    @Override
    public List<Number> getData(int status) {
        return webRepository.findAllByStatus(status);
    }
}
