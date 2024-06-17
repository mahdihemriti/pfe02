package tn.pfe.pfe02.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pfe.pfe02.entities.Department;
import tn.pfe.pfe02.generic.GenericController;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
public class DepartmentController extends GenericController<Department,Integer> {
}
