package tn.pfe.pfe02.mapper;

import tn.pfe.pfe02.dto.CandidateDTO;
import tn.pfe.pfe02.dto.EmployeeDTO;
import tn.pfe.pfe02.entities.User;

public interface IUserMapper {
    CandidateDTO convertToCandidateDTO(User user);
    EmployeeDTO convertToEmployeeDTO(User user);
}
