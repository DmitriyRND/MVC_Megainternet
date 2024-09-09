package org.example.mvc_megainternet.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.example.mvc_megainternet.model.Statement;
import org.example.mvc_megainternet.service.StatementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Controller
@RequiredArgsConstructor
public class StatementController {
    private final StatementService statementService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/leave-request", method = RequestMethod.GET)
    public String getViewLeaveRequest(Model model) {
        model.addAttribute("statement", new Statement());
        return "leave_request";
    }

    //    @RequestMapping(value = "/leave-request",method = RequestMethod.POST)
    @PostMapping("/leave-request")
    public String leaveRequestPost(@Valid @ModelAttribute Statement statement,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            return "leave_request";
        }

        statement.setLocalDateTime(LocalDateTime.now());
        statementService.saveStatement(statement);

        model.addAttribute("name", statement.getFullName());
        model.addAttribute("phone", statement.getPhone());
        return "accept";
    }

    @GetMapping("/request-on-connection")
    public String getViewRequest(Model model) {
        List<Statement> statements = statementService.getAllStatements();
        model.addAttribute("statements", statements);
        return "request_on_connection";
    }
    //

    @PostMapping("/delete")
    public String deleteStatement(@RequestParam String id) {
        log.info("Delete statement by id " + id);

        statementService.deleteById(id);
        return "redirect:/request-on-connection";
    }

    @GetMapping("/tariff_info")
    public String getTariffInfo() {
        return "tariff_info";
    }

    @PostMapping("/set_status")
    public String updateStatus(@RequestParam("status") String status, @RequestParam("id") long id) {
        Statement statement = statementService.getById(id);
        statement.assignRequest(status);
        statementService.saveStatement(statement);
        return "redirect:/request-on-connection";
    }

    @GetMapping("/info_statement")
    public String getInfoStatement(Model model, @RequestParam ("id") long id) {
       Statement statement = statementService.getById(id);
       model.addAttribute(statement);
        return "info_statement";
    }


}

