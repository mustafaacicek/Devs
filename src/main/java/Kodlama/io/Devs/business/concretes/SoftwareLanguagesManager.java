package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.SoftwareLanguagesService;
import Kodlama.io.Devs.business.validation.LanguageValidation;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareLanguagesManager implements SoftwareLanguagesService {
    @Autowired
    private LanguageRepository languageRepository;

    public SoftwareLanguagesManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<SoftwareLanguage> getAll() {
        return this.languageRepository.getAll();
    }

    @Override
    public SoftwareLanguage getById(int id) {
        SoftwareLanguage s = this.languageRepository.getById(id);
        return s;
    }

    @Override
    public SoftwareLanguage getByName(String name) throws Exception {
        return null;
    }

    @Override
    public void add(SoftwareLanguage softwareLanguage) throws Exception {
        //validtion will be here
        LanguageValidation.nameCannotBeNull(softwareLanguage);
        LanguageValidation.idCannotBeNull(softwareLanguage);
        LanguageValidation.nameCannotBeEmpty(softwareLanguage);
        // iş kuralı gelecek
        SoftwareLanguage s = languageRepository.getByName(softwareLanguage.getLanguageName());
        if (s != null)
            throw new Exception("Name Can not be dublicated");
        s = languageRepository.getById(softwareLanguage.getId());
        if (s != null)
            throw new Exception("Id Can not be dublicated");
        this.languageRepository.add(softwareLanguage);

    }

    @Override
    public void delete(int id) throws Exception {
        SoftwareLanguage s = languageRepository.getById(id);
        if (s == null)
            throw new Exception("This id can not found");
        languageRepository.delete(id);

    }


    @Override
    public void update(SoftwareLanguage softwareLanguage,int id) throws Exception{
        LanguageValidation.nameCannotBeEmpty(softwareLanguage);
        LanguageValidation.nameCannotBeNull(softwareLanguage);
        SoftwareLanguage s = languageRepository.getById(id);
        s.setLanguageName(softwareLanguage.getLanguageName());
        languageRepository.update(s);

    }

}
