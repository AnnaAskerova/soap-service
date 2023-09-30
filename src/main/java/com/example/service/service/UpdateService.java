package com.example.service.service;

import com.example.service.patch.GetPatchResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UpdateService {

    @WebMethod
    GetPatchResponse getPatch();

}
