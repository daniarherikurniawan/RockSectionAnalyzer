/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import static imageprocessing.MainFrame.Image;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author daniar heri
 */
public class ProcessingPanel extends ImagePanelBackGround {

    int MaxLabel = 11;
    Vector<JLabel> NameLabel = new Vector<JLabel>();
    Vector<JLabel> ColorLabel = new Vector<JLabel>();
    Vector<JButton> ColorAddButton = new Vector<JButton>();
    Vector<JButton> ColorMarkButton = new Vector<JButton>();
    Vector<JButton> ColorDelButton = new Vector<JButton>();
    Vector<JPanel> ColorPanel = new Vector<JPanel>();
    Vector<JPanel> ContainerPanel = new Vector<JPanel>();
    Vector<Color> color = new Vector<Color>();
    Vector<ImagePixel> MarkedPixel = new Vector<ImagePixel>();
    Vector<ImageRepresentation> ImgRepresentation = new Vector<ImageRepresentation>();

    boolean addAreaByClick = false;
    boolean addAreaByDrag = false;
    int NoAdd = -99;
    int NoShow = -99;
    int NoMagic = 0;
    float TotalPersen = 0;
    int NumberOfLabel = 0;
    public static String pathImage = new String();
    public static int tolerance = 39;
    public BufferedImage Black;
    public BufferedImage Centang;
    public BufferedImage Silang;
    public BufferedImage UndoActive;
    public BufferedImage UndoNonactive;
    public BufferedImage Activated;
    public BufferedImage Deactivated;
    public static int widthImage = 0;
    public static int heightImage = 0;
    public boolean showhint = false;
    public boolean showhint2 = false;
    public boolean draged = false;
    public boolean showhint1 = false;
    public boolean showhint3 = false;
    public boolean IsUndoActive = false;
    public static boolean CaseMemanjang = false;

    Stack<ImagePixel> myStack = new Stack();

