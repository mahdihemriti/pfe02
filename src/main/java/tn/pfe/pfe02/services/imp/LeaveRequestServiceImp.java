package tn.pfe.pfe02.services.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.IGenericServiceImp;
import tn.pfe.pfe02.mapper.ILeaveRequestMapper;
import tn.pfe.pfe02.repositories.ILeaveRequestRepository;
import tn.pfe.pfe02.repositories.IUserRepository;
import tn.pfe.pfe02.services.ILeaveRequestService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LeaveRequestServiceImp extends IGenericServiceImp<LeaveRequest,Integer> implements ILeaveRequestService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ILeaveRequestMapper leaveRequestMapper;
    @Override
    public void submitLeaveRequest(LeaveRequest leaveRequest) {

        LeaveRequestDTO LeaveRequestDTO= leaveRequestMapper.toDTO(leaveRequest);

        Map<String, Object> variables = new HashMap<>();

        variables.put("leaveRequest", LeaveRequestDTO);
        variables.put("approved",false);
        variables.put("manager",LeaveRequestDTO.getManagerEmail());

        runtimeService.startProcessInstanceByKey("Process_1qc113l", variables);
    }

    @Override
    public boolean isDepartmentAvailableForLeave(String department, LocalDate startDate, LocalDate endDate) {
        List<User> employeesOnLeave = userRepository.findEmployeesOnLeaveByDepartmentAndDates(department, startDate, endDate);
        return employeesOnLeave.isEmpty();
    }

    @Override
    public boolean isLeaveRequestEligible(double remainingLeaveDays, LocalDate startDate, LocalDate endDate) {
        double requestedLeaveDays = ChronoUnit.DAYS.between(startDate, endDate) + 1; // +1 to include both start and end date
        return (remainingLeaveDays-requestedLeaveDays ) >= -10;
    }

    @Override
    public void updateLeaveRequestStatus(Integer leaveRequestId,String status,Integer userId) {
        LeaveRequest leaveRequest=this.retrieveById(leaveRequestId);
        leaveRequest.setStatus(status);
        if (status.equals("approved"))
        {
            double requestedLeaveDays = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;
            Optional<User> user=userRepository.findById(userId);
            user.get().setRemainingLeaveDays(user.get().getRemainingLeaveDays()-requestedLeaveDays);
            userRepository.save(user.get());
        }

        this.update(leaveRequest);

    }
}
