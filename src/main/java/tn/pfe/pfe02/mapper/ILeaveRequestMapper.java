package tn.pfe.pfe02.mapper;

import tn.pfe.pfe02.dto.LeaveRequestDTO;
import tn.pfe.pfe02.entities.LeaveRequest;

public interface ILeaveRequestMapper {
    public LeaveRequestDTO toDTO(LeaveRequest leaveRequest);
}
