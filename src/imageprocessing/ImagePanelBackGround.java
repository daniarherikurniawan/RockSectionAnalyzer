/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageprocessing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author daniar heri
 */
public class ImagePanelBackGround extends JPanel{
    private BufferedImage image;
    
    public ImagePanelBackGround(String Path){
        try{
            image = ImageIO.read(new File(Path));
        }catch(IOException e){
            
        }
      //  this(new ImageIcon(img).getImage());
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    
}
