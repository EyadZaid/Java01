package training.expires.moderators;

import java.util.ArrayList;
import java.util.List;

public class Moderator {
    private final List<String>  badWords;
    private boolean isCensored;

    public Moderator() {
        this.badWords = new ArrayList<>();
        isCensored = false;
    }

    public void addWord(String word) {
        badWords.add(word);
    }

    public void addListWords(List<String> list) {
        badWords.addAll(list);
    }

    public String censor(String msg) {
        isCensored = false;
        StringBuilder newMsg = new StringBuilder();
        String[] arrMsg = msg.split(" ");

        for (int i=0; i<arrMsg.length; i++) {
            if (i != arrMsg.length-1) {
                newMsg.append(wordCensor(arrMsg[i]) + " ");
            }
            else {
                newMsg.append(wordCensor(arrMsg[i]));
            }
        }
        return newMsg.toString();
    }

    private String wordCensor(String word) {
        for (var w : badWords) {
            if (word.contains(w)) {
                String str = "*".repeat(w.length());
                word = word.replace(w, str);
                isCensored = true;
            }
        }
        return word;
    }

    public boolean isCensored() {
        return isCensored;
    }
}
