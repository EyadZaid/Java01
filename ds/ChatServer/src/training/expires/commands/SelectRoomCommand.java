package training.expires.commands;

import training.expires.ChatManager;
import training.expires.Room;
import training.expires.User;

public class SelectRoomCommand implements ICommand {

    @Override
    public void execute(String input, User user) {
        String[] arrInput = input.split(" ");

        if (arrInput.length < 2) {
            return;
        }

        String roomKey = arrInput[1].trim().toLowerCase();
        Room room = ChatManager.getInstance().getRooms().get(roomKey);

        if (room == null) {
            return;
        }

        Room oldRoom = user.getRoom();
        if (oldRoom != null) {
            oldRoom.removeUser(user);
        }

        user.setRoom(room);
        room.addUser(user);
    }
}
