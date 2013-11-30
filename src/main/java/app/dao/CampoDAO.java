
package app.dao;

import app.model.Campo;
import app.model.Local;
import app.zelper.GenericCrud;
import java.util.List;


public interface CampoDAO extends GenericCrud<Campo>{

    public List<Campo> allByLocal(Local local);
    public Campo getByName(String descripcion);

    public List<Local> allLocal();
}
