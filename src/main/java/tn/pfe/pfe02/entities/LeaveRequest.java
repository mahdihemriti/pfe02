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
@ToString
public class LeaveRequest implements Serializable {
    //private static final long serialVersionUID = 1L;
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
