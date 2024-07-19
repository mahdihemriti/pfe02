package tn.pfe.pfe02.mapper.imp;

import org.springframework.stereotype.Component;
import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.mapper.ILeaveRequestMapper;
@Component
public class LeaveRequestMapperImp implements ILeaveRequestMapper {
    @Override
    public LeaveRequestDTO toDTO(LeaveRequest leaveRequest) {
        LeaveRequestDTO dto = new LeaveRequestDTO();
        dto.setLeaveRequestId(leaveRequest.getLeaveRequestId());
        dto.setUserId(leaveRequest.getUser().getUserId());
        dto.setType(leaveRequest.getType());
        dto.setDescription(leaveRequest.getDescription());
        dto.setStartDate(leaveRequest.getStartDate());
        dto.setEndDate(leaveRequest.getEndDate());
        dto.setStatus(leaveRequest.getStatus());
        dto.setUserEmail(leaveRequest.getUser().getEmail());
        dto.setUserDepartment(leaveRequest.getUser().getDepartment().getName());
        dto.setUserRemainingLeaveDays(leaveRequest.getUser().getRemainingLeaveDays());
        dto.setManagerEmail(leaveRequest.getUser().getManager().getEmail());

        return dto;
    }
}
