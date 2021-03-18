package training.expires;

public class Code {
    private char[] code;
    private int currIndex;

    public Code(char[] newCode){
        assert newCode != null;
        code = newCode;
        currIndex = 0;
    }

    public int GetCurrentIndex(){
        return currIndex;
    }

    public void IncCurrentIndex(){
        assert currIndex < code.length;
        currIndex++;
    }

    public void DicCurrentIndex(){
        assert currIndex > 0;
        currIndex--;
    }
}
