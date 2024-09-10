package org.example.mvc_megainternet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tariffinfo")
@NoArgsConstructor
public class TariffInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tariffName;
    private String connectionType;
    private int price;
    private int speed;
    private int dataLimit;
    private String stock;


}
