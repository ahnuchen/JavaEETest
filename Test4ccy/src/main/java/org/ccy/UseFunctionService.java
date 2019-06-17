package org.ccy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//以下几种效果相同
//@Service
@Component
//@Repository
//@Controller
public class UseFunctionService {
    @Autowired
    FunctionService functionService;
    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
