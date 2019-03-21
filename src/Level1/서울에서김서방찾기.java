package Level1;
import java.util.*;
import java.util.stream.Collectors;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        return "김서방은 " +
                Arrays.stream(seoul)
                        .collect(Collectors.toList())
                        .indexOf("Kim") +
                "에 있다";
    }
}
