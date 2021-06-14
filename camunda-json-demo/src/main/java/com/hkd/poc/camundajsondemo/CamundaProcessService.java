/**
 * 
 */
package com.hkd.poc.camundajsondemo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author hammad.karamat
 *
 */
@Component
public class CamundaProcessService implements JavaDelegate {

  public void validate(DelegateExecution execution) {

    MyDto dto = (MyDto) execution.getVariable("input");
    System.out.println("DTO retrieved with values " + dto.toString());
  }

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    MyDto dto = (MyDto) execution.getVariable("input");
    System.out.println("DTO retrieved with values " + dto.toString());

  }
}
