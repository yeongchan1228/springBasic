package study.springBasic.configuration;

import org.springframework.context.annotation.Bean;
import study.springBasic.repository.MemberRepository;
import study.springBasic.repository.MemoryMemberRepository;
import study.springBasic.service.MemberService;

public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
