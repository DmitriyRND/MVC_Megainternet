package org.example.mvc_megainternet.controller;

import lombok.RequiredArgsConstructor;


import org.example.mvc_megainternet.model.TariffInfo;
import org.example.mvc_megainternet.service.TariffInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TariffInfoController {

    private final TariffInfoService tariffInfoService;



    @GetMapping("/tariff_info")
    public String getViewRequest(Model model) {
        List<TariffInfo> tariffInfos = tariffInfoService.getAllTariffs();
        tariffInfos = tariffInfos.stream()
                .peek(e-> System.out.println(e))
                .sorted(Comparator.comparing(TariffInfo::getPrice))
                .toList();


        model.addAttribute("tariffInfos", tariffInfos);
        return "tariff_info";
    }
}
