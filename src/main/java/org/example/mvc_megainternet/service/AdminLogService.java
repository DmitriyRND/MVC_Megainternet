package org.example.mvc_megainternet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminLogService {

    public  boolean isValidAdmin(String login,String password){
        return "admin".equals(login) && "admin123".equals(password);
    }
}
