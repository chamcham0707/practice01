package kr.sparta.ttougayeon.member.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.experimental.Accessors;

@Schema(description = "멤버 등록할 때 요청하는 DTO")
@Getter
public class MemberCreateRequest {
    private String  email;          //  '이메일'
    private String  name;           //  '이름'
    private int     age;            //  '나이'
    private String  phone;          //  '전화번호'
    private String  address;        //  '주소'
    private Asset  assets;          //  '재산'
    private int     marriedCount;   //  '결혼 횟수'

    @Accessors(fluent = true)
    private boolean hasJesa;        //  '제사 여부'
    private int     childrenCount;  //  '자녀 수'

    @Accessors(fluent = true)
    private boolean hasOwnHouse;    //  '자가 여부'
    private long    carPrice;       //  '차량가액 (단위: 만원)'
}
