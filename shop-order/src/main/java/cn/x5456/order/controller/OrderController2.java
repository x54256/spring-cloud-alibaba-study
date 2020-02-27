package cn.x5456.order.controller;

import cn.x5456.order.service.OrderServiceImpl;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController2 {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/order/message1")
    public String message1() {
        return orderService.message();
    }

    @RequestMapping("/order/message2")
    public String message2() {
        orderService.message();
        return "message2";
    }

    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String name, Integer age) {
        return "message3" + name + age;
    }

    @RequestMapping("/order/message4")
    public String message4() {
        return "message4";
    }


}