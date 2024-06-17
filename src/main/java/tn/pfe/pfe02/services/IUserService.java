package tn.pfe.pfe02.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import tn.pfe.pfe02.dto.CandidateDTO;
import tn.pfe.pfe02.dto.EmployeeDTO;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.IGenericService;

public interface IUserService extends IGenericService<User,Integer> {
    UserDetailsService userDetailsService();
    User getAuthenticatedUser();
    //CandidateDTO getCandidateDTOById(Integer id);
    //EmployeeDTO getEmployeeDTOById(Integer id);
}
