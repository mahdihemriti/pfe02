package tn.pfe.pfe02.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.services.ILeaveRequestService;
import tn.pfe.pfe02.services.IUserService;

@Component
public class UpdateLeaveRequestDelegate implements JavaDelegate {
    @Autowired
    private ILeaveRequestService leaveRequestService;
    @Autowired
    private IUserService userService;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LeaveRequestDTO leaveRequest = (LeaveRequestDTO) execution.getVariable("leaveRequest");
        boolean approved= (boolean) execution.getVariable("approved");
        if(approved){
            leaveRequestService.updateLeaveRequestStatus(leaveRequest.getLeaveRequestId(),"approved", leaveRequest.getUserId());
        }
        else {
            leaveRequestService.updateLeaveRequestStatus(leaveRequest.getLeaveRequestId(),"rejected", leaveRequest.getUserId());
        }


    }
}
