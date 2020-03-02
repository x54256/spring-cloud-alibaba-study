package cn.x5456.order.client;

import cn.x5456.common.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//value用于指定调用nacos下哪个微服务
@FeignClient(value = "service-product"/*, fallbackFactory = ProductServiceFallbackFactory.class*/)
public interface ProductClient {
    //@FeignClient的value +  @RequestMapping的value值  其实就是完成的请求地址  "http://service-product/product/" + pid
    //指定请求的URI部分
    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);

    // 扣减库存
    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") Integer num);
}
