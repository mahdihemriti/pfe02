package tn.pfe.pfe02.services.imp;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamundaProcessService {
    @Autowired
    private RuntimeService runtimeService;

    public void startProcess() {
        runtimeService.startProcessInstanceByKey("sample-process");
    }
}
