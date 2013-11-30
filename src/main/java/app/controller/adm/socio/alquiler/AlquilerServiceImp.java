package app.controller.socio.alquiler;
import app.dao.CampoDAO;
import app.dao.SolicitudAlquilerDAO;
import app.model.Campo;
import app.model.SolicitudAlquiler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AlquilerServiceImp implements AlquilerService {
    @Autowired
    SolicitudAlquilerDAO solicitudAlquilerDAO;
    
   
    @Override
    public List<SolicitudAlquiler> list() {
        return solicitudAlquilerDAO.list();
    }
    @Override
    public SolicitudAlquiler get(SolicitudAlquiler t) {
        return solicitudAlquilerDAO.get(t);
    }
    @Override
    public void save(SolicitudAlquiler t) {
        solicitudAlquilerDAO.save(t);
        
    }
    @Override
    public void update(SolicitudAlquiler t) {
        solicitudAlquilerDAO.update(t);
    }
    @Override
    public void delete(SolicitudAlquiler t) {
        solicitudAlquilerDAO.delete(t);
    }
    
    public List<Campo> listCampo() {
        return solicitudAlquilerDAO.allCampo();
    }
    
}