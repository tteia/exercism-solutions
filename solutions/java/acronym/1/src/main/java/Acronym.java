class Acronym {

    private final String acronym;

    Acronym(String phrase) {
        String line = phrase.replace('-', ' ').replaceAll("[^a-zA-Z0-9\\s]", "");

        StringBuilder sb = new StringBuilder();
        for(String word : line.trim().split("\\s+")) {
            if(!word.isEmpty()) sb.append(Character.toUpperCase(word.charAt(0)));
        }
        this.acronym = sb.toString();
    }

    String get() {
        return acronym;
    }

}
