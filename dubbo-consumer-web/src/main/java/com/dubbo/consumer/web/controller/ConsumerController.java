package com.dubbo.consumer.web.controller;

import com.dubbo.provider.api.service.ProviderApi;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mqz
 * @description
 * @since 2020/9/14
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @DubboReference(version = "${rpc.version}")
    private ProviderApi providerApi;


    @GetMapping("/call/{name}")
    public String call(@PathVariable("name") String name){
        return  providerApi.dealWith();
    }


}
