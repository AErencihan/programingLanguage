package com.example.programinglanguage.business.concretes;

import com.example.programinglanguage.business.abstracts.LanguageService;
import com.example.programinglanguage.dataAccess.abstracts.LanguageRepository;
import com.example.programinglanguage.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;


    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    public List<Language> add(Language language) {
        if (language.getName().isEmpty()) {
            System.out.println("Lütfen dili giriniz");
        }
        List<Language> repositoryAll = languageRepository.getAll();
        for (Language i : repositoryAll) {
            if (i.getName().equals(language.getName())) {
                System.out.println("Bu dil zaten mevcut");
                throw new RuntimeException("bu dil mevcut");
            }
        }
        languageRepository.add(language);
        System.out.println("Dil eklendi");

        return languageRepository.getAll();
    }

    public List<Language> delete(Language language) {
        List<Language> languageList = getAll();
        for (Language found : languageList) {
            if (found.getId() == language.getId()) {
                languageRepository.delete(found);
            }
        }
        return languageRepository.getAll();
    }

    public List<Language> update(Language language) {
        languageRepository.update(language);
        return languageRepository.getAll();
    }

    public void getById(int id) {
        languageRepository.getById(id);
    }



}
