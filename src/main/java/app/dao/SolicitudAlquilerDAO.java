
package app.dao;

import app.model.Campo;
import app.model.SolicitudAlquiler;
import app.zelper.GenericCrud;
import java.util.List;


public interface SolicitudAlquilerDAO extends GenericCrud<SolicitudAlquiler>{

    public List<Campo> allCampo();
    
}
