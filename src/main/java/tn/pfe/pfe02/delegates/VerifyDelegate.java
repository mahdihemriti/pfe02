package tn.pfe.pfe02.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.repositories.IUserRepository;
import tn.pfe.pfe02.services.ILeaveRequestService;
import tn.pfe.pfe02.services.IUserService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class VerifyDelegate implements JavaDelegate {

    @Autowired
    private ILeaveRequestService leaveRequestService;
    @Autowired
    private IUserService userService;
    private final Logger LOGGER = Logger.getLogger(VerifyDelegate.class.getName());
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOGGER.info("\n\n ... LoggerDelegate invoked by "
                + "activtyName='" + execution.getCurrentActivityName() + "'"
                + ", activtyId=" + execution.getCurrentActivityId()
                + ", processDefinitionId=" + execution.getProcessDefinitionId()
                + ", processInstanceId=" + execution.getProcessInstanceId()
                + ",businessKey=" + execution.getProcessBusinessKey()
                + ",executionId=" + execution.getId()
                + ",variables=" + execution.getVariables()
                + " \n\n");
        LeaveRequestDTO leaveRequest = (LeaveRequestDTO) execution.getVariable("leaveRequest");

        /*LeaveRequest leaveRequest = (LeaveRequest) execution.getVariable("leaveRequest");
        Integer userId = (Integer) execution.getVariable("userId");
        String department=(String) execution.getVariable("department");
        LocalDate startDate = leaveRequest.getStartDate();
        LocalDate endDate = leaveRequest.getEndDate();*/

        boolean isAvailable =leaveRequestService.isDepartmentAvailableForLeave(leaveRequest.getUserDepartment(), leaveRequest.getStartDate(),leaveRequest.getEndDate());
        boolean isEligible = leaveRequestService.isLeaveRequestEligible(leaveRequest.getUserRemainingLeaveDays(), leaveRequest.getStartDate(), leaveRequest.getEndDate());
        LOGGER.info("Department availability: " + isAvailable);
        LOGGER.info("User eligibility for leave: " + isEligible);

    }

}
