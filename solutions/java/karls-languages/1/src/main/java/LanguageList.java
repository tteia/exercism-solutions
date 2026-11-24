import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String lang) {
        languages.add(lang);
    }

    public void removeLanguage(String lang){
        languages.remove(lang);
    }

    public String firstLanguage(){
        return languages.get(0);
    }

    public int count(){
        return languages.size();
    }

    public boolean containsLanguage(String lang){
        return languages.contains(lang);
    }

    public boolean isExciting(){
        if(languages.contains("Java") || languages.contains("Kotlin")) return true;
        return false;
    }




}
