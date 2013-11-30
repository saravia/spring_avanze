package app.controller.adm.administrador;

import app.dao.PersonaDAO;
import app.dao.UsuarioDAO;
import app.dao.UsuarioRolDAO;
import app.model.Persona;
import app.model.Usuario;
import app.model.UsuarioRol;
import app.zelper.EstadoEnum;
import app.zelper.RolesEnum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    PersonaDAO personaDAO;
    
    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    UsuarioRolDAO usuarioRolDAO;

    @Override
    public List<Persona> list() {
        return personaDAO.listAdministrador();
    }

    @Override
    public Persona get(Persona t) {
        return personaDAO.get(t);
    }

    @Override
    public void save(Persona t) {
        personaDAO.save(t);
        
        Usuario user = new Usuario();
        user.setPersona(t);
        user.setUsuario(t.getEmail());
        user.setPassword(DigestUtils.md5DigestAsHex(t.getEmail().getBytes()));
        user.setEstado(EstadoEnum.ACTIVO.getValue());
        usuarioDAO.save(user);

        
        UsuarioRol rol = new UsuarioRol();
        rol.setUsuario(user);
        rol.setAuthority(RolesEnum.ADMIN.getValue());
        usuarioRolDAO.save(rol);
    }

    @Override
    public void update(Persona t) {
        personaDAO.update(t);
        
        Usuario usuario = usuarioDAO.getByPersona(t);
        usuario.setUsuario(t.getEmail());
        usuarioDAO.update(usuario);
    }

    @Override
    public void delete(Persona t) {
        personaDAO.delete(t);
    }
}
