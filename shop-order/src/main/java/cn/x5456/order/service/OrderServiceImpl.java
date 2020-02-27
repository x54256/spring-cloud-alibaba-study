package cn.x5456.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl {

    //定义一个资源
    //定义当资源内部发生异常的时候的处理逻辑
    //blockHandler  定义当资源内部发生了BlockException应该进入的方法[捕获的是Sentinel定义的异常]
    //fallback      定义当资源内部发生了Throwable应该进入的方法
    @SentinelResource(
            value = "message",
            blockHandlerClass = OrderServiceImpl3BlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderServiceImpl3Fallback.class,
            fallback = "fallback"
    )
    public String message() {
        return "message";
    }


    public static class OrderServiceImpl3BlockHandler {

        //blockHandler
        //要求:
        //1 当前方法的返回值和参数要跟原方法一致
        //2 但是允许在参数列表的最后加入一个参数BlockException, 用来接收原方法中发生的异常
        public static String blockHandler(BlockException e) {
            //自定义异常处理逻辑
            log.error("触发了BlockException,内容为{}", e);
            return "BlockException";
        }
    }

    public static class OrderServiceImpl3Fallback {

        //fallback
        //要求:
        //1 当前方法的返回值和参数要跟原方法一致
        //2 但是允许在参数列表的最后加入一个参数BlockException, 用来接收原方法中发生的异常
        public static String fallback(Throwable e) {
            //自定义异常处理逻辑
            log.error("触发了Throwable,内容为{}", e);
            return "Throwable";
        }
    }
}