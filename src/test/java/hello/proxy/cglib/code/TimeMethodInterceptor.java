package hello.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // 동적으로 메소드 호출
        // Object result = method.invoke(target, args); // 이걸로 호출하는 것도 가능하지만
        Object result = methodProxy.invoke(target, args); // 얘로 호출하는 것이 성능상 더 빠르다고 함

        long endTime = System.currentTimeMillis();
        log.info("TimeProxy 종료 resultTime = {}", endTime - startTime);

        return result;
    }
}
