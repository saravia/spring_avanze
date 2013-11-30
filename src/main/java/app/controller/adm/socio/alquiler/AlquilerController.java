package app.controller.socio.alquiler;
import app.model.Campo;
import app.model.Local;
import app.model.Persona;
import app.model.Socio;
import app.model.SolicitudAlquiler;
import app.zelper.Constantes;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("socio/alquiler")
public class AlquilerController {
    @Autowired
    AlquilerService service;
    
    @Autowired
    AlquilerServiceImp serviceImp;    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("alquileres", service.list());
        return "socio/alquiler/alquiler";
        
    }
    @RequestMapping("new")
    public String nuevo(Model model) {
        model.addAttribute("alquiler", new SolicitudAlquiler());
        List<Campo> campos = serviceImp.listCampo();
        model.addAttribute("campos", campos);
        return "socio/alquiler/alquilerForm";
    }
    @RequestMapping("update/{id}")
    public String update(@PathVariable long id, Model model) {
        SolicitudAlquiler  solicitudAlquiler = service.get(new SolicitudAlquiler(id));
        if (solicitudAlquiler == null) {
            return "redirect:/socio/alquiler";
            
        }
        model.addAttribute("alquiler", solicitudAlquiler);
        
        List<Campo> campos = serviceImp.listCampo();
        model.addAttribute("campos", campos);
        
        return "socio/alquiler/alquilerForm";
        
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute SolicitudAlquiler solicitudAlquiler,HttpSession session) {
       
        Persona persona = (Persona) session.getAttribute(Constantes.SESSION_USUARIO);
        Socio socio = persona.getSocio();
        
       
        solicitudAlquiler.setSocio(socio);
        
        if (solicitudAlquiler.getId() == null) {
            service.save(solicitudAlquiler);
        } else {
            service.update(solicitudAlquiler);
        }
        return "redirect:/socio/alquiler";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(new SolicitudAlquiler(id));
        return "redirect:/socio/alquiler";
    }
}