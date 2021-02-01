package imageviewer.control;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;


public class NextImageCommand implements Command{
    private final List<Image> images;
    private final ImageDisplay display;

    public NextImageCommand(List<Image> images, ImageDisplay display) {
        this.images = images;
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.display(next());
    }

    private Image next() {
        return images.get(nextIndex());
    }

    private int nextIndex() {
        return (currentIndex() + 1) % images.size();
    }

    private int currentIndex() {
        return images.indexOf(display.currentImage());
    }
    
}
