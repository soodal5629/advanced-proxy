package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        // 동적으로 메소드 호출
        //Object result = method.invoke(target, args); // call
        Object result = invocation.proceed();// target을 알아서 찾아서 실제 로직을 수행
        long endTime = System.currentTimeMillis();
        log.info("TimeProxy 종료 resultTime = {}", endTime - startTime);

        return result;
    }
}
