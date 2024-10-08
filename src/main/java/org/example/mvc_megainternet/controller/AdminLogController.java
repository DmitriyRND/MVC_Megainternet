package org.example.mvc_megainternet.controller;

import lombok.RequiredArgsConstructor;

import org.example.mvc_megainternet.service.AdminLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminLogController {
    private final AdminLogService adminLogService;

    @GetMapping("/admin_log")
    public String showLoginPage() {
        return "admin_log";

    }
    @PostMapping("/admin_log")
    //http://localhost:8090/admin_log?login=Alisa&password=123
    //http://localhost:8090/admin_log?username=Alisa&password=123
    public String adminPanel(@RequestParam String username,
                             @RequestParam String password,
                            Model model) {
        if (adminLogService.isValidAdmin(username, password)) {
            return "/admin_panel";
        } else {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
            return "/admin_log";
        }

    }
}

