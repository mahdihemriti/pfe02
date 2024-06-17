package tn.pfe.pfe02.dto;

import lombok.*;
import tn.pfe.pfe02.entities.Gender;
import tn.pfe.pfe02.entities.JobOffer;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDTO {
    private Integer candidateId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Long phoneNumber;
    private LocalDate dateOfBirth;
    private String email;
    private String resume;
    private List<JobOffer> jobOffers;

}
