package app.controller.adm.persona;
import app.dao.PersonaDAO;
import app.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PersonaServiceImp implements PersonaService{
    @Autowired
    PersonaDAO personaDAO;
    public List<Persona> list() {
        return personaDAO.list();
    }
    @Override
    public Persona get(Persona t) {
        return personaDAO.get(t);
    }
    @Override
    public void save(Persona t) {
        personaDAO.save(t);
    }
    @Override
    public void update(Persona t) {
        personaDAO.update(t);
    }
    @Override
    public void delete(Persona t) {
       personaDAO.delete(t);
    }
    
}