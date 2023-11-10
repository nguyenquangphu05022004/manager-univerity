package com.example.Service.imp.response.impl;

import com.example.Service.imp.response.IResponseService;
import com.example.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseService implements IResponseService {

    @Autowired
    private ResponseExchangeSubject responseExchangeSubject;
    @Autowired
    private ResponseBlog responseBlog;

    @Override
    public Boolean confirm(Object... params) {
        String typeConfirm = (String) params[params.length - 1];
        if (typeConfirm.equals(SystemConstant.CONFIRM_REQUEST_ACCEPT_EXCHANGE_SUBJECT)) {
            return responseExchangeSubject.confirm(params);
        } else if(typeConfirm.equals(SystemConstant.CONFIRM_REQUEST_ACCEPT_POST)) {
            return responseBlog.confirm(params);
        } else if(typeConfirm.equals(SystemConstant.CONFIRM_REQUEST_ACCEPT_REPORT)) {
            return null;
        }
        return null;

    }


}
