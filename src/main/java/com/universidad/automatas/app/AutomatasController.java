package com.universidad.automatas.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutomatasController {

  @PostMapping
  public boolean isExpresionValid(@RequestBody RegularExpresion regularExpresion ) {
    boolean result = false;

    return regularExpresion.getText().matches("[A-Z]{1}[a-z]");
  }
}
