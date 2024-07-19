package tn.pfe.pfe02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.LeaveRequest;
import tn.pfe.pfe02.entities.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILeaveRequestRepository extends JpaRepository<LeaveRequest,Integer> {
}
