package tn.pfe.pfe02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pfe.pfe02.services.imp.CamundaProcessService;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private CamundaProcessService camundaProcessService;

    @GetMapping("/start")
    public String startProcess() {
        camundaProcessService.startProcess();
        return "Process started";
    }
}
