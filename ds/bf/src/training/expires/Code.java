package training.expires;

public class Code {
    private char[] items;
    private int currIndex;

    public Code(char[] newCode){
        assert newCode != null;
        items = newCode;
        currIndex = 0;
    }

    public char getCurrentOpcode(){
        int index = currIndex;
        incCurrentIndex();
        return items[index];
    }

    public boolean isOver(){
        return currIndex == items.length;
    }

    public int getCurrentIndex(){
        return currIndex;
    }

    public void incCurrentIndex(){
        assert currIndex < items.length;
        currIndex++;
    }

    /*
    public void DicCurrentIndex(){
        assert currIndex > 0;
        currIndex--;
    }
    */

}
