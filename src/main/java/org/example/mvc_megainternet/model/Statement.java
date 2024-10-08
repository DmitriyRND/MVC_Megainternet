package org.example.mvc_megainternet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    private Status status;

////
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "statement",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Statement(String fullName, String phone, String city, String street, String houseNumber, Tariff tariff, Status status) {
        this.fullName = fullName;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.tariff = tariff;
        this.localDateTime = LocalDateTime.now();
        this.status = status;
    }

    public Status setDefaultStatus() {
        return Status.PENDING;
    }

public void addComment(Comment comment) {
        comments.add(comment);
}

public void removeComment(Comment comment) {
        comments.remove(comment);
}


    public void assignRequest(String nameStatus){
        switch(nameStatus){
            case "PENDING":
                this.status = Status.PENDING;
                break;
            case "PROGRESS":
                this.status = Status.PROGRESS;
                break;
            case "DECLINED":
                this.status = Status.DECLINED;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный статус заявки");
        }
    }

}

enum Tariff{
    BASE,
    MEDIUM,
    ULTRA
}
 enum  Status {
    PENDING,
    PROGRESS,
    DECLINED;

}
