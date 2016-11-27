package mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gurt on 11/27/16.
 */
public class MediatorApp {
    public static void main(String[] args) {

        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Ivan Ivanovich");
        User u1 = new SimpleUser(chat, "Vanya");
        User u2 = new SimpleUser(chat, "Vova");
        User u3 = new SimpleUser(chat, "Sasha");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        u1.sendMessage("Hello");
        admin.sendMessage("Hello");
    }
}

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    };
    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}

class Admin extends User {
    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Administrator " + getName() + " get message '" + message + "'");
    }
}

class SimpleUser extends User {
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User" + getName() + " get message '" + message + "'");
    }
}

interface Chat {
    void sendMessage(String message, User user);
}

class TextChat implements Chat {

    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("You haven't such permissions");
        }
    }

    public void addUser(User u) {
        if (admin == null) {
            throw new RuntimeException("This chat doesn't have administrator!");
        }
        if (u instanceof SimpleUser) {
            users.add(u);
        } else {
            throw new RuntimeException("Admin can't enter other chat");
        }
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }

        if (user instanceof SimpleUser) {
            for (User u : users) {
                if (u != user && u.isEnable()) {
                    u.getMessage(user.getName() + ": " + message);
                }
            }
            if(admin.isEnable()) {
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}