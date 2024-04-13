package ocr.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@ToString(exclude = "addressEntity")
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfoEntity {
    private Long id;                        // 배송 정보 관리 번호

    private String num;                     // 운송장 번호

    private String name;                    // 수령인 이름

    private String phoneNum;                // 수령인 연락처

    private String memo;                    // 배송 메모

    private LocalDateTime registrationAt;   // 등록일시

    private Long usersId;                   // 사용자 코드

    private AddressEntity addressEntity;
}
