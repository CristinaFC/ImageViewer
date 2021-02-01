
package imageviewer.MVC.apps.mock.implementations;

import imageviewer.MVC.model.Image;
import imageviewer.MVC.view.ImageDisplay;

    
public class MockImageDisplay implements ImageDisplay{

    private Image image;

    @Override
    public void display(Image image) {
        this.image = image;
        System.out.println(image.getName());
    }

    @Override
    public Image currentImage() {
        return image;
    }

}
    