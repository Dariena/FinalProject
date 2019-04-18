package model.service;

import java.util.Locale;

public interface I18nService {

    String getMessage(String key, Locale locale);
}
