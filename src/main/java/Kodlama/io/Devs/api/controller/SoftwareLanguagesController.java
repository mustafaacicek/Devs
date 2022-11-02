package Kodlama.io.Devs.api.controller;

import Kodlama.io.Devs.business.abstracts.SoftwareLanguagesService;
import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Annotation
@RequestMapping("/languages")
public class SoftwareLanguagesController {

    @Autowired
    private final SoftwareLanguagesService languagesService;

    public SoftwareLanguagesController(SoftwareLanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/getall")
    public List<SoftwareLanguage> getAll() {
        return this.languagesService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody SoftwareLanguage softwareLanguage) throws Exception {
        this.languagesService.add(softwareLanguage);
        return softwareLanguage.getLanguageName() + ": Added to InMemory database";
    }

    @GetMapping("/getbyid")
    public SoftwareLanguage getById(@RequestParam int id) throws Exception{
        SoftwareLanguage s = this.languagesService.getById(id);
        return s;
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam int id) throws Exception{
        this.languagesService.delete(id);
        return  ": Deleted to InMemory database";
    }
    @PutMapping("/update")
    public String update(@RequestBody SoftwareLanguage softwareLanguage,@RequestParam int id)throws Exception
    {
        this.languagesService.update(softwareLanguage,id);
        return softwareLanguage.getLanguageName()+": Updated to InMemory database";
    }


}
