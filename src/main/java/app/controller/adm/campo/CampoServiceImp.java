package app.controller.adm.campo;
import app.dao.CampoDAO;
import app.model.Campo;
import app.model.Local;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CampoServiceImp implements CampoService {
    @Autowired //pedimos a spring el bin servicio dao
    CampoDAO campoDAO;
    
    @Override
    public List<Campo> list() {
        return campoDAO.list();
    }
    @Override
    public Campo get(Campo t) {
        return campoDAO.get(t);
    }
    @Override
    public void save(Campo t) {
        campoDAO.save(t);
    }
    @Override
    public void update(Campo t) {
        campoDAO.update(t);
    }
    @Override
    public void delete(Campo t) {
        campoDAO.delete(t);
    }
    public List<Local> listLocal() {
        return campoDAO.allLocal();
    }
}