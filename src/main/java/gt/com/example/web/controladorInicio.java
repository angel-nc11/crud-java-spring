package gt.com.example.web;

import gt.com.example.domain.Persona;
import gt.com.example.service.PersonaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j

public class controladorInicio {
    
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model)
    {
        var personas = personaService.ListarPersonas();
        
        
        log.info("ejecutando el controlador Spring MVC");
       
        model.addAttribute("personas", personas);
                
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar (@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model){
       persona = personaService.encontrarPersona(persona);
       model.addAttribute("persona", persona);
       return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.elimiar(persona);
        return "redirect:/";
    }
    
    
    
    
    
}
