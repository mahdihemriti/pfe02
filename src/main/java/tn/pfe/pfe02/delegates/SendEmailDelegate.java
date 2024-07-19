package tn.pfe.pfe02.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.services.IEmailService;

@Component
public class SendEmailDelegate implements JavaDelegate {
    @Autowired
    private IEmailService iEmailService;
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LeaveRequestDTO leaveRequest = (LeaveRequestDTO) execution.getVariable("leaveRequest");
        boolean hasRemainingLeaveDays= (boolean) execution.getVariable("hasRemainingLeaveDays");
        boolean departmentAvailability=(boolean) execution.getVariable("departmentAvailability");
        boolean approved=(boolean) execution.getVariable("approved");

        String subject;
        String text;
        String to = leaveRequest.getUserEmail();
        if (!hasRemainingLeaveDays) {
            subject = "Leave Not Approved";
            text = "Your leave request has been denied. Reason: No remaining leave days.";
        } else if (!departmentAvailability) {
            subject = "Leave Not Approved";
            text = "Your leave request has been denied. Reason: Department not available.";
        } else if (!approved) {
            subject = "Leave Not Approved";
            text = "Your leave request has been denied. Reason: Manager did not approve the leave request.";

        } else {
            subject = "Leave Approved";
            text = "Your leave request has been approved.";
        }

        iEmailService.sendSimpleMessage(to, subject, text);

    }


}
