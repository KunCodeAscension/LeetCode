package A_hot100;

public class id_394_1 {

    public String decodeString(String s) {
        char[] ScharArrar = s.toCharArray();
        return encodeString(0, s.length() - 1, ScharArrar);
    }

    public String encodeString(int start,int end,char[] chars) {
        if(start > end) return "";
        if(start == end) return chars[start] + "";
        if(chars[start] - 48 >= 0 && chars[start] - 48 <= 9){
            String snum = chars[start] + "";
            int right_num_index = start + 1;
            while (chars[right_num_index] - 48 >= 0 && chars[right_num_index] - 48 <= 9){
                snum += chars[right_num_index];
                right_num_index++;
            }
            int num = Integer.parseInt(snum);
            int leftindex = right_num_index + 1;
            int rightindex = findright(right_num_index, chars) - 1;
            String s = encodeString(leftindex, rightindex, chars);
            String result = "";
            while (num != 0){
                result += s;
                num--;
            }
            return result + encodeString(rightindex + 2, end, chars);
        }
        return chars[start] + "" + encodeString(start+1,end,chars);
    }

    public int findright(int index,char[] chars) {
        int left = 0;
        int right = 0;
        int right_index = 0;
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] == '[') {
                left++;
            }else if (chars[i] == ']') {
                right++;
            }
            if(right - 1 == left){
                right_index = i;
                break;
            }
        }
        return right_index;
    }

}
