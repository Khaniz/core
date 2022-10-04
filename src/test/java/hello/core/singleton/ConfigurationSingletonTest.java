package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext adc = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = adc.getBean("memberService", MemberServiceImpl.class);
        MemberRepository memberRepository = adc.getBean("memberRepository", MemberRepository.class);
        OrderServiceImpl orderService = adc.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberRepository2 = " + memberRepository2);

        Assertions.assertThat(memberService.getMemberRepository()).isEqualTo(memberRepository1);

    }
}
