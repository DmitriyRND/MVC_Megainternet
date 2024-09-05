package org.example.mvc_applicationforconnection.repository;

import org.example.mvc_applicationforconnection.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
    List<Statement> findByCity(String city);


//    //HQL
//    @Query("SELECT s FROM Statement s where s.tariff == :nameTariff")
//    List<Statement> findByTariff(@Param("nameTariff") String nameTariff);

    @Query(
            value = "SELECT phone FROM statement where phone like '+7%' or phone like'8%'",
            nativeQuery = true)
    List<Statement> findAllRusPhones();
}
