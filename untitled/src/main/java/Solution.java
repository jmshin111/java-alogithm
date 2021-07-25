class Solution {
    public String solution(String a, String b) {


        int digit_a =  Integer.parseInt(a);
        int digit_b =  Integer.parseInt(b);

        int sum = digit_a+digit_b;

        String answer = String.valueOf(sum);

        return answer;
    }
}