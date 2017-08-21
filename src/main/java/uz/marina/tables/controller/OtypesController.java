package uz.marina.tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.marina.tables.model.Otypes;
import uz.marina.tables.service.ElementWithIdService;

import java.util.List;

/**
 * Created by Vladimir on 21.08.2017.
 */
@Controller
public class OtypesController {

    @Autowired
    @Qualifier(value = "elementWithIdService")
    private ElementWithIdService service;

    public void setService(ElementWithIdService service) {
        this.service = service;
    }

    @RequestMapping(value="otypes", method = RequestMethod.GET)
    public String listOtypes(@RequestParam(value="page", required = false) Long page, Model model)
    {
        if (null==page)
            page=1L;
        model.addAttribute("otype", new Otypes());
        List<Otypes> otypesList = this.service.listElements("Otypes",page);
        model.addAttribute("listOtypes", otypesList);
        model.addAttribute("page",page);
        return "Otypes/otypes";
    }

    @RequestMapping("otype/{id}")
    public String otypeData(@PathVariable("id") int id, Model model){
        model.addAttribute("otype", this.service.getElementById("Otypes",id));
        return "otype";
    }

    @RequestMapping(value="searchOtype", method = RequestMethod.POST)
    public String searchResults(@ModelAttribute("otype") Otypes otype, Model model) {
        model.addAttribute("otype", new Otypes());
        List<Otypes> searchResult  = this.service.listElementsByColumnValue("Otypes","name",otype.getId());
        model.addAttribute("listOtypes", searchResult);
        return "searchOtype";
    }

    @RequestMapping(value = "/otypes/add", method = RequestMethod.POST)
    public String addOtype(@ModelAttribute("otype") Otypes otype){
        if (otype.getId()==0)
            this.service.addElement(otype);
        else
            this.service.updateElement(otype);
        return "redirect:/otypes";
    }

    @RequestMapping("/remove/{id}")
    public String removeOtype(@PathVariable("id") int id){
        this.service.removeElementById("Otypes",id);
        return "redirect:/otypes";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@RequestParam(value="page", required = false) Long page,@PathVariable("id") int id, Model model){
        if (null==page)
            page=1L;
        model.addAttribute("otype", this.service.getElementById("Otypes",id));
        model.addAttribute("listOtypes",this.service.listElements("Otypes",page));
        model.addAttribute("page",page);
        return "otypes";
    }
}