    public ProcessingPanel(String path) {
        super(path);
        initComponents();
        ToleranceSlider.setEnabled(false);
        UnMarkImageButton.setEnabled(false);
        ShowMarkedAllImageButton.setEnabled(false);
        try {
            Silang = ImageIO.read(new File("img/png/silang.png"));
            Centang = ImageIO.read(new File("img/png/centang.png"));
            Black = ImageIO.read(new File("img/png/Black.png"));
            UndoActive = ImageIO.read(new File("img/png/UndoActive.png"));
            UndoActive = resize(UndoActive, 35, 35);
            UndoNonactive = ImageIO.read(new File("img/png/UndoNonactive.png"));
            UndoNonactive = resize(UndoNonactive, 35, 35);
            Activated = ImageIO.read(new File("img/png/Activated.png"));
            Deactivated = ImageIO.read(new File("img/png/Deactivated.png"));
            setDeactiv();
            SetUndoNonactive();
        } catch (IOException ex) {
            Logger.getLogger(ProcessingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        PanelColor.setLayout(new BoxLayout(PanelColor, BoxLayout.PAGE_AXIS));
        PanelColor.setVisible(true);
        Print.setEnabled(false);
        OriginalImageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        UndoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // ChangeCursor();
        addAreaByClick = false;
        addAreaByDrag = false;
        BlackSlider.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        OriginalImageLabel = new javax.swing.JLabel();
        Fields = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        G = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        B = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        R = new javax.swing.JTextField();
        fields = new javax.swing.JPanel();
        IsFree = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ToleranceSlider = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        BlackImage1 = new javax.swing.JLabel();
        ToleranceLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BlackSlider = new javax.swing.JSlider();
        BlackImage = new javax.swing.JLabel();
        ActivatedDrag = new javax.swing.JLabel();
        ActivatedClick = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanelColor = new javax.swing.JPanel();
        StopAdd1 = new javax.swing.JButton();
        ShowMarkedAllImageButton = new javax.swing.JButton();
        ChooserButton = new javax.swing.JButton();
        UnMarkImageButton = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        UndoButton = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setOpaque(false);

        OriginalImageLabel.setBackground(new java.awt.Color(153, 153, 255));
        OriginalImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OriginalImageLabel.setDoubleBuffered(true);
        OriginalImageLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                OriginalImageLabelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OriginalImageLabelMouseMoved(evt);
            }
        });
        OriginalImageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OriginalImageLabelMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OriginalImageLabelMouseReleased(evt);
            }
        });

        Fields.setOpaque(false);

        jLabel3.setText("Green");

        G.setEditable(false);
        G.setText("0");
        G.setBorder(null);
        G.setOpaque(false);

        jLabel4.setText("Blue");

        B.setEditable(false);
        B.setText("0");
        B.setBorder(null);
        B.setOpaque(false);

        jLabel2.setText("Red");

        R.setEditable(false);
        R.setText("0");
        R.setBorder(null);
        R.setOpaque(false);

        fields.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout fieldsLayout = new javax.swing.GroupLayout(fields);
        fields.setLayout(fieldsLayout);
        fieldsLayout.setHorizontalGroup(
            fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        fieldsLayout.setVerticalGroup(
            fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        IsFree.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout FieldsLayout = new javax.swing.GroupLayout(Fields);
        Fields.setLayout(FieldsLayout);
        FieldsLayout.setHorizontalGroup(
            FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(G)
                    .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B))
                .addGap(18, 18, 18)
                .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IsFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        FieldsLayout.setVerticalGroup(
            FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FieldsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FieldsLayout.createSequentialGroup()
                        .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FieldsLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(FieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(IsFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Current Color");

        ToleranceSlider.setBackground(new java.awt.Color(204, 204, 204));
        ToleranceSlider.setMaximum(50);
        ToleranceSlider.setValue(39);
        ToleranceSlider.setOpaque(false);
        ToleranceSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ToleranceSliderStateChanged(evt);
            }
        });
        ToleranceSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ToleranceSliderMouseMoved(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tolerance Value");

        BlackImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        ToleranceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add by Klik");

        jLabel6.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Area");

        jLabel7.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Add by Drag");

        jPanel3.setOpaque(false);

        BlackSlider.setMaximum(30);
        BlackSlider.setValue(5);
        BlackSlider.setOpaque(false);
        BlackSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BlackSliderStateChanged(evt);
            }
        });
        BlackSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BlackSliderMouseMoved(evt);
            }
        });

        BlackImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BlackSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(BlackImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BlackSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BlackImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ActivatedDrag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ActivatedDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivatedDragMouseClicked(evt);
            }
        });

        ActivatedClick.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ActivatedClick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivatedClickMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("JasmineUPC", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Pointer Size ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(Fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ToleranceSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(ToleranceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ActivatedClick, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ActivatedDrag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(OriginalImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(430, 430, 430)
                    .addComponent(BlackImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(OriginalImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ActivatedDrag, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActivatedClick, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(5, 5, 5)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(ToleranceSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ToleranceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel7))
                                                .addGap(15, 15, 15)))
                                        .addGap(48, 48, 48)))))))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(315, 315, 315)
                    .addComponent(BlackImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(318, Short.MAX_VALUE)))
        );

        PanelColor.setBackground(new java.awt.Color(0, 255, 255));
        PanelColor.setToolTipText("");
        PanelColor.setMinimumSize(new java.awt.Dimension(300, 23));
        PanelColor.setOpaque(false);
        PanelColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelColorMouseClicked(evt);
            }
        });
        PanelColor.setLayout(new javax.swing.BoxLayout(PanelColor, javax.swing.BoxLayout.LINE_AXIS));

        StopAdd1.setBackground(new java.awt.Color(0, 0, 0));
        StopAdd1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StopAdd1.setForeground(new java.awt.Color(255, 255, 255));
        StopAdd1.setText("EXIT");
        StopAdd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StopAdd1MouseClicked(evt);
            }
        });

        ShowMarkedAllImageButton.setBackground(new java.awt.Color(0, 0, 0));
        ShowMarkedAllImageButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ShowMarkedAllImageButton.setForeground(new java.awt.Color(255, 255, 255));
        ShowMarkedAllImageButton.setText("Show All Mark");
        ShowMarkedAllImageButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        ShowMarkedAllImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShowMarkedAllImageButtonMouseClicked(evt);
            }
        });

        ChooserButton.setBackground(new java.awt.Color(0, 0, 0));
        ChooserButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ChooserButton.setForeground(new java.awt.Color(255, 255, 255));
        ChooserButton.setText("Choose Image");
        ChooserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChooserButtonMouseClicked(evt);
            }
        });

        UnMarkImageButton.setBackground(new java.awt.Color(0, 0, 0));
        UnMarkImageButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UnMarkImageButton.setForeground(new java.awt.Color(255, 255, 255));
        UnMarkImageButton.setText("Hide All Mark");
        UnMarkImageButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnMarkImageButtonMouseClicked(evt);
            }
        });

        Print.setBackground(new java.awt.Color(0, 0, 0));
        Print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("PRINT");
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
        });

        UndoButton.setBackground(new java.awt.Color(51, 255, 255));
        UndoButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UndoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UndoButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowMarkedAllImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UnMarkImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Print)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StopAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooserButton))
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(842, 842, 842)
                .addComponent(PanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(PanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowMarkedAllImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UnMarkImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChooserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UndoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StopAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //support for GIF, PNG, JPEG, BMP, and WBMP
    private void ChooserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChooserButtonMouseClicked
        fileChooserClicked();
    }//GEN-LAST:event_ChooserButtonMouseClicked

    private void OriginalImageLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OriginalImageLabelMouseMoved
        int x, y;
        if (!CaseMemanjang) {
            x = evt.getX() - (OriginalImageLabel.getWidth() - widthImage) / 2;
            y = evt.getY();
        } else {
            x = evt.getX();
            y = evt.getY() - (OriginalImageLabel.getHeight() - heightImage) / 2;
        }
        if (x < widthImage && y < heightImage && x >= 0 && y >= 0) {
            int PackInt = MainFrame.Image.getRGB(x, y);
            Color clr = new Color(PackInt, true);
            fields.setBackground(clr);
            fields.repaint();

            if (!IsCheckedBefore(x, y)) {
                IsFree.setIcon(new ImageIcon(Centang));
            } else {
                IsFree.setIcon(new ImageIcon(Silang));
            }
            R.setText(Integer.toString(clr.getRed()));
            G.setText(Integer.toString(clr.getGreen()));
            B.setText(Integer.toString(clr.getBlue()));
        }
        if (MainFrame.Image == null && !showhint) {
            showhint = true;
            // JOptionPane.showMessageDialog(this, "Pilihlah gambar dengan mengklik \"Choose Image\"", "Image error", JOptionPane.ERROR_MESSAGE);
        } else if (NumberOfLabel == 0 && !showhint1 && MainFrame.Image != null) {
            showhint1 = true;
            JOptionPane.showMessageDialog(this, "Klik area pada gambar untuk menandai kelompok warna tersebut.", "Image error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OriginalImageLabelMouseMoved

    private void OriginalImageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OriginalImageLabelMouseClicked
        int x, y;
        if (!CaseMemanjang) {
            x = evt.getX() - (OriginalImageLabel.getWidth() - widthImage) / 2;
            y = evt.getY();
        } else {
            x = evt.getX();
            y = evt.getY() - (OriginalImageLabel.getHeight() - heightImage) / 2;
        }

        if (NoShow != -99) {
            ColorMarkButton.elementAt(NoShow).setBackground(Color.BLACK);
            ColorMarkButton.elementAt(NoShow).setForeground(Color.WHITE);
            NoShow = -99;
        }

        if (x < widthImage && y < heightImage && x >= 0 && y >= 0
                && !IsCheckedBefore(x, y)) {
            if (NumberOfLabel < MaxLabel && !addAreaByClick) {

                ImgRepresentation.add(new ImageRepresentation());
                Print.setEnabled(true);
                int PackInt = MainFrame.Image.getRGB(x, y);
                Color clr = new Color(PackInt, true);
                color.add(clr);
                // current pack harus di inisiasi
                NoMagic = NumberOfLabel;
                MagicWand(x, y);

                ShowMarkedAllImage();
                OriginalImageLabel.repaint();

                //penting
                ContainerPanel.add(new JPanel());
                ContainerPanel.elementAt(NumberOfLabel).setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.CENTER;

                // membentuk isi yang ada dalam satu container
                c.insets = new Insets(8, 5, 8, 5);
                c.fill = GridBagConstraints.HORIZONTAL;

                c.gridy = 0;
                c.gridx = 0;
                NameLabel.add(new JLabel());
                NameLabel.elementAt(NumberOfLabel).setBackground(Color.BLACK);
                NameLabel.elementAt(NumberOfLabel).setSize(30, 200);
                NameLabel.elementAt(NumberOfLabel).setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
                NameLabel.elementAt(NumberOfLabel).setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                NameLabel.elementAt(NumberOfLabel).repaint();
                NameLabel.elementAt(NumberOfLabel).setText((NumberOfLabel + 1) + ". ");
                NameLabel.elementAt(NumberOfLabel).setCursor(new Cursor(Cursor.HAND_CURSOR));
                ContainerPanel.elementAt(NumberOfLabel).add(NameLabel.elementAt(NumberOfLabel), c);
                NameLabel.elementAt(NumberOfLabel).addMouseListener(new MouseAdapter() {
                    int No = NumberOfLabel;

                    public void mouseClicked(MouseEvent e) {
                        String Nama = JOptionPane.showInputDialog(OriginalImageLabel, "Masukkan nama jenis mineral!", (NumberOfLabel) + ". ");
                        NameLabel.elementAt(No).setText(Nama);
                        NameLabel.elementAt(No).repaint();
                        if (NameLabel.elementAt(No).getText() == null) {
                            NameLabel.elementAt(No).setText((NumberOfLabel) + ". ");
                        }
                    }

                });

                c.gridy = 0;
                c.gridx = 1;
                ColorPanel.add(new JPanel());
                ColorPanel.elementAt(NumberOfLabel).setBackground(clr);
                ColorPanel.elementAt(NumberOfLabel).repaint();
                ColorPanel.elementAt(NumberOfLabel).setPreferredSize(new Dimension(30, 30));
                ContainerPanel.elementAt(NumberOfLabel).add(ColorPanel.elementAt(NumberOfLabel), c);

                c.gridy = 0;
                c.gridx = 2;
                ColorLabel.add(new JLabel());
                float presentase = (float) ImgRepresentation.elementAt(NumberOfLabel).CurrentArea / (widthImage * heightImage) * 100;
                ColorLabel.elementAt(NumberOfLabel).setText(new DecimalFormat("##.##").format(presentase) + " %");
                ColorLabel.elementAt(NumberOfLabel).repaint();
                ContainerPanel.elementAt(NumberOfLabel).add(ColorLabel.elementAt(NumberOfLabel), c);

                c.gridy = 0;
                c.gridx = 3;
                ColorAddButton.add(new JButton("Add"));
                ContainerPanel.elementAt(NumberOfLabel).add(ColorAddButton.elementAt(NumberOfLabel), c);
                ColorAddButton.elementAt(NumberOfLabel).setBackground(Color.BLACK);
                ColorAddButton.elementAt(NumberOfLabel).setForeground(Color.WHITE);
                ColorAddButton.elementAt(NumberOfLabel).addMouseListener(new MouseAdapter() {
                    int No = NumberOfLabel;

                    public void mouseClicked(MouseEvent e) {
                        if (NoShow != -99) {
                            ColorMarkButton.elementAt(NoShow).setBackground(Color.BLACK);
                            ColorMarkButton.elementAt(NoShow).setForeground(Color.WHITE);
                            NoShow = -99;
                        }
                        if (NoAdd == No) {
                            ColorAddButton.elementAt(NoAdd).setBackground(Color.BLACK);
                            ColorAddButton.elementAt(NoAdd).setForeground(Color.WHITE);
                            NoAdd = -99;
                            SetUndoNonactive();

                            ActivatedDrag.removeAll();
                            Deactivated = resize(Deactivated, 35, 35);
                            ActivatedDrag.setIcon(new ImageIcon(Deactivated));
                            ActivatedDrag.repaint();
                            addAreaByDrag = false;
                            BlackSlider.setEnabled(false);

                            ActivatedClick.removeAll();
                            Deactivated = resize(Deactivated, 35, 35);
                            ActivatedClick.setIcon(new ImageIcon(Deactivated));
                            ActivatedClick.repaint();
                            addAreaByClick = false;
                        } else if (NoAdd == - 99) {
                            NoAdd = No;
                            ShowMarkedAllImage();
                            //ShowMarkedImageNo(No);
                            ColorAddButton.elementAt(No).setBackground(Color.WHITE);
                            ColorAddButton.elementAt(No).setForeground(Color.BLACK);
                            addAreaByClick = true;
                            addAreaByDrag = true;
                            NoMagic = NoAdd;
                            System.out.println(No);
                            BlackSlider.setEnabled(true);
                            setActiv();
                        } else {
                            // sebelumnya add masih active
                            ColorAddButton.elementAt(NoAdd).setBackground(Color.BLACK);
                            ColorAddButton.elementAt(NoAdd).setForeground(Color.WHITE);
                            NoAdd = No;
                            SetUndoNonactive();
                            ShowMarkedAllImage();
                            //ShowMarkedImageNo(No);
                            ColorAddButton.elementAt(No).setBackground(Color.WHITE);
                            ColorAddButton.elementAt(No).setForeground(Color.BLACK);
                            addAreaByClick = true;
                            addAreaByDrag = true;
                            NoMagic = NoAdd;
                            System.out.println(No);
                            BlackSlider.setEnabled(true);
                            setActiv();
                        }
                    }
                });

                c.gridy = 0;
                c.gridx = 4;
                ColorDelButton.add(new JButton("Del"));

                ColorDelButton.elementAt(NumberOfLabel).setBackground(Color.BLACK);
                ColorDelButton.elementAt(NumberOfLabel).setForeground(Color.WHITE);
                ContainerPanel.elementAt(NumberOfLabel).add(ColorDelButton.elementAt(NumberOfLabel), c);
                ColorDelButton.elementAt(NumberOfLabel).addMouseListener(new MouseAdapter() {
                    int No = NumberOfLabel;

                    public void mouseClicked(MouseEvent e) {
                        System.out.println(No);
                        ColorLabel.elementAt(No).setText(" 0.00 %");
                        Color clor = new Color(-1, true);
                        color.setElementAt(clor, No);

                        ShowOriginalImage();
                        ImgRepresentation.elementAt(No).clearMark();

                        ColorPanel.elementAt(No).setBackground(clor);
                        PanelColor.repaint();
                        ColorLabel.elementAt(No).repaint();
                        PanelColor.revalidate();
                        updateMarkedImage();
                    }
                });

                c.gridy = 0;
                c.gridx = 5;
                ColorMarkButton.add(new JButton("Show"));
                ColorMarkButton.elementAt(NumberOfLabel).setBackground(Color.BLACK);
                ColorMarkButton.elementAt(NumberOfLabel).setForeground(Color.WHITE);

                ContainerPanel.elementAt(NumberOfLabel).add(ColorMarkButton.elementAt(NumberOfLabel), c);
                ColorMarkButton.elementAt(NumberOfLabel).addMouseListener(new MouseAdapter() {

                    int No = NumberOfLabel;

                    public void mouseClicked(MouseEvent e) {
                        //System.out.println("kosong wo"+ColorLabel.elementAt(No).getText().substring(1, 5));
                        if (ColorLabel.elementAt(No).getText().substring(1, 5).equals("0.00")){
                            //System.out.println("kosong woi "+ColorLabel.elementAt(No).getText().substring(0, 3));
                        } else if (NoShow == -99) {
                            NoShow = No;
                            ShowMarkedImageNo(No);
                            ColorMarkButton.elementAt(No).setBackground(Color.WHITE);
                            ColorMarkButton.elementAt(No).setForeground(Color.BLACK);
                        } else if (NoShow == No) {
                            ColorMarkButton.elementAt(No).setBackground(Color.BLACK);
                            ColorMarkButton.elementAt(No).setForeground(Color.WHITE);
                            NoShow = -99;
                            ShowOriginalImage();
                        } else {
                            ColorMarkButton.elementAt(NoShow).setBackground(Color.BLACK);
                            ColorMarkButton.elementAt(NoShow).setForeground(Color.WHITE);
                            NoShow = No;
                            ColorMarkButton.elementAt(No).setBackground(Color.WHITE);
                            ColorMarkButton.elementAt(No).setForeground(Color.BLACK);
                            ShowMarkedImageNo(No);
                        }
                    }
                });

                ContainerPanel.elementAt(NumberOfLabel).setOpaque(false);
                ContainerPanel.elementAt(NumberOfLabel).setPreferredSize(new Dimension(400, 30));
                PanelColor.add(ContainerPanel.elementAt(NumberOfLabel));
                PanelColor.setOpaque(false);
                PanelColor.repaint();
                PanelColor.revalidate();

                NumberOfLabel++;
            } else {
                if (NoAdd != -99 && !IsCheckedBefore(x, y)) {
                    // SImapan state gambar
                    SetUndoActive();
                    ImgRepresentation.elementAt(NoAdd).SimpanCurrentState();

                    int xx = evt.getX() - (OriginalImageLabel.getWidth() - widthImage) / 2;
                    int yy = evt.getY();

                    // jika ingin mengganti warna yg sebelumnya di delete
                    // kemungkinan error/direstart dari nol jika warnanya juga -11
                    if (ImgRepresentation.elementAt(NoAdd).CurrentPackInt == -11) {
                        int PackInt = MainFrame.Image.getRGB(x, y);
                        Color clr = new Color(PackInt, true);
                        color.setElementAt(clr, NoMagic);
                        ColorPanel.elementAt(NoMagic).setBackground(clr);
                        PanelColor.repaint();
                        ColorLabel.elementAt(NoMagic).repaint();
                        PanelColor.revalidate();
                    }
                    ImgRepresentation.elementAt(NoAdd).CurrentPackInt = MainFrame.Image.getRGB(xx, yy);
                    MagicWand(xx, yy);

                    float presentase = (float) ImgRepresentation.elementAt(NoAdd).CurrentArea / (widthImage * heightImage) * 100;
                    ColorLabel.elementAt(NoAdd).setText(new DecimalFormat("##.##").format(presentase) + " %");

                    OriginalImageLabel.repaint();
                    ShowMarkedAllImage();

                } else if (NumberOfLabel >= MaxLabel) {
                    JOptionPane.showMessageDialog(this, "Maaf! Anda telah mencapai jumlah warna\nmaksimal yang bisa dianalisa.", "Add error", JOptionPane.ERROR_MESSAGE);

                }
            }

        } else if (IsCheckedBefore(x, y)) {
            JOptionPane.showMessageDialog(this, "Maaf! Bagian warna ini telah ditandai. Klik \"Show All Area\"\n untuk mengetahui semua area yang telah di tandai.", "Add error", JOptionPane.ERROR_MESSAGE);
        } else if (MainFrame.Image == null) {
            JOptionPane.showMessageDialog(this, "Pilihlah gambar dengan mengklik \"Choose Image\"", "Image error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_OriginalImageLabelMouseClicked

    private Color newColor = new Color(255, 255, 255);
    private float presentaseAwal = 0;
    private void OriginalImageLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OriginalImageLabelMouseDragged
        ShowMarkedAllImage();

        if (addAreaByDrag) {
            if (!draged) {
                SetUndoActive();
                ImgRepresentation.elementAt(NoAdd).SimpanCurrentState();
            }
            draged = true;

            int x, y;
            if (!CaseMemanjang) {
                x = evt.getX() - (OriginalImageLabel.getWidth() - widthImage) / 2;
                y = evt.getY();
            } else {
                x = evt.getX();
                y = evt.getY() - (OriginalImageLabel.getHeight() - heightImage) / 2;
            }
            int jarakketengah = BlackSlider.getValue() / 2;
            for (int i = x - jarakketengah; i <= x + jarakketengah; i++) {
                for (int j = y - jarakketengah; j <= y + jarakketengah; j++) {
                    if (i < widthImage && j < heightImage && i >= 0 && j >= 0) {
                        if (x < widthImage && y < heightImage && x >= 0 && y >= 0
                                && !IsCheckedBefore(i, j)) {
                            ImgRepresentation.elementAt(NoMagic).Pixel[i][j].Checked = true;
                            ImgRepresentation.elementAt(NoMagic).CurrentImage.setRGB(i, j, newColor.getRGB());
                            MainFrame.MarkedAllImage.setRGB(i, j, newColor.getRGB());

                            ImgRepresentation.elementAt(NoMagic).CurrentArea++;

                            float presentase = (float) ImgRepresentation.elementAt(NoMagic).CurrentArea / (widthImage * heightImage) * 100;
                            ColorLabel.elementAt(NoMagic).setText(new DecimalFormat("##.##").format(presentase) + " %");
                        }
                    }
                }
            }

            // ShowMarkedAllImage();
        }
    }//GEN-LAST:event_OriginalImageLabelMouseDragged

    private void ToleranceSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ToleranceSliderStateChanged
        tolerance = ToleranceSlider.getValue();
        ToleranceLabel.setText(Integer.toString(ToleranceSlider.getValue()));
    }//GEN-LAST:event_ToleranceSliderStateChanged

    private void StopAdd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StopAdd1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_StopAdd1MouseClicked

    private void ShowMarkedAllImageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShowMarkedAllImageButtonMouseClicked
        if (ShowMarkedAllImageButton.isEnabled()) {
            ShowMarkedAllImage();
            UnMarkImageButton.setEnabled(true);
            ShowMarkedAllImageButton.setEnabled(false);
        }
    }//GEN-LAST:event_ShowMarkedAllImageButtonMouseClicked

    private void UnMarkImageButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnMarkImageButtonMouseClicked
        if (UnMarkImageButton.isEnabled()) {
            ShowOriginalImage();
            UnMarkImageButton.setEnabled(false);
            ShowMarkedAllImageButton.setEnabled(true);
        }
    }//GEN-LAST:event_UnMarkImageButtonMouseClicked

    private void BlackSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_BlackSliderStateChanged
        setSizeBlack(BlackSlider.getValue());
    }//GEN-LAST:event_BlackSliderStateChanged

    private void ActivatedDragMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivatedDragMouseClicked
        //System.out.println(addAreaByDrag);

        if (addAreaByDrag) {
            ActivatedDrag.removeAll();
            Deactivated = resize(Deactivated, 35, 35);
            ActivatedDrag.setIcon(new ImageIcon(Deactivated));
            ActivatedDrag.repaint();

            if (!addAreaByClick) {
                ColorAddButton.elementAt(NoAdd).setBackground(Color.BLACK);
                ColorAddButton.elementAt(NoAdd).setForeground(Color.WHITE);
                // Hapus history image
                ImgRepresentation.elementAt(NoAdd).UndoImage.clear();
                SetUndoNonactive();
                NoAdd = -99;

            }
            addAreaByDrag = false;
            BlackSlider.setEnabled(false);
        } else if (addAreaByClick) {
            addAreaByDrag = true;
            BlackSlider.setEnabled(true);

            ActivatedDrag.removeAll();
            Activated = resize(Activated, 35, 35);
            ActivatedDrag.setIcon(new ImageIcon(Activated));
            ActivatedDrag.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Klik \"add\" terlebih dahulu pada kelompok \n"
                    + "warna tertentu untuk menambah luas suatu warna.\n"
                    + "Jika berwarna hijau berarti Anda bisa menambah \n"
                    + "area dengan mendrag pointer pada gambar", "Hint", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ActivatedDragMouseClicked

    private void ActivatedClickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivatedClickMouseClicked
        System.out.println("click " + addAreaByClick);
        if (addAreaByClick) {
            ActivatedClick.removeAll();
            Deactivated = resize(Deactivated, 35, 35);
            ActivatedClick.setIcon(new ImageIcon(Deactivated));
            ActivatedClick.repaint();

            if (!addAreaByDrag) {
                ColorAddButton.elementAt(NoAdd).setBackground(Color.BLACK);
                ColorAddButton.elementAt(NoAdd).setForeground(Color.WHITE);
                // Hapus history image
                ImgRepresentation.elementAt(NoAdd).UndoImage.clear();
                SetUndoNonactive();
                NoAdd = -99;
            }
            addAreaByClick = false;
        } else if (addAreaByDrag) {
            addAreaByClick = true;

            ActivatedClick.removeAll();
            Activated = resize(Activated, 35, 35);
            ActivatedClick.setIcon(new ImageIcon(Activated));
            ActivatedClick.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Klik \"add\" terlebih dahulu pada kelompok \n"
                    + "warna tertentu untuk menambah luas suatu warna.\n"
                    + "Jika berwarna hijau berarti Anda bisa menambah \n"
                    + "area dengan mengklik pada gambar", "Hint", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_ActivatedClickMouseClicked

    private void PanelColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelColorMouseClicked
        JOptionPane.showMessageDialog(this, "Klik area gambar pada kolom Image untuk menambahkan kelompok warna baru.\n"
                + "Klik \"add\" untuk menambahkan warna pada kelompok warna tertentu.\n"
                + "Klik \"show\" untuk menunjukkan area yang termasuk dalam kelompok warna tertentu.\n"
                + "Klik \"del\" untuk menghapus kelompok warna tertentu.", "Hint", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PanelColorMouseClicked

    private void ToleranceSliderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToleranceSliderMouseMoved
        if (!showhint3) {
            showhint3 = true;
            JOptionPane.showMessageDialog(this, "Gunakan slider untuk mengatur besar toleransi RGB.", "Hint", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ToleranceSliderMouseMoved

    private void BlackSliderMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BlackSliderMouseMoved
        if (!showhint2) {
            showhint2 = true;
            JOptionPane.showMessageDialog(this, "Gunakan slider untuk mengatur besar ukuran pointer\n"
                    + "yang akan digunakan untuk menambah area suatu \n"
                    + "warna tertentu dengan mendrag pointer pada gambar.", "Hint", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BlackSliderMouseMoved

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseClicked
        if (Print.isEnabled()) {
            String File = JOptionPane.showInputDialog(OriginalImageLabel, "Masukkan nama file!") + ".txt";
            File file = new File(File);
            if (!file.exists() && !File.isEmpty()) {
                try {
                    JOptionPane.showMessageDialog(this, "Data berhasil dituliskan pada file " + File + ".", "Print", JOptionPane.INFORMATION_MESSAGE);
                    PrintData(File);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ProcessingPanel.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ProcessingPanel.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ProcessingPanel.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            } else if (File.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Maaf! Nama file harus diisi.", "Error", JOptionPane.INFORMATION_MESSAGE);

            } else {
                Object[] options = {"Yes", "Cancel"};
                int aa = JOptionPane.showOptionDialog(this, "Maaf! Nama file sama. Tulis ulang file?", "Warning",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]);
                System.out.println(aa + "  csdc");
                if (aa == 0) {
                    try {
                        JOptionPane.showMessageDialog(this, "File " + File + " berhasil ditulis ulang.", "Print", JOptionPane.INFORMATION_MESSAGE);
                        PrintData(File);

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ProcessingPanel.class
                                .getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(ProcessingPanel.class
                                .getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ProcessingPanel.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_PrintMouseClicked

    private void UndoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UndoButtonMouseClicked
        if (IsUndoActive) {
            System.out.println("active");
            ImgRepresentation.elementAt(NoAdd).Undo();
            UpdateSizeAfterUndo();
            SetUndoNonactive();
            
            updateMarkedImage();
            ShowMarkedAllImage();
            SetUndoActive();
            if (ImgRepresentation.elementAt(NoAdd).UndoImage.size() == 0) {
                SetUndoNonactive();
            }
        } else {
            System.out.println("nonactive");
        }
    }//GEN-LAST:event_UndoButtonMouseClicked

    private void OriginalImageLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OriginalImageLabelMouseReleased
        if (draged) {
            draged = false;
            ShowMarkedAllImage();
        }
    }//GEN-LAST:event_OriginalImageLabelMouseReleased

    public void UpdateSizeAfterUndo() {
        float presentase = (float) ImgRepresentation.elementAt(NoMagic).CurrentArea / (widthImage * heightImage) * 100;
        ColorLabel.elementAt(NoMagic).setText(new DecimalFormat("##.##").format(presentase) + " %");
    }

    public static int[][] cloneArray(int[][] src) {
        int length = src.length;
        int[][] target = new int[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }

    public void PrintData(String FileName) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        PrintWriter writer = new PrintWriter(FileName, "UTF-8");
        int IndxLastSlash = pathImage.lastIndexOf("\\");
        writer.println("Nama File gambar = " + pathImage.substring(IndxLastSlash + 1));
        for (int i = 0; i < NumberOfLabel; i++) {
            if (ImgRepresentation.elementAt(i).CurrentArea > 0) {
                TotalPersen += (float) ImgRepresentation.elementAt(i).CurrentArea / (widthImage * heightImage) * 100;
                writer.println(NameLabel.elementAt(i).getText() + "  " + ColorLabel.elementAt(i).getText());
            }
        }
        writer.println("Total persentase = " + new DecimalFormat("##.##").format(TotalPersen) + " %");
        TotalPersen = 0;

        writer.close();
    }

    boolean IsCheckedBefore(int xx, int yy) {
        int i = 0;
        while (i < ImgRepresentation.size()) {
            if (ImgRepresentation.elementAt(i).IsChecked(xx, yy)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void SetUndoActive() {
        UndoButton.setIcon(new ImageIcon(UndoActive));
        IsUndoActive = true;
    }

    public void SetUndoNonactive() {
        UndoButton.setIcon(new ImageIcon(UndoNonactive));
        IsUndoActive = false;
    }

    public void MagicWand(int lebar, int tinggi) {
        ImgRepresentation.elementAt(NoMagic).CurrentPackInt
                = ImgRepresentation.elementAt(NoMagic).CurrentImage.getRGB(lebar, tinggi);
        ImagePixel Pixel = new ImagePixel(lebar, tinggi);
        myStack.add(Pixel);
        while (!myStack.empty()) {
            Pixel = myStack.pop();
            MagicTool(Pixel.lebar, Pixel.tinggi);
        }
    }

    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    public void MagicTool(int lebar, int tinggi) {
        OriginalImageLabel.repaint();
        if (tinggi >= 0 && tinggi < heightImage
                && lebar >= 0 && lebar < widthImage && !IsCheckedBefore(lebar, tinggi)
                && IsRelated(lebar, tinggi)) {

            ImgRepresentation.elementAt(NoMagic).CurrentArea++;

            ImgRepresentation.elementAt(NoMagic).CurrentImage.setRGB(lebar, tinggi, newColor.getRGB());
            MainFrame.MarkedAllImage.setRGB(lebar, tinggi, newColor.getRGB());

            ImgRepresentation.elementAt(NoMagic).Pixel[lebar][tinggi].Checked = true;

            if (tinggi >= 0 && tinggi < heightImage
                    && lebar + 1 >= 0 && lebar + 1 < widthImage && !ImgRepresentation.elementAt(NoMagic).Pixel[lebar + 1][tinggi].Checked) {
                myStack.add(new ImagePixel(lebar + 1, tinggi));
            }
            if (tinggi >= 0 && tinggi < heightImage
                    && lebar - 1 >= 0 && lebar - 1 < widthImage && !ImgRepresentation.elementAt(NoMagic).Pixel[lebar - 1][tinggi].Checked) {
                myStack.add(new ImagePixel(lebar - 1, tinggi));
            }
            if (tinggi + 1 >= 0 && tinggi + 1 < heightImage
                    && lebar >= 0 && lebar < widthImage && !ImgRepresentation.elementAt(NoMagic).Pixel[lebar][tinggi + 1].Checked) {
                myStack.add(new ImagePixel(lebar, tinggi + 1));
            }
            if (tinggi - 1 >= 0 && tinggi - 1 < heightImage
                    && lebar >= 0 && lebar < widthImage && !ImgRepresentation.elementAt(NoMagic).Pixel[lebar][tinggi - 1].Checked) {
                myStack.add(new ImagePixel(lebar, tinggi - 1));
            }

        }
    }

    public boolean IsRelated(int x, int y) {
        Color colorAcuan = new Color(ImgRepresentation.elementAt(NoMagic).CurrentPackInt, true);
        Color colorPixel = new Color(MainFrame.Image.getRGB(x, y), true);
        if (Math.abs(colorAcuan.getRed() - colorPixel.getRed()) <= tolerance
                && Math.abs(colorAcuan.getGreen() - colorPixel.getGreen()) <= tolerance
                && Math.abs(colorAcuan.getBlue() - colorPixel.getBlue()) <= tolerance) {
            // System.out.println("true  "+Math.abs(+colorAcuan.getRed()-colorPixel.getRed()));
            return true;
        } else {
            return false;
        }
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public void ShowOriginalImage() {
        UnMarkImageButton.setEnabled(false);
        ShowMarkedAllImageButton.setEnabled(true);
        OriginalImageLabel.removeAll();
        OriginalImageLabel.setIcon(new ImageIcon(MainFrame.Image));
        OriginalImageLabel.repaint();
    }

    public void ShowMarkedImageNo(int No) {
        ShowMarkedAllImageButton.setEnabled(true);
        OriginalImageLabel.removeAll();
        OriginalImageLabel.setIcon(new ImageIcon(ImgRepresentation.elementAt(No).CurrentImage));
        OriginalImageLabel.repaint();
        UnMarkImageButton.setEnabled(true);
    }

    public void ShowMarkedAllImage() {
        OriginalImageLabel.removeAll();

        ShowMarkedAllImageButton.setEnabled(false);
        UnMarkImageButton.setEnabled(true);

        OriginalImageLabel.setIcon(new ImageIcon(MainFrame.MarkedAllImage));
        OriginalImageLabel.repaint();

    }

    public void updateMarkedImage() {
        OriginalImageLabel.removeAll();

        try {
            MainFrame.MarkedAllImage = ImageIO.read(new File(pathImage));
        } catch (IOException ex) {
            Logger.getLogger(ProcessingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        MainFrame.MarkedAllImage = resize(MainFrame.MarkedAllImage, widthImage, heightImage);
        
        ShowMarkedAllImageButton.setEnabled(false);
        float h, w;
        if (!CaseMemanjang) {
            h = OriginalImageLabel.getHeight();
            w = (float) OriginalImageLabel.getHeight() / MainFrame.Image.getHeight() * MainFrame.Image.getWidth();
        } else {
            h = (float) OriginalImageLabel.getWidth() / MainFrame.Image.getWidth() * MainFrame.Image.getHeight();
            w = OriginalImageLabel.getWidth();
        }
        UnMarkImageButton.setEnabled(true);
        try {
            MainFrame.MarkedAllImage = ImageIO.read(new File(pathImage));
            MainFrame.MarkedAllImage = resize(MainFrame.MarkedAllImage, (int) w, (int) h);
            for (int i = 0; i < heightImage; i++) {
                for (int j = 0; j < widthImage; j++) {
                    if (IsCheckedBefore(j, i)) {
                        Color newColor = new Color(255, 255, 255);
                        MainFrame.MarkedAllImage.setRGB(j, i, newColor.getRGB());

                    }
                }
            }
            OriginalImageLabel.setIcon(new ImageIcon(MainFrame.MarkedAllImage));
            OriginalImageLabel.repaint();

        } catch (IOException ex) {
            Logger.getLogger(ProcessingPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSizeBlack(int size) {

        BlackImage.removeAll();
        if (size > 0) {
            Black = resize(Black, size, size);
            BlackImage.setIcon(new ImageIcon(Black));
        }
        BlackImage.repaint();
    }

    public void setActiv() {
        ActivatedDrag.removeAll();
        Activated = resize(Activated, 35, 35);
        ActivatedDrag.setIcon(new ImageIcon(Activated));
        ActivatedDrag.repaint();
        ActivatedClick.setIcon(new ImageIcon(Activated));
        ActivatedClick.repaint();
    }

    private void fileChooserClicked() {
        FileDialog fd = new FileDialog(new Frame(), "Choose an image file", FileDialog.LOAD);
        fd.setVisible(true);
        File f = new File(fd.getDirectory() + fd.getFile());

        try {
            Normalized();
            pathImage = fd.getDirectory() + fd.getFile();
            MainFrame.Image = ImageIO.read(new File(pathImage));
            MainFrame.MarkedAllImage = ImageIO.read(new File(pathImage));

            float w = 0, h = 0;
            float scaleLabel = (float) OriginalImageLabel.getWidth() / OriginalImageLabel.getHeight();
            float scaleImage = (float) MainFrame.Image.getWidth() / MainFrame.Image.getHeight();
            ToleranceSlider.setEnabled(true);
            setSizeBlack(BlackSlider.getValue());
            ToleranceLabel.setText(Integer.toString(ToleranceSlider.getValue()));
            ShowMarkedAllImageButton.setEnabled(true);
            if (scaleLabel > scaleImage) {

                // di sesuaikan ukurannya
                h = OriginalImageLabel.getHeight();
                w = (float) OriginalImageLabel.getHeight() / MainFrame.Image.getHeight() * MainFrame.Image.getWidth();
                MainFrame.Image = resize(MainFrame.Image, (int) w, (int) h);
                MainFrame.MarkedAllImage = resize(MainFrame.MarkedAllImage, (int) w, (int) h);
                ShowOriginalImage();
                widthImage = (int) w;
                heightImage = (int) h;
                // representasi aray pada image berbanding terbalik dengan koordinat label
                // membentuk representasi pixel

            } else {
                CaseMemanjang = true;
                w = OriginalImageLabel.getWidth();
                h = (float) OriginalImageLabel.getWidth() / MainFrame.Image.getWidth() * MainFrame.Image.getHeight();
                MainFrame.Image = resize(MainFrame.Image, (int) w, (int) h);
                MainFrame.MarkedAllImage = resize(MainFrame.MarkedAllImage, (int) w, (int) h);
                ShowOriginalImage();
                System.out.println(w + "  I mage error  " + h);
                widthImage = (int) w;
                heightImage = (int) h;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Pilihlah gambar yang valid!", "Information", JOptionPane.ERROR_MESSAGE);
            System.out.println("Image error");
        }

    }

    public void setDeactiv() {
        ActivatedDrag.removeAll();
        Deactivated = resize(Deactivated, 35, 35);
        ActivatedDrag.setIcon(new ImageIcon(Deactivated));
        ActivatedDrag.repaint();
        ActivatedClick.setIcon(new ImageIcon(Deactivated));
        ActivatedClick.repaint();
    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    public void Normalized() {
        ColorLabel.clear();
        ColorAddButton.clear();
        ColorMarkButton.clear();
        ColorDelButton.clear();
        ColorPanel.clear();
        ContainerPanel.clear();
        color.clear();
        MarkedPixel.clear();
        ImgRepresentation.clear();
        showhint = true;
        showhint1 = true;
        showhint2 = true;
        showhint3 = true;
        draged = false;
        Print.setEnabled(false);
        addAreaByClick = false;
        addAreaByDrag = false;
        NoAdd = -99;
        NoMagic = 0;
        CaseMemanjang = false;
        NumberOfLabel = 0;
        TotalPersen = 0;
        PanelColor.removeAll();
        PanelColor.repaint();
        PanelColor.revalidate();
        BlackSlider.setEnabled(false);
        ToleranceSlider.setEnabled(false);
        UnMarkImageButton.setEnabled(false);
        ShowMarkedAllImageButton.setEnabled(false);
        IsUndoActive = false;
        SetUndoNonactive();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActivatedClick;
    private javax.swing.JLabel ActivatedDrag;
    private javax.swing.JTextField B;
    private javax.swing.JLabel BlackImage;
    private javax.swing.JLabel BlackImage1;
    private javax.swing.JSlider BlackSlider;
    private javax.swing.JButton ChooserButton;
    private javax.swing.JPanel Fields;
    private javax.swing.JTextField G;
    private javax.swing.JLabel IsFree;
    public static javax.swing.JLabel OriginalImageLabel;
    private javax.swing.JPanel PanelColor;
    private javax.swing.JButton Print;
    private javax.swing.JTextField R;
    private javax.swing.JButton ShowMarkedAllImageButton;
    private javax.swing.JButton StopAdd1;
    private javax.swing.JLabel ToleranceLabel;
    private javax.swing.JSlider ToleranceSlider;
    private javax.swing.JButton UnMarkImageButton;
    private javax.swing.JLabel UndoButton;
    private javax.swing.JPanel fields;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
