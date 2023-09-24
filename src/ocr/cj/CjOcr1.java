package ocr.cj;

import ocr.entity.AddressEntity;
import ocr.entity.ShippingInfoEntity;

import java.time.LocalDateTime;

public class CjOcr1 {

    private String ocrString;
    private String[] words;

    public CjOcr1(String ocrString) {
        this.ocrString = ocrString;
        this.words = ocrString.split(",");
    }

    public ShippingInfoEntity makeInfo() {

        System.out.println(words.length);

        ShippingInfoEntity entity = new ShippingInfoEntity();
        entity.setNum(getNum());
        entity.setName(getName());
        entity.setPhoneNum(getPhoneNum());
        entity.setMemo(getMemo());
        entity.setRegistrationAt(LocalDateTime.now());
        entity.setAddressEntity(getAddressEntity());
        return entity;
    }

    /**
     * 운송장 번호 가져오기
     * @return
     */
    private String getNum() {
        String num = "";
        num = words[0].trim();
        System.out.println("운송장 번호 : " + num);
        return num;
    }

    public int findPosition(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].trim().equals(target)) {
                return i;  // Found the target string, return its position
            }
        }
        return -1;  // If not found, return -1
    }

    public int includePosition(String[] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].trim().contains(target)) {
                return i;  // Found the target string, return its position
            }
        }
        return -1;  // If not found, return -1
    }

    /**
     * 이름 추출하기
     * @return
     */
    private String getName(){
        String name = "";
        int position = findPosition(words, "받는분");
        name = words[position + 1].trim();
        System.out.println("이름 : " + name);
        return name;
    }

    private String getPhoneNum(){
        String phoneNum = "";
        int position = findPosition(words, "받는분");
        phoneNum = words[position + 2].trim();
        System.out.println("전화번호 : " + phoneNum);
        return phoneNum;
    }

    private String getMemo(){
        String memo = "";
        int startPosition = findPosition(words, "는분");
        int endPosition = findPosition(words, "(주문번호:");
        for(int i = startPosition+1; i < endPosition; i++){
            memo += words[i];
        }
        System.out.println("메모 : " + memo  + ":" + startPosition + ":" + endPosition);
        return memo;
    }

    private AddressEntity getAddressEntity(){
        AddressEntity addressEntity = new AddressEntity();
        String address = "";
        int startPosition = findPosition(words, "받는분");
        int endPosition = includePosition(words, "주문번호");
        for(int i = startPosition+4; i < endPosition; i++){
            address += words[i];
        }
        System.out.println("주소 : " + address + ":" + startPosition + ":" + endPosition);
        return addressEntity;
    }
}
