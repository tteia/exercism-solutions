class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder();
        boolean nextUpper = false;

        for (int i = 0; i < identifier.length(); i++) {
            char c = identifier.charAt(i);

            // 1. 케밥 케이스('-') 처리: 하이픈을 만나면 다음 문자를 대문자로 표시
            if (c == '-') {
                nextUpper = true;
                continue;
            }

            // 2. 리트(leetspeak) 숫자 치환
            c = switch (c) {
                case '4' -> 'a';
                case '3' -> 'e';
                case '0' -> 'o';
                case '1' -> 'l';
                case '7' -> 't';
                default -> c;
            };

            // 케밥 케이스 다음 글자면 대문자로 변환
            if (nextUpper) {
                c = Character.toUpperCase(c);
                nextUpper = false;
            }

            // 3. 공백(' ')은 밑줄('_')로 변환
            if (c == ' ') {
                result.append('_');
            }
            // 4. 알파벳이거나 밑줄('_')이면 유지 (그 외 특수문자 등은 제외)
            else if (Character.isLetter(c) || c == '_') {
                result.append(c);
            }
        }

        return result.toString();
    }
}