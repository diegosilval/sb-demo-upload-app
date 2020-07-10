/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demoapp;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Diego Silva Limaco <diego.silva at vasslatam.com>
 */
@RestController
@RequestMapping("/admin/v1/push")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(
            value = "/",
            produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String registerPushNotification(
            @RequestParam(
                    name = "file",
                    required = true
            ) MultipartFile filePart,
            @RequestParam(
                    name = "title",
                    required = true
            ) String title,
            @RequestParam(
                    name = "body",
                    required = true
            ) String body,
            @RequestParam(
                    name = "sendWhen",
                    required = true
            ) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime sendWhen
    ) throws IOException {
        LOGGER.info("-- push");

        LOGGER.info("title   :{}", title);
        LOGGER.info("body    :{}", body);
        LOGGER.info("sendWhen:{}", sendWhen);

        return "OK";
    }
}
