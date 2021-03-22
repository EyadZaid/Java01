package training.expires;

public enum Opcodes {
    INCREMENT, DECREMENT, MOVE_LEFT, MOVE_RIGHT, PRINT_CODE, PRINT_VALUE, START_LOOP, END_LOOP;


    public char getOpcode(){
        switch(this){
            case INCREMENT:
                return '+';

            case DECREMENT:
                return '-';

            case MOVE_LEFT:
                return '<';

            case MOVE_RIGHT:
                return '>';

            case PRINT_CODE:
                return '.';

            case PRINT_VALUE:
                return '!';

            case START_LOOP:
                return '[';

            case END_LOOP:
                return ']';

            default:
                assert false;
                return '!';
        }
    }


}
