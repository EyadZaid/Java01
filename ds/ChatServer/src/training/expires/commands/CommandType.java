package training.expires.commands;

public enum CommandType {
    LIST, NICKNAME, ROOM, LEAVE, ROOM_MSG, PRIVATE_MSG, QUIT;

    public static CommandType getCommandType(String input) {
        input = input.trim().toLowerCase();

        switch (input) {
            case "list" -> { return LIST; }

            case "nickname" -> { return NICKNAME; }

            case "room" -> { return ROOM; }

            case "leave" -> { return LEAVE; }

            case "msg" -> { return PRIVATE_MSG; }

            case "quit" -> { return QUIT; }

            default -> { return ROOM_MSG; }
        }
    }
}
