/**
 * 
 */
package com.hkd.poc.camundajsondemo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hammad.karamat
 *
 */
@RestController
public class CamundaController {

  @Autowired
  private RuntimeService runtimeService;

  @GetMapping(path = "/start")
  public String startProcess() {

    MyDto dto = new MyDto();
    dto.setName("Hammad");
    dto.setValue("Dar");

    Map<String, Object> variables = new HashMap<>();

    variables.put("input",
        Variables.objectValue(dto).serializationDataFormat(SerializationDataFormats.JSON).create());

    UUID processBusinessKey = UUID.randomUUID();

    ProcessInstance instance = runtimeService.startProcessInstanceByKey("Process_Json_Test",
        processBusinessKey.toString(), variables);

    return "OK for " + instance.getId();
  }
}
