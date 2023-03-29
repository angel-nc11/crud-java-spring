package gt.com.example.service;

import gt.com.example.domain.Persona;
import java.util.List;

public interface PersonaService {
    public List<Persona> ListarPersonas();
    
    public void guardar(Persona persona);
    
    public void elimiar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
}
