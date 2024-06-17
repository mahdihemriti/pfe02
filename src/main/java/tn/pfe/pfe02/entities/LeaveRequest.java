package tn.pfe.pfe02.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer leaveRequestId;
    private String type;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    @ManyToOne
    private User user;
}
