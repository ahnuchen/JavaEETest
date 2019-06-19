package org.ccy;

import org.springframework.stereotype.Service;

@Service
public class MethodService {
    public void add() {
        System.out.println("method-add()");
    }
}
