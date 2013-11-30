/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller.test;

import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp implements TestService{

  @Autowired
  ServicioDAO servicioDAO;
  
  public List<Servicio> allServicio(){
      return servicioDAO.list();
  }
        

    
}
