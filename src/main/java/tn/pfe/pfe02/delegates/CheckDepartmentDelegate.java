package tn.pfe.pfe02.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.services.ILeaveRequestService;

import java.util.logging.Logger;

@Component
public class CheckDepartmentDelegate implements JavaDelegate {
    @Autowired
    private ILeaveRequestService leaveRequestService;
    private final Logger LOGGER = Logger.getLogger(CheckRemainigLeaveDaysDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LeaveRequestDTO leaveRequest = (LeaveRequestDTO) execution.getVariable("leaveRequest");
        boolean isAvailable =leaveRequestService.isDepartmentAvailableForLeave(leaveRequest.getUserDepartment(), leaveRequest.getStartDate(),leaveRequest.getEndDate());
        execution.setVariable("departmentAvailability", isAvailable);
        LOGGER.info("departmentAvailability: " + isAvailable);
    }

}
