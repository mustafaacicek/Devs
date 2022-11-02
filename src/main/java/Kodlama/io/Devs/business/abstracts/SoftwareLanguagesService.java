package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;

import java.util.List;

public interface SoftwareLanguagesService {
    List<SoftwareLanguage> getAll();
    SoftwareLanguage getById(int id) throws Exception;
    SoftwareLanguage getByName(String name) throws Exception;
    void add(SoftwareLanguage softwareLanguage) throws Exception ;
    void delete(int id) throws Exception;
    void update(SoftwareLanguage softwareLanguage,int id) throws Exception;

}
