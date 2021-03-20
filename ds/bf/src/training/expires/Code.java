package training.expires;

public class Code {
    private final static int CAPACITY = 16;
    private char[] items;
    private int currIndex;

    public Code(char[] newCode){
        assert newCode != null;
        items = newCode;
        currIndex = 0;
    }

    public Code(){
        items = new char[16];
        currIndex = 0;
    }

    public char getCurrentOpcode(){
        int index = currIndex;
        incCurrentIndex();
        return items[index];
    }

    public char getCurrentOpcodeByIndex(int index){
        assert index >= 0 && index < items.length;
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

    public int getSize(){
        return items.length;
    }

    public void setCurrIndex(int index){
        assert index >= 0 && index < items.length;
        currIndex = index;
    }

    public void dicCurrentIndex(){
        assert currIndex > 0;
        currIndex--;
    }

    public Opcodes getOpcode(char ch){
        switch(ch){
            case '+':
                return Opcodes.INCREMENT;

            case '-':
                return Opcodes.DECREMENT;

            case '<':
                return Opcodes.MOVE_LEFT;

            case '>':
                return Opcodes.MOVE_RIGHT;

            case '.':
                return Opcodes.PRINT_CODE;

            case '!':
                return Opcodes.PRINT_VALUE;

            case '[':
                return Opcodes.START_LOOP;

            case ']':
                return Opcodes.END_LOOP;

            default:
                assert false;
                return Opcodes.PRINT_CODE;
        }
    }

}
