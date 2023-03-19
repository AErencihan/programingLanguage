package com.example.programinglanguage.business.abstracts;

import com.example.programinglanguage.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    List<Language> add(Language language);

    List<Language> delete(Language language);

    List<Language> update(Language language);


     void getById(int id);

}
