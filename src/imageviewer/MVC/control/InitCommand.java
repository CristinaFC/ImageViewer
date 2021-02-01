package imageviewer.MVC.control;

import imageviewer.MVC.model.Image;
import imageviewer.MVC.view.ImageDisplay;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InitCommand implements Command{
    private final Map<String,Command> commands = new HashMap<>();
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public InitCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }


    
    @Override
    public void execute() {
        imageDisplay.display(images.get(0));
        
        commands.put("N", new NextImageCommand(images, imageDisplay));
        commands.put("P", new PrevImageCommand(images, imageDisplay));
        commands.put("Q", new ExitImageCommand());
    }

    public Map<? extends String, ? extends Command> getCommands() {
        
        return commands;
    }
    
}
