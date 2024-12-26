package com.jwt.jwt_springboot2.api.controller;

import com.jwt.jwt_springboot2.BizRequest;
import com.jwt.jwt_springboot2.BizResponse;
import com.jwt.jwt_springboot2.api.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ListController {
    @Autowired
    ListService listService;

    @RequestMapping(value = "getList", method = RequestMethod.POST)
    @ResponseBody
    public BizResponse getUser(@RequestBody BizRequest request) throws Exception {
        BizResponse response = new BizResponse();
        try {
            response.addList(listService.getListUser(request.getData()));
        } catch (Exception e) {

        }
        return response;
    }

}
