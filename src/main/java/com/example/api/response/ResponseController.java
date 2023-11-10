package com.example.api.response;

import com.example.Service.imp.response.impl.ResponseService;
import com.example.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    @Autowired
    private ResponseService responseService;

    @PutMapping("/api/response/ex/subject/{studentExchangeRegisterId}/{studentRequestExchangeId}")
    public ResponseEntity<?> confirmRequestExchangeSubject(
            @PathVariable(name = "studentExchangeRegisterId") Long studentExchangeRegisterId,
            @PathVariable(name = "studentRequestExchangeId") Long studentRequestExchangeId
    ) {
        return responseService.confirm(
                studentExchangeRegisterId,
                studentRequestExchangeId,
                SystemConstant.CONFIRM_REQUEST_ACCEPT_EXCHANGE_SUBJECT)
                ? ResponseEntity.ok("Success") : ResponseEntity.ok("Fail");

    }

    @PutMapping("/api/response/post/{blogId}")
    public ResponseEntity<?> confirmRequestCreatePost(@PathVariable Long blogId) {
        return responseService.confirm(
                blogId,
                SystemConstant.CONFIRM_REQUEST_ACCEPT_POST)
                ? ResponseEntity.ok("Success") : ResponseEntity.ok("Fail");
    }
}
