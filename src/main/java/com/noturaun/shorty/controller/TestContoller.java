package com.noturaun.shorty.controller;

import com.noturaun.shorty.dto.ResponseBody;
import com.noturaun.shorty.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestContoller {


    @GetMapping(value = "/ping")
    @SuppressWarnings(value = "unchecked")
    public ResponseEntity<ResponseBody<?>> ping(){
        List<String> data = new ArrayList<>();
        data.add("test");
        return ResponseEntity.ok().body(new ResponseBody<>("success", "PONG", data, null));
    }

}
