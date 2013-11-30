package app.controller.adm.campo;
import app.model.Campo;
import app.model.Local;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("adm/campo")
public class CampoController {
    @Autowired
    CampoService service;
    @Autowired
    CampoServiceImp serviceImp;    
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("campos", service.list());
        return "adm/campo/campo";
    }
    @RequestMapping("new")
    public String nuevo(Model model) {
        model.addAttribute("campo", new Campo());
        List<Local> locales = serviceImp.listLocal();
        model.addAttribute("locales", locales);
        
        
        return "adm/campo/campoForm";
    }
    @RequestMapping("update/{id}")
    public String update(@PathVariable long id, Model model) {
        Campo servicio = service.get(new Campo(id));
        if (servicio == null) {
            return "redirec:adm/campoForm";
        }
       
        List<Local> locales = serviceImp.listLocal();
        model.addAttribute("locales", locales);
        
        model.addAttribute("campo", servicio);
        return "adm/campo/campoForm";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Campo campo) {
        if (campo.getId() == null) {
            service.save(campo);
        } else {
            service.update(campo);
        }
        return "redirect:/adm/campo";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(new Campo(id));
        return "redirect:/adm/campo";
    }
}