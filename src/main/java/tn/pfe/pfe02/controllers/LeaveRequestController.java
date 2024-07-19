package tn.pfe.pfe02.controllers;

import lombok.AllArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.GenericController;
import tn.pfe.pfe02.services.ILeaveRequestService;
import tn.pfe.pfe02.services.IUserService;
import tn.pfe.pfe02.services.imp.EmailServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/leaveRequest")
public class LeaveRequestController extends GenericController<LeaveRequest,Integer> {
    @Autowired
    private ILeaveRequestService leaveRequestService;

    @Autowired
    private IUserService userService;
    @Autowired
    private EmailServiceImp emailService;

    @PostMapping("/request")
    public void submitLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        User user=userService.getAuthenticatedUser();
        leaveRequest.setUser(user);
        leaveRequestService.add(leaveRequest);
        leaveRequestService.submitLeaveRequest(leaveRequest);
    }

}
