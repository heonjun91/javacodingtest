package StringArrayTest;

// 뒤에서부터 K길이만큼씩 자르고, 소문자는 대문자로 변환해주어 새로운 문자열을 만들어라

import java.util.Locale;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        LicenseKeyFormatting lk = new LicenseKeyFormatting();

        String str = "8F3Z-2e-9-w-a34-APE2";
        //String str = "2-5g-3-J";
        int k = 4;

        lk.solve(str,k);
    }

    public void solve(String str, int k) {
        String s1 = str.replace("-","");
        s1 = s1.toUpperCase();
        //System.out.println(s1);

        StringBuffer sb = new StringBuffer(s1);
        int length = sb.length();

        for(int i=k; i<length; i=i+k) {
            sb.insert(length-i, '-');
        }
        s1 = sb.toString();

        System.out.println(s1);

    }
}
