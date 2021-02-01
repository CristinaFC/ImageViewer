package imageviewer.MVC.control;

import imageviewer.MVC.model.Image;
import imageviewer.MVC.view.ImageDisplay;
import java.util.List;


public class PrevImageCommand implements Command{

    private final List<Image> images;
    private final ImageDisplay display;

    public PrevImageCommand(List<Image> images, ImageDisplay display) {
        this.images = images;
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.display(next());
    }

    private Image next() {
        return images.get(prevIndex());
    }

    private int prevIndex() {
        return (currentIndex() + images.size()- 1) % images.size();
    }

    private int currentIndex() {
        return images.indexOf(display.currentImage());
    }
}
