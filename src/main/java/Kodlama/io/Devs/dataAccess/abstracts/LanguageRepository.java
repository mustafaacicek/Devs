package Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;

import java.util.List;

public interface LanguageRepository {

    List<SoftwareLanguage> getAll();
    SoftwareLanguage getById(int id);

    SoftwareLanguage getByName(String name);
    void add(SoftwareLanguage softwareLanguage);
    void delete(int id);
    void update(SoftwareLanguage softwareLanguage); // S->Single Responsibility O-> Open Closed

}
