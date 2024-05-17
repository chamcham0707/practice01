package kr.sparta.ttougayeon.member;

import kr.sparta.ttougayeon.member.model.Member;
import kr.sparta.ttougayeon.member.model.MemberCreateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public Member register(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping("/members/{memberNo}")
    public Member getMember(@PathVariable("memberNo") Long memberNo) {
        return memberService.getMember(memberNo);
    }
}
