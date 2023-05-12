package com.example.sce.controller;

import com.example.sce.dominio.ErrorJSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;
@RestController
public class SceErrorController implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = "/error")
    public ErrorJSON onError(HttpServletRequest request, HttpServletResponse response) {

        ErrorJSON errorJSON = new ErrorJSON(this.getErrorAttributes(request));
        errorJSON.setMessage("Ocorreu uma falha!");

        return errorJSON;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(servletWebRequest, ErrorAttributeOptions.defaults());
        return errorAttributes;
    }
}
