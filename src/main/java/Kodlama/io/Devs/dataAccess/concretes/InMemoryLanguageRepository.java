package Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    List<SoftwareLanguage> softwareLanguageList = new ArrayList<>();

    public InMemoryLanguageRepository() {
        softwareLanguageList.add(new SoftwareLanguage(1, "C#"));
        softwareLanguageList.add(new SoftwareLanguage(2, "java"));
        softwareLanguageList.add(new SoftwareLanguage(3, "C"));
        softwareLanguageList.add(new SoftwareLanguage(4, "C++"));
        softwareLanguageList.add(new SoftwareLanguage(5, "Angular"));
        softwareLanguageList.add(new SoftwareLanguage(6, "JavaScript"));
    }

    @Override
    public List<SoftwareLanguage> getAll() {
        return this.softwareLanguageList;
    }

    @Override
    public SoftwareLanguage getById(int id) {
        SoftwareLanguage softwareLanguage = new SoftwareLanguage();
        for (SoftwareLanguage s : softwareLanguageList) {
            if (s.getId() == id) {
                softwareLanguage = s;
                break;
            }

        }
        if (softwareLanguage.getLanguageName() == null)
            return null;
        return softwareLanguage;
    }

    @Override
    public SoftwareLanguage getByName(String name) {
        SoftwareLanguage softwareLanguage = new SoftwareLanguage();
        for (SoftwareLanguage sName : softwareLanguageList) {
            if (sName.getLanguageName().equals(name)) {
                softwareLanguage = sName;
                break;
            }
        }
        if (softwareLanguage.getLanguageName() == null)
            return null;
        return softwareLanguage;

    }

    @Override
    public void add(SoftwareLanguage softwareLanguage) {
        this.softwareLanguageList.add(softwareLanguage);
    }

    @Override
    public void delete(int id) {
        SoftwareLanguage s = getById(id);
        this.softwareLanguageList.remove(s);
    }

    @Override
    public void update(SoftwareLanguage softwareLanguage) {
       SoftwareLanguage s=getById(softwareLanguage.getId());
       s.setLanguageName(softwareLanguage.getLanguageName());
        // this.softwareLanguageList.replaceAll();
    }
}
