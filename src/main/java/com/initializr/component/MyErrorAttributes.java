package com.initializr.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

// 给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    // 拿到我们在controller层定义的错误信息
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company", "MysteryGuest");

        // 我们的异常处理器携带的数据
        Map<String, Object> myException = (Map<String, Object>) requestAttributes.getAttribute("myException", 0);
        map.put("myException", myException);
        return map;
    }
}
