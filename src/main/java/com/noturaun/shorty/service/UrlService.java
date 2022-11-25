package com.noturaun.shorty.service;

import com.noturaun.shorty.model.Url;

public interface UrlService {

    String shorten(Url origin, boolean isCustom);

    String custom(String custom);
    String origin(String shortened);

}
