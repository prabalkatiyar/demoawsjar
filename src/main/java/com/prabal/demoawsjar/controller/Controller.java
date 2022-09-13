package com.prabal.demoawsjar.controller;

import com.prabal.demoawsjar.responsemodel.ApiResponseData;
import com.prabal.demoawsjar.responsemodel.MobiToPosResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Controller {

    public static final Logger log = LogManager.getLogger(Controller.class);

    @GetMapping("/getMethod")
    public MobiToPosResponseDto getMethod() {
        MobiToPosResponseDto response = new MobiToPosResponseDto();
        ApiResponseData res = new ApiResponseData();
        response.setApiResponseData(res);
        try {
            response.setApiResponseCode("200");
            response.setApiResponseMessage("success");

            log.info("Inside getMethod Controller");
//            log.info("Project has deployed on AWS"+ReadProperties.getPropertyData("message"));
            log.info("Project has deployed on AWS");

            response.getApiResponseData().setResponseCode("200");
            response.getApiResponseData().setResponseMessage("success");
//            response.getApiResponseData().setResponseData("Project has deployed on AWS "+ ReadProperties.getPropertyData("message"));
            response.getApiResponseData().setResponseData("Project has deployed on AWS ");

        } catch (Exception e) {
            log.error("Exception occured in getMethod Controller");
            response.setApiResponseCode("401");
            response.setApiResponseMessage("something went wrong");
            response.getApiResponseData().setResponseCode("401");
            response.getApiResponseData().setResponseMessage("something went wrong");
            response.getApiResponseData().setResponseData(e.toString());
        }
        response.setApiResponseDateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        response.setApiResponseFrom("DEMO AWS");
        return response;
    }

    @PostMapping("/postMethod")
    public MobiToPosResponseDto postMethod(@RequestBody String request) {
        MobiToPosResponseDto response = new MobiToPosResponseDto();
        ApiResponseData res = new ApiResponseData();
        response.setApiResponseData(res);
        try {
            response.setApiResponseCode("200");
            response.setApiResponseMessage("success");

            log.info("Inside postMethod Controller");
            log.info(request);

            response.getApiResponseData().setResponseCode("200");
            response.getApiResponseData().setResponseMessage("success");
//            response.getApiResponseData().setResponseData(request+ReadProperties.getPropertyData("message"));
            response.getApiResponseData().setResponseData(request);

        } catch (Exception e) {
            log.error("Exception occured in geMethod Controller");
            response.setApiResponseCode("401");
            response.setApiResponseMessage("something went wrong");
            response.getApiResponseData().setResponseCode("401");
            response.getApiResponseData().setResponseMessage("something went wrong");
            response.getApiResponseData().setResponseData(e.toString());
        }
        response.setApiResponseDateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
//        response.setApiResponseFrom("DEMO AWS"+ReadProperties.getPropertyData("message"));
        response.setApiResponseFrom("DEMO AWS");

        return response;
    }
}