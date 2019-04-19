package model.service.impl;

import model.service.I18nService;

import java.util.Locale;
import java.util.ResourceBundle;

class I18nServiceImpl implements I18nService {

    @Override
    public String getMessage(String key, Locale locale) {
        String value = ResourceBundle.getBundle("/language", locale).getString(key);
        return value;
    }
}
