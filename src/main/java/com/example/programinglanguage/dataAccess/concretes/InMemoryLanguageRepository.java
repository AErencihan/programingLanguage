package com.example.programinglanguage.dataAccess.concretes;

import com.example.programinglanguage.dataAccess.abstracts.LanguageRepository;
import com.example.programinglanguage.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new CopyOnWriteArrayList<>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));
        languages.add(new Language(4, "C++"));
        languages.add(new Language(5, "JavaScript"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public List<Language> delete(Language language) {
        languages.remove(language);
        return getAll();
    }

    @Override
    public List<Language> update(Language language) {
        language.setName(language.getName());
        return getAll();
    }

    @Override
    public Language getById(int id) {
        return languages.get(id);
    }


}
