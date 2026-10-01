package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController // Punto de entrada para el mapeo de los verbos
public class SaludarControlador {
    String nombre;

	@GetMapping("/saludos")
	public String saludar () {
		return "hola mundo " + nombre;
	}

    @GetMapping("/despedidas")
    public String despedirse(){
        return "adios mundo!";
    }

    @PostMapping("/nombramientos")
    public void nombre(){
        nombre="boladearroz";
    }

    // PUT (actualizar)
    @PutMapping("/nombramientos")
    public void met1(){
        nombre="actualizar";


    }

    // DELETE 
    @DeleteMapping("/nombramientos")
    public void met2(){
        nombre=null;
        
    }

}
