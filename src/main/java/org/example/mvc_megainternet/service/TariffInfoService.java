package org.example.mvc_megainternet.service;

import lombok.RequiredArgsConstructor;
import org.example.mvc_megainternet.model.TariffInfo;
import org.example.mvc_megainternet.repository.TariffInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffInfoService {
    private final TariffInfoRepository repository;


    public TariffInfo saveTariff(TariffInfo tariffInfo) {
        return repository.save(tariffInfo);
    }



    public List<TariffInfo> getAllTariffs() {
        List<TariffInfo> all = repository.findAll();
        all = all.stream()
                .sorted(Comparator.comparing(TariffInfo::getPrice)
                        .thenComparing(TariffInfo::getSpeed))
                        .toList();
        System.out.println(all);
        return all;
    }



}
