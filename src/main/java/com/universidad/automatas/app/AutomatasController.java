package com.universidad.automatas.app;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutomatasController {

  @PostMapping
  public boolean isExpresionValid(@RequestBody RegularExpresion regularExpresion ) {
    boolean result = false;
    if (regularExpresion.getText().matches("I am[ ][a-zA-Z]+")) {
      return true;
    }
    if (regularExpresion.getText().matches(
        "[A-Z]{1}[a-zA-Z]+[ ][a-zA-Z]*[ ](are|is|am){1}[ ][a-zA-Z]+")) {
      return true;
    }
    if (regularExpresion.getText().matches("(She |He |It )is (not )?[a-zA-Z]")) {
      return true;
    }
    if (regularExpresion.getText().matches("(You |We |They )are (not )?[a-zA-Z]")) {
      return true;
    }
    if (regularExpresion.getText().matches("Is (she |he |it )[a-zA-Z]")) {
      return true;
    }
    if (regularExpresion.getText().matches("Are (you |we |they )[a-zA-Z]")) {
      return true;
    }
    if (regularExpresion.getText()
        .matches("[A-Z]{1}[a-zA-Z]+([ ][a-zA-Z]+)?[ ](are|is){1}[ ][a-zA-Z]+")) {
      return true;
    }
    return result;
  }
}
