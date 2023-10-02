package com.example.service.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UpdateService {
    @WebMethod
    GetPatchResponse getPatch();
}
