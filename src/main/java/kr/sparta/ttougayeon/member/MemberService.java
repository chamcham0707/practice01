package kr.sparta.ttougayeon.member;

import jakarta.persistence.EntityNotFoundException;
import kr.sparta.ttougayeon.member.exception.DuplicateEmailException;
import kr.sparta.ttougayeon.member.model.Member;
import kr.sparta.ttougayeon.member.model.MemberCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(MemberCreateRequest request) {
        memberRepository.findByEmail(request.getEmail()).ifPresent(m -> {
            throw new DuplicateEmailException("Duplicate email");
        });

        final Member member = new Member(request);
        return memberRepository.save(member);
    }

    public Member getMember(Long memberNo) {
        return memberRepository.findById(memberNo)
                .orElseThrow(EntityNotFoundException::new);
    }
}
