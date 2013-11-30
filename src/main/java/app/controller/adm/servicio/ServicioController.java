package app.controller.adm.servicio;

import app.model.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("adm/servicio")
public class ServicioController {

    @Autowired
    ServicioService service;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("servicios", service.list());

        return "adm/servicio/servicio";
    }

    @RequestMapping("new")
    public String nuevo(Model model) {

        model.addAttribute("servicio", new Servicio());

        return "adm/servicio/servicioForm";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable long id, Model model) {

        Servicio servicio = service.get(new Servicio(id));

        if (servicio == null) {
            return "redirect:/adm/servicio";
        }

        model.addAttribute("servicio", servicio);

        return "adm/servicio/servicioForm";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Servicio servicio) {

        if (servicio.getId() == null) {
            service.save(servicio);
        } else {
            service.update(servicio);
        }

        return "redirect:/adm/servicio";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {

        service.delete(new Servicio(id));
        
        return "redirect:/adm/servicio";
    }
}
