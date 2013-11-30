/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controller.adm.socio.socio;

import app.dao.PersonaDAO;
import app.dao.SocioDAO;
import app.model.Persona;
import app.model.Socio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SocioServiceImp implements SocioService {
    @Autowired
    PersonaDAO personaDAO;
    @Autowired
    SocioDAO socioDAO;
    @Override
    public List<Persona> list() {
        return personaDAO.listSocio();
    }
    @Override
    public Persona get(Persona t) {
        return personaDAO.get(t);
    }
    @Override
    public void save(Persona t) {
        personaDAO.save(t);
        Socio socio=new Socio();
        socio.setPersona(t);
        
        socioDAO.save(socio);
        
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