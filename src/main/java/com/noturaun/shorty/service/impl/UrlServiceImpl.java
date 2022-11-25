package com.noturaun.shorty.service.impl;

import com.noturaun.shorty.model.Url;
import com.noturaun.shorty.repository.UrlRepository;
import com.noturaun.shorty.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Override
    public String shorten(Url origin, boolean isCustom) {

        if (isCustom){
            System.out.println("custom");
        }

//        System.out.println(origin);

        return null;
    }

    @Override
    public String custom(String custom) {
        return null;
    }

    @Override
    public String origin(String shortened) {
        return null;
    }
}
