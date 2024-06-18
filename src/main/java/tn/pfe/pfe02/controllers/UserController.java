package tn.pfe.pfe02.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.pfe.pfe02.dto.CandidateDTO;
import tn.pfe.pfe02.dto.EmployeeDTO;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.GenericController;
import tn.pfe.pfe02.mapper.IUserMapper;
import tn.pfe.pfe02.services.IUserService;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController extends GenericController<User,Integer> {
    private final IUserService userService;
    private final IUserMapper userMapper;

    @GetMapping("/test")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    }

    @GetMapping("/me")
    public ResponseEntity<?> authenticatedUser() {
        User currentUser = userService.getAuthenticatedUser();
        switch (currentUser.getRole()) {
            case CANDIDATE -> {
                CandidateDTO candidateDTO = userMapper.convertToCandidateDTO(currentUser);
                return ResponseEntity.ok(candidateDTO);
            }
            case EMPLOYEE -> {
                EmployeeDTO employeDTO = userMapper.convertToEmployeeDTO(currentUser);
                return ResponseEntity.ok(employeDTO);
            }
            default -> {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }

    }


}
