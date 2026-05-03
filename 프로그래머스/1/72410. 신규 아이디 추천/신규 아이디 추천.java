// 아이디가 규칙에 맞지 않는 경우, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천
// 아이디의 길이가 3이상 15이하
// 아이디는 소문자, 숫자, 하이픈, 언더바, 마침표만 사용가능하고
// 마침표는 처음과 끝, 연속사용은 불가능

class Solution {

    // 7단계의 순차적인 처리 과정을 통해 검사하고, 규칙에 맞지 않을 경우 새로운 아이디 추천
    public String solution(String new_id) {

        // 1. 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 문자 제거
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9') ||
                    c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        // 3. 마침표가 2번이상 연속 된 경우, 하나의 마침표로 치환
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            // 현재 문자가 '.' 이고, 전에 저장한 문자가 '.' 일 경우(연속된 마침표), 문자열에 담지 않고 스킵
            if (c == '.' && temp.length() > 0 && temp.charAt(temp.length() - 1) == '.') {
                continue;
            }
            temp.append(c);
        }

        // 4. 아이디의 시작과 끝에 마침표가 포함되면 제거
        new_id = temp.toString();
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5. new_id가 빈 문자열이면, a를 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. new_id의 길이가 16자 이상이면, 첫 15개 문자만 사용, 제거 후 마지막 문자가 마침표 일 경우 마침표 제거
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }

        // 7. new_id의 길이가 2자 이하라면, 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}