package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void cglib() {
        ConcreteService target = new ConcreteService();

        // CGLIB 생성하는 코드
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class); // 해당 구체 클래스를 상속받아서 프록시 객체 동적으로 생성
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create(); // 프록시 생성

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.call();
    }
}
