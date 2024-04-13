package ocr.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private Long id;                        // 배송 정보 관리 번호

    private int zipCode;                    // 우편번호;

    private String sido;                    // 시도

    private String gugun;                   // 구군

    private String dong;                    // 동

    private String li;                      // 리

    private String bunji;                   // 번지

    private String doro;                    // 도로명주소

    private String detailAddress;           // 상세주소

}
