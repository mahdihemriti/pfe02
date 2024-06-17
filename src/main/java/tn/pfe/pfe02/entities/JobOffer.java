package tn.pfe.pfe02.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOffer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer jobOfferId;
    private String title;
    private String description;
    private String requirements;
    private LocalDate publicationDate;
    private LocalDate expirationDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;
}
