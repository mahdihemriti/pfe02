package tn.pfe.pfe02.services;

import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.IGenericService;

import java.time.LocalDate;
import java.util.List;

public interface ILeaveRequestService extends IGenericService<LeaveRequest,Integer> {
    void submitLeaveRequest(LeaveRequest leaveRequest);
    boolean isDepartmentAvailableForLeave(String department, LocalDate startDate, LocalDate endDate);
    boolean isLeaveRequestEligible(double remainingLeaveDays, LocalDate startDate, LocalDate endDate);
    void updateLeaveRequestStatus(Integer leaveRequestId,String status,Integer userId);
}
