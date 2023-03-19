package com.example.programinglanguage.dataAccess.abstracts;

import com.example.programinglanguage.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {

    List<Language> getAll();

    void add(Language language);

    List<Language> delete(Language language);

    List<Language> update(Language language);

    Language getById(int id);
}


