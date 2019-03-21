package Level1;
import java.text.*;
import java.util.*;

public class 년2016년 {
    public String solution(int a, int b) throws ParseException {
        String answer = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2016-" + a + "-" + b);
        cal.setTime(date);
        int d = cal.get(Calendar.DAY_OF_WEEK);
        switch(d){
            case 1: answer = "SUN"; break;
            case 2: answer = "MON"; break;
            case 3: answer = "TUE"; break;
            case 4: answer = "WED"; break;
            case 5: answer = "THU"; break;
            case 6: answer = "FRI"; break;
            case 7: answer = "SAT"; break;
        }
        return answer;
    }
}
