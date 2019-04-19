package form;

import model.service.I18nService;

import java.util.Locale;

public abstract class AbstarctForm {
    protected Locale locale;
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public Locale getLocale(){
        return locale;
    }
    public void validate(I18nService i18nService) throws Exception {

    }
}
