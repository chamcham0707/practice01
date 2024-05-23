package kr.sparta.ttougayeon.member;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
    @Operation(summary = "멤버 등록", description = "멤버 등록할 때 사용하는 API")
    @Parameters({
            @Parameter(name = "email", description = "이메일", example = "chrome123@naver.com", required = true),
            @Parameter(name = "name", description = "이름", example = "홍길동", required = true),
            @Parameter(name = "age", description = "나이", example = "95", required = true),
            @Parameter(name = "phone", description = "전화번호", example = "010-1234-5678", required = true),
            @Parameter(name = "address", description = "주소", example = "서울특별시 마포구", required = true),
            @Parameter(name = "assets", description = "재산", example = "A", required = true),
            @Parameter(name = "marriedCount", description = "결혼 횟수", example = "2"),
            @Parameter(name = "hasJesa", description = "제사 여부", example = "false"),
            @Parameter(name = "childrenCount", description = "자녀 수", example = "2"),
            @Parameter(name = "hasOwnHouse", description = "자가 여부", example = "false"),
            @Parameter(name = "carPrice", description = "차량가액(단위: 만원)", example = "200")
    })
    public Member register(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping("/members/{memberNo}")
    @Operation(summary = "멤버 정보 가져오기", description = "멤버 정보 가져올 때 사용하는 API")
    public Member getMember(@PathVariable("memberNo") Long memberNo) {
        return memberService.getMember(memberNo);
    }
}
