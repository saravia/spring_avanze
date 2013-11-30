package app.controller.adm.persona;
import app.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("adm/persona")
public class PersonaController {
    @Autowired
    PersonaService service;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("personas", service.list());
        return "adm/persona/persona";
    }
    @RequestMapping("new")
    public String nuevo(Model model) {
        model.addAttribute("persona", new Persona());
        return "adm/persona/personaForm";
    }
    @RequestMapping("update/{id}")
    public String update(@PathVariable long id, Model model) {
        Persona persona = service.get(new Persona(id));
        if (persona == null) {
            return "redirect:/adm/persona";
        }
        model.addAttribute("persona", persona);
        return "adm/persona/personaForm";
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Persona persona) {
        if (persona.getId() == null) {
            service.save(persona);
        } else {
            service.update(persona);
        }
        return "redirect:/adm/persona";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(new Persona(id));
        return "redirect:/adm/persona";
    }
}