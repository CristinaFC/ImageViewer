package imageviewer.MVC.view;

import imageviewer.MVC.model.Image;


public interface ImageDisplay {
    void display(Image image);
    public Image currentImage();
}
