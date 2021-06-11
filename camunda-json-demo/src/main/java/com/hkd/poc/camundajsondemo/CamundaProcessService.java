/**
 * 
 */
package com.hkd.poc.camundajsondemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

/**
 * @author hammad.karamat
 *
 */
@Component
public class CamundaProcessService {

  public void validate(DelegateExecution execution) {

    MyDto dto = (MyDto) execution.getVariable("input");
    System.out.println("DTO retrieved with values " + dto.toString());
  }
}
