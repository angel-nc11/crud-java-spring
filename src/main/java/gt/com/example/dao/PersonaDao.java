package gt.com.example.dao;

import gt.com.example.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
  
}
