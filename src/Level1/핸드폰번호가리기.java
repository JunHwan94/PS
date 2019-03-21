package Level1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        return new String(new char[phone_number.length() - 4]).replace("\0", "*") + phone_number.substring(phone_number.length() - 4, phone_number.length());
    }
}
