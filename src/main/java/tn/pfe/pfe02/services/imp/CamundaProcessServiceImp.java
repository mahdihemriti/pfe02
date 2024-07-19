package tn.pfe.pfe02.services.imp;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.services.ICamundaProcessService;

@Service
public class CamundaProcessServiceImp implements ICamundaProcessService {
    @Autowired
    private RuntimeService runtimeService;
    public void startProcess() {
        runtimeService.startProcessInstanceByKey("sample-process");
    }
}
