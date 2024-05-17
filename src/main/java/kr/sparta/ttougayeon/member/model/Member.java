package kr.sparta.ttougayeon.member.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Optional;

@Entity(name = "member")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue
    private long    id;             // 'ID'

    @NotNull
    private String  email;          //  '이메일'

    @NotNull
    private String  name;           //  '이름'

    @NotNull
    private int     age;            //  '나이'

    @NotNull
    private String  phone;          //  '전화번호'

    @NotNull
    private String  address;        //  '주소'

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Asset  assets;          //  '재산'
    private int     marriedCount;   //  '결혼 횟수'

    @Accessors(fluent = true)
    @JsonProperty
    private boolean hasJesa;        //  '제사 여부'
    private int     childrenCount;  //  '자녀 수'

    @Accessors(fluent = true)
    @JsonProperty
    private boolean hasOwnHouse;    //  '자가 여부'
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
