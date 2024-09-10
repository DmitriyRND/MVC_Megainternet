package org.example.mvc_megainternet.repository;

import org.example.mvc_megainternet.model.TariffInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface TariffInfoRepository extends JpaRepository<TariffInfo,Integer> {
    //List<TariffInfo> findByNameTariff(String name);

}
