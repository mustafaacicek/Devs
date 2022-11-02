package Kodlama.io.Devs.business.validation;

import Kodlama.io.Devs.entities.concretes.SoftwareLanguage;

public class LanguageValidation  {
    public static void nameCannotBeNull(SoftwareLanguage softwareLanguage) throws Exception{
        if(softwareLanguage.getLanguageName()==null)
            throw new Exception("Name can not be null");

    }
    public static void nameCannotBeEmpty (SoftwareLanguage softwareLanguage) throws Exception{
        if(softwareLanguage.getLanguageName().isEmpty())
            throw new Exception("Name can not be empty");
    }
    public static void idCannotBeNull (SoftwareLanguage softwareLanguage) throws Exception{
        if(softwareLanguage.getId()<=0)
            throw new Exception("Id can not be 0 and smaller than 0");
    }
}

