package tn.pfe.pfe02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.entities.User;
@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
}
