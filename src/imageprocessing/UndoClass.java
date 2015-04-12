/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageprocessing;

import java.awt.image.BufferedImage;

/**
 *
 * @author daniar heri
 */
public class UndoClass {
    
    int CurrentArea = 0;
    public BufferedImage Image = null;
    ImagePixel Pixel[][] = new ImagePixel[ProcessingPanel.widthImage][ProcessingPanel.heightImage];
}
