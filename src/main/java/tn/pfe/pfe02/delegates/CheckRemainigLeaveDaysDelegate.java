package tn.pfe.pfe02.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.services.ILeaveRequestService;

import java.util.logging.Logger;

@Component
public class CheckRemainigLeaveDaysDelegate implements JavaDelegate {
    @Autowired
    private ILeaveRequestService leaveRequestService;

    private final Logger LOGGER = Logger.getLogger(CheckRemainigLeaveDaysDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LeaveRequestDTO leaveRequest = (LeaveRequestDTO) execution.getVariable("leaveRequest");
        boolean hasRemainingLeaveDays = leaveRequestService.isLeaveRequestEligible(leaveRequest.getUserRemainingLeaveDays(), leaveRequest.getStartDate(), leaveRequest.getEndDate());
        LOGGER.info("hasRemainingLeaveDays: " + hasRemainingLeaveDays);
        execution.setVariable("hasRemainingLeaveDays", hasRemainingLeaveDays);

    }
}
