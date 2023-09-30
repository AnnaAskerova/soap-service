package com.example.service.service;

import com.example.service.patch.GetPatchResponse;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.example.service.service.UpdateService")
public class UpdateServiceImpl implements UpdateService{

    @Override
    @WebMethod
    public GetPatchResponse getPatch() {
        var response = new GetPatchResponse();
       /* response.setToDelete(List.of(1L,2L,3L));*/
        return response;
    }

}
