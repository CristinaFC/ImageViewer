package imageviewer.MVC.apps.mock;

import imageviewer.MVC.apps.mock.implementations.MockImageDisplay;
import imageviewer.MVC.apps.mock.implementations.MockImageLoader;
import imageviewer.MVC.control.Command;
import imageviewer.MVC.control.InitCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, Command> commands = new HashMap<>();
    private final static Command NullCommand = new Command.Null();


    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        InitCommand init = new InitCommand(new MockImageLoader().load(), new MockImageDisplay());
        init.execute();
        commands.putAll(init.getCommands());
    }
    
    public void execute(){
        while(true) commands.getOrDefault(input(), NullCommand).execute();
    }

    private String input() {
        return scanner.next().toUpperCase();
    }   
}
