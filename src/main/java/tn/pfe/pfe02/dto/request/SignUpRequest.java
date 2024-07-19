package tn.pfe.pfe02.dto.request;

import lombok.*;
import tn.pfe.pfe02.entities.Gender;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private Long phoneNumber;
    private LocalDate dateOfBirth;
    private String resume;
    private String email;
    private String password;



}
