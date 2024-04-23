package com.jiat.ejb.impl;

import com.jiat.ejb.remote.Login;
import jakarta.ejb.Stateless;

@Stateless
public class LoginImpl  implements Login {
    @Override
    public boolean login(String email, String password) {
        if(email.equals("abc@gmail.com") && password.equals("1234")){
            return true;
        }
        return false;
    }
}
