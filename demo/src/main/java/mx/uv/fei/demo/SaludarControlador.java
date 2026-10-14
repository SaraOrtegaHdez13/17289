package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/saludador/{nombre}")
    public Saludador met3(@PathVariable String nombre){
        return new Saludador(nombre);

    }

    @RequestMapping ("/saludador2/{nombreX}")
    public Saludador met4(@PathVariable("nombreX") String nombre){
        System.out.println("get:" + nombre);
        saludador = new Saludador(nombre);
        return saludador;

    }

    @RequestMapping("/") 
    public String indice(){
        return """
                <h1>menú principal</h1>
                <ul>
                    <li><a href='/saludos'>/saludos</a></li>
                    <li><a href='/despedidas'>/despedidas</a></li>
                    <li>/nombramientos(POST * PUT * DELETE)</li>
                    <li><a href='/saludador/default'>/saludador/{nombre}</a></li>
                    <li><a href='/saludador2/default2'>/saludador/{nombreX}</a></li>

                    <li>/crearSaludador</li>
                    <li><a href='/obtenerSaludador'>/obtenerSaludador/{nombreX}</a></li>
                    
                </ul>
                
                """;


    }

    Saludador saludador;

    @PostMapping("/crearSaludador")
    public void crearSaludador(@RequestBody Saludador nombre){
        System.out.println("post:" + nombre);
        saludador = nombre;
    }

    @GetMapping("/obtenerSaludador")
    public Saludador obtenerSaludador(){
        return saludador;
    }

    @GetMapping("/getQuery")
    public String GetQueryString(@RequestParam String nombre, @RequestParam String paterno){
        return nombre + " " + paterno;

    }

    @GetMapping("/getQuery2")
    public String GetQueryString2(@RequestParam String nombre, @RequestParam(defaultValue= "") String paterno){
        return nombre + " " + paterno;

    }

}
