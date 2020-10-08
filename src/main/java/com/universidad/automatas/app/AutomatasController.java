package com.universidad.automatas.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("*")
@RestController
public class AutomatasController {

  @PostMapping
  public boolean isExpresionValid(@RequestBody RegularExpresion regularExpresion) {
    boolean result = false;
    // Positive or negative 1th person
    if (regularExpresion.getText().matches("I\\sam\\s(not\\s)?[a-zA-Z]+")) {
      return true;
    }
    if (regularExpresion.getText().matches("(She|He|It)\\sis\\s(not\\s)?[a-zA-Z ]+")) {
      return true;
    }
    if (regularExpresion.getText().matches("(You|We|They)\\sare\\s(not\\s)?[a-zA-Z ]+")) {
      return true;
    }
    if (regularExpresion.getText().matches("Is\\s(she|he|it)\\s([a-zA-Z]+(\\s))+\\?")) {
      return true;
    }
    if (regularExpresion.getText().matches("Are\\s(you|we|they)\\s([a-zA-Z]+(\\s))+\\?")) {
      return true;
    }
    if (regularExpresion.getText().matches("Am\\s(I)\\s([a-zA-Z]+(\\s))+\\?")) {
      return true;
    }
    return result;
  }
}