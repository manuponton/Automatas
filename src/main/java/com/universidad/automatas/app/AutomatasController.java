package com.universidad.automatas.app;

import java.util.Arrays;
import java.util.List;
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


  @PostMapping("/validarGramatica")
  public String isGramaticalValid(@RequestBody RegularExpresion regularExpresion) {
    List<String>sustantivosComunes = Arrays.asList("car", "dog");
    String texto  = regularExpresion.getText();
    String [] divisionDeCadena =  texto.split(" ");
    if (divisionDeCadena[0].equals("The")){ //Es sustantivo comun
      boolean conToBe = false;
      int posicionToBe = 0;
      for (int i = 0; i < divisionDeCadena.length; i++){
        if (divisionDeCadena[i].equals("is") || divisionDeCadena[i].equals("are")) {
          conToBe = true;
          posicionToBe = i + 1;
        }
      }
      if (conToBe) {
        if (posicionToBe > 2 && posicionToBe < divisionDeCadena.length) {
          String verbo = divisionDeCadena[posicionToBe-1];
          String sustantivo = texto.split(verbo)[0].trim();
          for (String sustantivoValue : sustantivosComunes){
            if(sustantivo.equals("The " + sustantivoValue)){
              return "Correcto";
            }
          }
          return "Error";
        } else {
          return "Error, posición del verbo to be invalida";
        }
      } else {
        return  "Error, no contiene el verbo to be";
      }
    }
    return "No valida";
  }
}