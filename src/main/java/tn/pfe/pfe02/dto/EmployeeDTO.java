package tn.pfe.pfe02.dto;

import lombok.*;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.Gender;
import tn.pfe.pfe02.entities.LeaveRequest;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Long phoneNumber;
    private LocalDate dateOfBirth;
    private String email;
    private LocalDate hireDate;
    private String jobTitle;
    private Double remainingLeaveDays;
    private Department department;
    private List<LeaveRequest> leaveRequests;
}
