/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.apps.swing;

import imageviewer.model.Image;
import imageviewer.view.ImageLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class FileImageLoader implements ImageLoader{
 
    private final File folder;

    public FileImageLoader(File folder) {
        this.folder = folder;
    }

    @Override
    public List<Image> load() {
        List<Image> result = new ArrayList<>();
        File[] files = folder.listFiles(filesWith(".jpg", ".png", ".jpeg"));
        for(File file: files) {
            result.add(new Image(file.getAbsolutePath()));
        }
        return result;
    }

    private FilenameFilter filesWith(String... extensions) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                for (String extension : extensions)
                    if(name.endsWith(extension)) return true;
                return false;
            }
        };
    }
}
