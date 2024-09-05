package org.example.mvc_applicationforconnection.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$",
    message = "использование цифр запрещено!!!")
    private String fullName;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,9}$",
            message = "введите номер в формате +79211001001 или 89271001001")
    private String phone;

    @NotEmpty
    private String city;

    private String street;

    private String houseNumber;

    @Enumerated(EnumType.STRING)
    private Tariff tariff;

///4444
    private LocalDateTime localDateTime;

    public Statement(String fullName, String phone, String city, String street, String houseNumber, Tariff tariff) {
        this.fullName = fullName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.tariff = tariff;
        this.localDateTime = LocalDateTime.now();
    }
}

enum Tariff{
    BASE,
    MEDIUM,
    ULTRA
}
