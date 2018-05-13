package solution;

/**
 * Created by KEKE on 2018/5/11
 */
public class CountAndSay {

    public String countAndSay(int n){

        if (n == 1)
            return "1";

        String lastFormat = countAndSay(n-1);
        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;

        while (i < lastFormat.length()){

            char tempCha = lastFormat.charAt(i);
            int count = 1;
            while (i < lastFormat.length() -1 && tempCha == lastFormat.charAt(i+1)){
                count++;
                i++;
            }
            stringBuilder.append(count);
            stringBuilder.append(tempCha);
            i++;
        }
        return stringBuilder.toString();
    }
}
