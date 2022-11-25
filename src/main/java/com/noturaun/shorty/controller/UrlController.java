package com.noturaun.shorty.controller;

import com.noturaun.shorty.dto.ResponseBody;
import com.noturaun.shorty.model.Url;
import com.noturaun.shorty.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Value("{test.short.url}")
    private String url = "new-number";

    @Value("{test.long.url}")
    private String origin;

    @Autowired
    private UrlService urlService;

    @GetMapping(value = "/get")
    public ResponseEntity<?> getAndRedirect(@RequestParam String shorturl){
        if (shorturl.equalsIgnoreCase(url)){
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .location(URI.create(origin))
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("URL not found");
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveShortenedurl(@RequestParam boolean isCustom, @RequestBody Url origin){

        urlService.shorten(origin, isCustom);

        return ResponseEntity.ok()
                .body(ResponseBody.builder()
                        .status("succes")
                        .message("url saved")
                        .build()
        );
    }
}
