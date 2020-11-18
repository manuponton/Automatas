package com.universidad.automatas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class GramaticalController {

  private static final boolean ORACION_INVALIDA = false;
  private static List<String> articulos = new ArrayList<>(Arrays.asList("The"));
  private static List<String> sustantivosComunes = new ArrayList<>(Arrays.asList("car"));
  private static List<String> sustantivoPropios = new ArrayList<>(Arrays.asList("Mary"));
  private static List<String> pronombrePersonal = new ArrayList<>(
      Arrays.asList("I", "You", "He", "She", "It", "We", "They"));
  private static List<String> verboToBe = new ArrayList<>(Arrays.asList("is", "are", "am"));
  private static ArrayList<String> complementos = new ArrayList<>(
      Arrays.asList("red", "hungry", "cool"));

  @PostMapping("/a")
  public boolean isGramaticalValid(@RequestBody RegularExpresion regularExpresion) {

    String texto = regularExpresion.getText().trim();
    String[] divisionDeCadena = texto.split(" ");
    if (laFraseTieneLasPalabrasNecesarias(divisionDeCadena)) {
      return false;
    }
    if (validarFraseConArticulo(divisionDeCadena)) {
      return true;
    }
    if (validarFraseConPronombrePersonalYou(divisionDeCadena)) {
      return true;
    }

    return false;
  }

  private boolean validarFraseConPronombrePersonalYou(String[] divisionDeCadena) {
      Integer YOU = 1;
      if(divisionDeCadena[0].equals(pronombrePersonal.get(YOU))){


      }
    return ORACION_INVALIDA;
  }

  private boolean laFraseTieneLasPalabrasNecesarias(String[] divisionDeCadena) {
    if (divisionDeCadena.length < 3) {
      return true;
    }
    return false;
  }

  private boolean validarFraseConArticulo(String[] divisionDeCadena) {
    Boolean oracionValida = false;
    Boolean esUnaOracionConArticulo = false;
    if (articulos.contains(divisionDeCadena[0])) {
      esUnaOracionConArticulo = true;
      if (sustantivosComunes.contains(divisionDeCadena[1]) && esUnaOracionConArticulo) {
        if (verboToBe.get(0).equals(divisionDeCadena[2])) {
          for (int i = 3; i < divisionDeCadena.length; i++) {
            if (complementos.contains(divisionDeCadena[i]) == false) {
              return false;
            }
          }
          oracionValida = true;
          return oracionValida;
        } else {
          return ORACION_INVALIDA;
        }
      } else {
        return ORACION_INVALIDA;
      }
    }
    return false;
  }

  @PostMapping("/newText")
  public void agregarALista(@RequestBody NewText newText) {
    String texto = newText.getText();
    switch (newText.getCategoria()) {
      case "ARTICULOS":
        articulos.add(texto);
        break;
      case "SUSTANTIVOS_COMUNES":
        sustantivosComunes.add(texto);
        break;
      case "SUSTANTIVOS_PROPIOS":
        sustantivoPropios.add(texto);
        break;
      case "PRONOMBRE_PERSONAL":
        pronombrePersonal.add(texto);
        break;
      case "VERBO_TO_BE":
        verboToBe.add(texto);
        break;
      case "COMPLEMENTOS":
        complementos.add(texto);
        break;
    }
  }

  @GetMapping("/listas")
  public List<ArrayList> getComplementos() {
    List listas = new ArrayList<>();
    listas.add(complementos);
    listas.add(articulos);
    listas.add(sustantivosComunes);
    listas.add(pronombrePersonal);
    listas.add(verboToBe);
    return listas;
  }
}