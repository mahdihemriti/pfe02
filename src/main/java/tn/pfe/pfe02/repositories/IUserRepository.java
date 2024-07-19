package tn.pfe.pfe02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
    User findByFirstNameAndLastName(String firstName,String lastName);
    @Query("SELECT u FROM User u JOIN u.leaveRequests r WHERE u.department.name = :department " +
            "AND (r.startDate <= :endDate AND r.endDate >= :startDate )")
    List<User> findEmployeesOnLeaveByDepartmentAndDates(@Param("department") String department,
                                                        @Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate);
}
