package kr.sparta.ttougayeon.member.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Optional;

@Schema(description = "멤버 객체")
@Entity(name = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Schema(description = "DB에 저장하는 PK 값")
    private long    id;             // 'ID'

    @NotNull
    @Schema(description = "이메일")
    private String  email;          //  '이메일'

    @NotNull
    @Schema(description = "이름")
    private String  name;           //  '이름'

    @NotNull
    @Schema(description = "나이")
    private int     age;            //  '나이'

    @NotNull
    @Schema(description = "전화번호")
    private String  phone;          //  '전화번호'

    @NotNull
    @Schema(description = "주소")
    private String  address;        //  '주소'

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Schema(description = "재산")
    private Asset  assets;          //  '재산'
    @Schema(description = "결혼 횟수")
    private int     marriedCount;   //  '결혼 횟수'

    @Accessors(fluent = true)
    @JsonProperty
    @Schema(description = "제사여부")
    private boolean hasJesa;        //  '제사 여부'
    @Schema(description = "자녀 수")
    private int     childrenCount;  //  '자녀 수'

    @Accessors(fluent = true)
    @JsonProperty
    @Schema(description = "자가 여부")
    private boolean hasOwnHouse;    //  '자가 여부'
    @Schema(description = "차량가액")
    private long    carPrice;       //  '차량가액 (단위: 만원)'

    public Member(MemberCreateRequest request) {
        this.email = request.getEmail();
        this.name = request.getName();
        this.age = request.getAge();
        this.phone = request.getPhone();
        this.address = request.getAddress();
        this.assets = request.getAssets();
        this.marriedCount = request.getMarriedCount();
        this.hasJesa = request.hasJesa();
        this.childrenCount = request.getChildrenCount();
        this.hasOwnHouse = request.hasOwnHouse();
        this.carPrice = request.getCarPrice();
    }
}
