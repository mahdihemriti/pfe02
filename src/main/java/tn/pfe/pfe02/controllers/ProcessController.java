package tn.pfe.pfe02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pfe.pfe02.services.imp.CamundaProcessServiceImp;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private CamundaProcessServiceImp camundaProcessServiceImp;

    @GetMapping("/start")
    public String startProcess() {
        camundaProcessServiceImp.startProcess();
        return "Process started";
    }
}
