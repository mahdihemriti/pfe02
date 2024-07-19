package tn.pfe.pfe02.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequestDTO implements Serializable {
    private Integer leaveRequestId;
    private Integer userId;
    private String type;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private String userEmail;
    private String userDepartment;
    private Double userRemainingLeaveDays;
    private String managerEmail;

}
