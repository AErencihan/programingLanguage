package com.example.programinglanguage.webApi;

import com.example.programinglanguage.business.abstracts.LanguageService;
import com.example.programinglanguage.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @PostMapping("/add")
    public List<Language> add(@RequestBody Language language) {
        return languageService.add(language);
    }

    @DeleteMapping("/delete")
    public List<Language> delete(@RequestBody Language language) {
        return languageService.delete(language);
    }

    @PutMapping("/update")
    public List<Language> update(@RequestBody Language language) {
        return languageService.update(language);
    }


    @RequestMapping("/getbyid")
    public void getById(int id) {
        languageService.getById(id);
    }

}












