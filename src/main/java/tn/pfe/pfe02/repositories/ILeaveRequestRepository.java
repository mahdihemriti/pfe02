package tn.pfe.pfe02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;
@Repository
public interface ILeaveRequestRepository extends JpaRepository<LeaveRequest,Integer> {
}
