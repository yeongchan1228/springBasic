package study.springBasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springBasic.domain.Member;
import study.springBasic.repository.MemberRepository;
import study.springBasic.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplcateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplcateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
