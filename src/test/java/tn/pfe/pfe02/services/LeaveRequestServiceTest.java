package tn.pfe.pfe02.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.repositories.IUserRepository;
import tn.pfe.pfe02.services.imp.LeaveRequestServiceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LeaveRequestServiceTest {
  /*  @Mock
    private IUserRepository userRepository;
    @InjectMocks
    private LeaveRequestServiceImp leaveRequestService;
    @Test
    public void testIsDepartmentAvailableForLeave() {
        // Create mock data
        Department itDepartment = new Department();
        itDepartment.setName("IT");
        LocalDate startDate = LocalDate.of(2024, 7, 10);
        LocalDate endDate = LocalDate.of(2024, 7, 15);

        // Mock data for users on leave in the IT department during the specified dates
        List<User> usersOnLeave = new ArrayList<>();
        User user1 = new User();
        user1.setFirstName("mahdi");
        usersOnLeave.add(user1);

        // Mock the repository method call
        when(userRepository.findEmployeesOnLeaveByDepartmentAndDates(itDepartment, startDate, endDate))
                .thenReturn(usersOnLeave);

        // Call the service method
        boolean result = leaveRequestService.isDepartmentAvailableForLeave(itDepartment, startDate, endDate);

    }*/
}
