package tn.pfe.pfe02.mapper;

import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.CandidateDTO;
import tn.pfe.pfe02.dto.EmployeeDTO;
import tn.pfe.pfe02.entities.User;
@Component
public class UserMapperImp implements IUserMapper{
    @Override
    public CandidateDTO convertToCandidateDTO(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        return CandidateDTO.builder()
                .candidateId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .jobOffers(user.getJobOffers())
                .resume(user.getResume())
                .build();
    }

    @Override
    public EmployeeDTO convertToEmployeeDTO(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return EmployeeDTO.builder()
                .employeeId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .gender(user.getGender())
                .phoneNumber(user.getPhoneNumber())
                .dateOfBirth(user.getDateOfBirth())
                .hireDate(user.getHireDate())
                .jobTitle(user.getJobTitle())
                .remainingLeaveDays(user.getRemainingLeaveDays())
                .department(user.getDepartment())
                .leaveRequests(user.getLeaveRequests())
                .build();

    }

}
