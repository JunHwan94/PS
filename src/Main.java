import Level1.자연수뒤집어배열로만들기;
import Level2.쇠막대기;
import Level2.큰수만들기;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        System.out.println(first(true, 'a'));
//        System.out.println(first(4, false));
    }

    private static <T> T first(T a, T b){
        return a;
    }

//    private static String createHashValue(String email){
//        String hash = "";
//        try{
//            MessageDigest sh = MessageDigest.getInstance("SHA-256");
//            sh.update(email.getBytes());
//            byte byteData[] = sh.digest();
//            StringBuffer sb = new StringBuffer();
//            for(int i = 0 ; i < byteData.length ; i++)
//                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
//
//            hash = sb.toString();
//        }catch(Exception e){
//            e.printStackTrace();
//            hash = null;
//        }
//        return email.equals("") ? email : hash;
//    }
}
