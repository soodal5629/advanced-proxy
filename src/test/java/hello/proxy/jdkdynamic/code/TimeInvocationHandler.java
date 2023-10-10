package hello.proxy.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
    // 동적 프록시가 호출할 대상
    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        // 동적으로 메소드 호출
        Object result = method.invoke(target, args); // call
        long endTime = System.currentTimeMillis();
        log.info("TimeProxy 종료 resultTime = {}", endTime - startTime);

        return result;
    }
}
