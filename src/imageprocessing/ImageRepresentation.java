/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imageprocessing;

import static imageprocessing.ProcessingPanel.CaseMemanjang;
import static imageprocessing.ProcessingPanel.OriginalImageLabel;
import static imageprocessing.ProcessingPanel.heightImage;
import static imageprocessing.ProcessingPanel.pathImage;
import static imageprocessing.ProcessingPanel.widthImage;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author daniar heri
 */
public class ImageRepresentation {
    ImagePixel Pixel[][] = new ImagePixel[ProcessingPanel.widthImage][ProcessingPanel.heightImage];
    
    public BufferedImage CurrentImage = null;
    public Vector<UndoClass> UndoImage = new Vector<UndoClass>();
    
    int CurrentPackInt = -1;
    int CurrentArea = 0;
    
    public ImageRepresentation(){
        try {
            float h, w;
            if (!CaseMemanjang){
                h = OriginalImageLabel.getHeight();
                w =(float) OriginalImageLabel.getHeight()/MainFrame.Image.getHeight()*MainFrame.Image.getWidth();
            }else{
                h = (float) OriginalImageLabel.getWidth()/MainFrame.Image.getWidth()*MainFrame.Image.getHeight();
                w =OriginalImageLabel.getWidth();
            }   
            CurrentImage =ImageIO.read(new File(ProcessingPanel.pathImage));
            CurrentImage = ProcessingPanel.resize(CurrentImage,(int)w,(int) h);
        } catch (IOException ex) {
            Logger.getLogger(ImageRepresentation.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(ProcessingPanel, "Soory! Image can not be loaded.", "Input error", JOptionPane.ERROR_MESSAGE);
        }
        
        for(int i = 0 ; i < heightImage ; i ++){
            for(int j = 0 ; j < widthImage ; j++){
                //System.out.println(i+" f "+j);
                Pixel[j][i] = new ImagePixel(j,i);
            }
        }
       // System.out.println(widthImage+"  ini lebar");
    }
    
    public void Undo(){
        CurrentImage = ProcessingPanel.deepCopy(UndoImage.lastElement().Image);
        for(int i = 0 ; i < heightImage ; i ++){
            for(int j = 0 ; j < widthImage ; j++){
               // System.out.println(i+"  "+j);
                Pixel[j][i].Checked = UndoImage.lastElement().Pixel[j][i].Checked ;
            }
        }
        CurrentArea =  UndoImage.lastElement().CurrentArea;
        UndoImage.removeElementAt(UndoImage.size()-1);
    }
    
    public void SimpanCurrentState(){
        UndoClass Undo = new UndoClass();
        Undo.Image = ProcessingPanel.deepCopy(CurrentImage);
        for(int i = 0 ; i < heightImage ; i ++){
            for(int j = 0 ; j < widthImage ; j++){
               // System.out.println(i+"  "+j);
                Undo.Pixel[j][i] = new ImagePixel(j,i);
                Undo.Pixel[j][i].Checked  = Pixel[j][i].Checked ;
            }
        }
        Undo.CurrentArea = CurrentArea;
        UndoImage.add(Undo);
    }
    
    public void clearMark(){
        CurrentPackInt = -11;
        CurrentArea = 0;
         try {
                float h, w;
            if (!CaseMemanjang){
                h = OriginalImageLabel.getHeight();
                w =(float) OriginalImageLabel.getHeight()/MainFrame.Image.getHeight()*MainFrame.Image.getWidth();
            }else{
                h = (float) OriginalImageLabel.getWidth()/MainFrame.Image.getWidth()*MainFrame.Image.getHeight();
                w =OriginalImageLabel.getWidth();
            }   
            CurrentImage =ImageIO.read(new File(ProcessingPanel.pathImage));
            CurrentImage = ProcessingPanel.resize(CurrentImage,(int)w,(int) h);
        } catch (IOException ex) {
            Logger.getLogger(ImageRepresentation.class.getName()).log(Level.SEVERE, null, ex);
            //JOptionPane.showMessageDialog(ProcessingPanel, "Soory! Image can not be loaded.", "Input error", JOptionPane.ERROR_MESSAGE);
        }
        
        for(int i = 0 ; i < heightImage ; i ++){
            for(int j = 0 ; j < widthImage ; j++){
                Pixel[j][i].Checked = false;
            }
        }
    }
    
    boolean IsChecked(int xx, int yy){
        return Pixel[xx][yy].Checked;
    }
}
