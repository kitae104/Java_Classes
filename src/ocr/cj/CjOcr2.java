package ocr.cj;

import ocr.entity.AddressEntity;
import ocr.entity.ShippingInfoEntity;

import java.time.LocalDateTime;

public class CjOcr2 {

    private String ocrString;
    private String[] words;

    public CjOcr2(String ocrString) {
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
        num = words[1].trim();
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
        int position = findPosition(words, "BY");
        name = words[position + 1].trim();
        System.out.println("이름 : " + name);
        return name;
    }

    private String getPhoneNum(){
        String phoneNum = "";
        int position = findPosition(words, "BY");
        phoneNum = words[position + 2].trim();
        System.out.println("전화번호 : " + phoneNum);
        return phoneNum;
    }

    private String getMemo(){
        String memo = "";
        int startPosition = findPosition(words, "부재시");
        int endPosition = findPosition(words, "개인정보");
        for(int i = startPosition; i < endPosition; i++){
            memo += words[i];
        }
        System.out.println("메모 : " + memo  + ":" + startPosition + ":" + endPosition);
        return memo;
    }

    private AddressEntity getAddressEntity(){
        AddressEntity addressEntity = new AddressEntity();
        String address = "";
        int startPosition = findPosition(words, "/");
        int endPosition = includePosition(words, "수량");
        for(int i = startPosition+1; i < endPosition-3; i++){
            address += words[i];
        }
        System.out.println("주소 : " + address + ":" + startPosition + ":" + endPosition);
        return addressEntity;
    }
}
