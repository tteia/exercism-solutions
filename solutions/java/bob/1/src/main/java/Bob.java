class Bob {

    String hey(String input) {
        String trimmed = input.trim();
        if(trimmed.isEmpty()) return "Fine. Be that way!";

        boolean isQuestion = trimmed.endsWith("?");
        boolean hasLetter = false;
        boolean hasLowerCase = false;

        for(int i = 0; i < trimmed.length(); i++){
            char ch = trimmed.charAt(i);
            if (Character.isLetter(ch)) {
                hasLetter = true;
                if(Character.isLowerCase(ch)) hasLowerCase = true;
            }
        }
        boolean isShouting = hasLetter && !hasLowerCase;

        if (isShouting && isQuestion) return "Calm down, I know what I'm doing!";
        if (isShouting) return "Whoa, chill out!";
        if (isQuestion) return "Sure.";

        return "Whatever.";
    }



}