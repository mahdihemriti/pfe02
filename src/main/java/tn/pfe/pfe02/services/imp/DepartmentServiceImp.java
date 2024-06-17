package tn.pfe.pfe02.services.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.generic.IGenericServiceImp;
import tn.pfe.pfe02.services.IDepartmentService;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DepartmentServiceImp extends IGenericServiceImp<Department,Integer>implements IDepartmentService {
}
