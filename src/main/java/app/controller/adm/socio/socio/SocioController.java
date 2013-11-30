/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app.controller.adm.socio.socio;

import app.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("adm/socio")
public class SocioController {
    @Autowired
    SocioService service;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("socios", service.list());
        return "adm/socio/socio";
    }
    @RequestMapping("new")
    public String nuevo(Model model) {
        model.addAttribute("socio", new Persona());
        return "adm/socio/socioForm";
    }
    @RequestMapping("update/{id}")
    public String update(@PathVariable long id, Model model) {
        Persona persona = service.get(new Persona(id));
        if (persona == null) {
            return "redirect:/adm/socio";
        }
        model.addAttribute("socio", persona);
        return "adm/socio/socioForm";
    }
    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute Persona persona) {
        if (persona.getId() == null) {
            service.save(persona);
        } else {
            service.update(persona);
        }
        return "redirect:/adm/socio";
    }
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        service.delete(new Persona(id));
        return "redirect:/adm/socio";
    }
}