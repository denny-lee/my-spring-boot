package com.lee;

import com.xinguang.tubobo.launcher.inner.api.TbbOrderServiceInterface;
import com.xinguang.tubobo.launcher.inner.api.entity.OrderStatusInfoDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Description:
 * On 2017/9/22 19:54 created by LW
 */
public class Temp {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo.xml"});
        context.start();
        TbbOrderServiceInterface demoService = (TbbOrderServiceInterface) context.getBean("tbbOrderServiceInterface"); // obtain proxy object for remote invocation
        OrderStatusInfoDTO stat = new OrderStatusInfoDTO();
        stat.setOrderNo("9999");
        stat.setOrderStatus("444");
        boolean hello = demoService.statusChange("2222", stat);
        System.out.println(hello);
//        System.in.read();
    }
}
