package com.lupogreybeard.dbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    public AdminController(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAdmin() {
        return "shh";
    }

    @GetMapping("/endpoints")
    public List<String> getActiveEndpoints() {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream()
                .flatMap(info -> info.getPatternValues().stream())
                .collect(Collectors.toList());
    }

}