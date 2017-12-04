package ru.ptahi.aetexperiment;

import eyetrackerconnecter.Fixation;
import eyetrackerconnecter.IViewX;
import eyetrackerconnecter.UpdateDeviceEvent;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Ellipse;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.netbeans.api.project.Project;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Exceptions;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;
import processing.core.PApplet;
import processing.core.PImage;
import ru.ptahi.iconmanager.IconManager;
import ru.ptahi.cfe.stumile.StimuleList;



/**
 * Top component which displays something.
 */
//@ConvertAsProperties(
//        dtd = "-//ru.ptahi.aetexperiment//RunExperiment//EN",
//        autostore = false
//)
@TopComponent.Description(
        preferredID = "RunExperimentTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        //        persistenceType = TopComponent.PERSISTENCE_ALWAYS
        persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED
)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "ru.ptahi.aetexperiment.RunExperimentTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
//@TopComponent.OpenActionRegistration(
//        displayName = "#CTL_RunExperimentAction",
//        preferredID = "RunExperimentTopComponent"
//)
@Messages({
    "CTL_RunExperimentAction=RunExperiment",
    "CTL_RunExperimentTopComponent=RunExperiment Window",
    "HINT_RunExperimentTopComponent=This is a RunExperiment window"
})

class MyPA extends PApplet{
    
    public float mColor;
    int mx;
    int my;
    String prj_path;
    
    PImage d, c, b, a, e;
    PImage[] im=new PImage[4];
    float t,y;
    float[] num=new float[5];
    int i;
    int time;
    IViewX dev;
    
    public void setEyeTracker(IViewX dev){
        this.dev = dev;
    }
    
        
    @Override
    public void setup() {
  
        size(1920, 950);
        prj_path = "D:/OrlovPA/testshare/E/OrlovPA/soft/GazeInteractiveComix/";
        im[1] = loadImage(prj_path+"data/p2.jpg");
        im[0] = loadImage(prj_path+"data/p1.jpg");
        im[2] = loadImage(prj_path+"data/p3.jpg"); 
        im[3] = loadImage(prj_path+"data/start.jpg"); 
        b = loadImage(prj_path+"data/11.png");
        a = loadImage(prj_path+"data/12.png");
        c = loadImage(prj_path+"data/13.png");
        d = loadImage(prj_path+"data/121.png");
        e = loadImage(prj_path+"data/35.png");
        
        t = 0;
        y = 0;
        i = 3;

        num[0] = 0;
        num[2] = 0;
        num[1] = 0;
        num[3] = 0;
        num[4]=0;
   
    }
    
        //@Override
    public void draw00() {
        tint(255, 255);
        image(im[i], 0, 0);
        if (delay()==true){
        if (i == 1) {
            tint(255, 255);
            image(im[i], 0, 0);
           
        }

        if (i == 0) {

            tint(255, 255);
            image(im[i], 0, 0);
           
        }

        if (i == 2) {
            tint(255, 255);
            image(im[i], 0, 0);
             

        }
        if (i == 3) {

            tint(255, 255);
            image(im[i], 0, 0);

        }
        

    }
        else {        
        num[0] = 0;
        num[2] = 0;
        num[1] = 0;
        num[3] = 0;
        num[4]=0;}
    }
    
    
    //@Override
    public void draw0() {
        tint(255, 255);
        image(im[i], 0, 0);
        if (delay()==true){
        if (i == 1) {
            tint(255, 255);
            image(im[i], 0, 0);
            if (my <= 435) {
                tint(255, sight11(5, 0));
                image(a, 0, 0);
                check(2, c);
                check(1, d);
                check(3, b);
                //println("f1");
            } else {
                tint(255, sight0(5, 0));
                image(a, 0, 0);

                if ((my > 435) && (my <= 685)) {
                    if (mx <= 1050) {
//                        println("f2");
                        tint(255, sight11(5, 1));
                        image(d, 0, 0);
                        check(2, c);
                        check(3, b);
                    } else {
//                        println("f3");
                        tint(255, sight0(5, 1));
                        image(d, 0, 0);
                        tint(255, sight11(5, 2));
                        image(c, 0, 0);
                        check(3, b);
                    }
                } else {
//                    println("f4");
                    tint(255, sight0(5, 1));
                    image(d, 0, 0);
                    tint(255, sight0(5, 2));
                    image(c, 0, 0);

                    if (my > 685) {
                        tint(255, sight11(5, 3));
                        image(b, 0, 0);
                    } else {
                        tint(255, sight0(2, 3));
                        image(b, 0, 0);
                    }
                }
            }

        }

        if (i == 0) {

            tint(255, 255);
            image(im[i], 0, 0);
            if  (my <= 430){
                
                tint(255, sight11(5, 0));

                image(b, 0, 0);
                if (num[1] > 0) {
                    // == check a
                    tint(255, sight02(5, 1));
                    image(a, 0, 0);
                }
                check(3, d);
                check(2, c);
            } else {

                tint(255, sight0(5, 0));

                image(b, 0, 0);

                if ((my > 430) && (my <= 690)) {
                    tint(255, sight11(5, 3));
                    image(d, 0, 0);
                    //  println("frame2"); 
                    tint(255, sight12(5, 1));
                    image(a, 0, 0);
                    check(2, c);
                } else {

                    tint(255, sight0(5, 3));
                    image(d, 0, 0);

                    tint(255, sight02(5, 1));
                    image(a, 0, 0);
                    if (my > 690) {
                        tint(255, sight11(5, 2));
                        image(c, 0, 0);
                    } else {
                        tint(255, sight0(5, 2));
                        image(c, 0, 0);
                    }

                }
            }
        }

        if (i == 2) {
            tint(255, 255);
            image(im[i], 0, 0);
              if (my<430){
           if (mx<=958){
             tint(255, sight11(5, 0)); 
             image(a, 0, 0);
             check(1,b);
             check(2,c);
             check(3,d);
             check(4,e);
           }
          else {tint(255, sight11(5, 1)); 
             image(b, 0, 0);
             check(0,a);
             check(2,c);
             check(3,d);
             check(4,e);
             
           }
           
     } 
     
     
    else {
      tint(255, sight0(5, 0)); image(a, 0, 0);
      tint(255, sight0(5, 1)); image(b, 0, 0);
      
      if((my>430)&&(my<=709)){
        if (mx<=958){ tint(255, sight11(5, 0)); 
             image(a, 0, 0);
             tint(255, sight0(5, 1)); image(b, 0, 0);
          
             check(2,c);
             check(3,d);
             check(4,e);
        } 
        else {  tint(255, sight0(5, 0)); image(a, 0, 0);
            tint(255, sight11(5, 1)); 
             image(b, 0, 0);
             
           //  check(0,a);
             check(2,c);
             check(3,d);
             check(4,e);
                }
        }
      else {
        tint(255, sight0(5,3)); image(d, 0, 0);
       tint(255, sight0(5, 2)); image(c, 0, 0);
      
     if (my>709) {
      tint(255, sight11(5, 4)); image(e, 0, 0);
    }
     else {  tint(255, sight0(2, 4)); image(e, 0, 0);}
}
  }

        }
        if (i == 3) {

            tint(255, 255);
            image(im[i], 0, 0);

        }
        
//        fill(200,50,50);
//        ellipse(mx, my-100, 10, 10);
//        noStroke();
//        noFill();
    }
        else {        
        num[0] = 0;
        num[2] = 0;
        num[1] = 0;
        num[3] = 0;
        num[4]=0;}
    }
    
  public void draw() { 

    print(frameRate + "\n");
 tint(255, 255);
        image(im[i], 0, 0);
        if (delay()==true){
        if (i == 1) {
            tint(255, 255);
            image(im[i], 0, 0);
            if (my <= 435) {
                tint(255, sight11(5, 0));
                image(a, 0, 0);
                check(2, c);
                check(1, d);
                check(3, b);
                //println("f1");
            } else {
                tint(255, sight0(5, 0));
                image(a, 0, 0);

                if ((my > 435) && (my <= 685)) {
                    if (mx <= 1050) {
//                        println("f2");
                        tint(255, sight11(5, 1));
                        image(d, 0, 0);
                        check(2, c);
                        check(3, b);
                    } else {
//                        println("f3");
                        tint(255, sight0(5, 1));
                        image(d, 0, 0);
                        tint(255, sight11(5, 2));
                        image(c, 0, 0);
                        check(3, b);
                    }
                } else {
//                    println("f4");
                    tint(255, sight0(5, 1));
                    image(d, 0, 0);
                    tint(255, sight0(5, 2));
                    image(c, 0, 0);

                    if (my > 685) {
                        tint(255, sight11(5, 3));
                        image(b, 0, 0);
                    } else {
                        tint(255, sight0(2, 3));
                        image(b, 0, 0);
                    }
                }
            }

        }

        if (i == 0) {

            tint(255, 255);
            image(im[i], 0, 0);
            if  (my <= 430){
                
                tint(255, sight11(5, 0));

                image(b, 0, 0);
                if (num[1] > 0) {
                    // == check a
                    tint(255, sight02(5, 1));
                    image(a, 0, 0);
                }
                check(3, d);
                check(2, c);
            } else {

                tint(255, sight0(5, 0));

                image(b, 0, 0);

                if ((my > 430) && (my <= 690)) {
                    tint(255, sight11(5, 3));
                    image(d, 0, 0);
                    //  println("frame2"); 
                    tint(255, sight12(5, 1));
                    image(a, 0, 0);
                    check(2, c);
                } else {

                    tint(255, sight0(5, 3));
                    image(d, 0, 0);

                    tint(255, sight02(5, 1));
                    image(a, 0, 0);
                    if (my > 690) {
                        tint(255, sight11(5, 2));
                        image(c, 0, 0);
                    } else {
                        tint(255, sight0(5, 2));
                        image(c, 0, 0);
                    }

                }
            }
        }
//KFGDG
        if (i == 2) {
          //  tint(255, 255);
          //  image(im[i], 0, 0);
              if (my<430){
            
           if (mx<=958){
             
             tint(255, sight11(5, 0)); 
             image(a, 0, 0);
             tint(255, sight0(5, 1)); image(b, 0, 0);
          
             check(2,c);
             check(3,d);
             check(4,e);
            
           }
          else {
            tint(255, sight0(5, 0)); image(a, 0, 0);
            tint(255, sight11(5, 1)); 
             image(b, 0, 0);
             
           //  check(0,a);
             check(2,c);
             check(3,d);
             check(4,e);
         
             
           }
           
     } 
     
     
    else {
      tint(255, sight0(5, 0)); image(a, 0, 0);
      tint(255, sight0(5, 1)); image(b, 0, 0);
      
      if((my>430)&&(my<=709)){
        if (mx<=958){ 
        tint(255, sight11(5, 2)); 
        image(c, 0, 0); 
        check(3,d);
        check(4,e);
     
    
        } 
        else { tint(255, sight0(5, 2)); image(c, 0, 0);
        tint(255, sight11(5, 3)); 
          image(d, 0, 0); 
          check(4,e);
 
                }
        }
      else {
        tint(255, sight0(5,3)); image(d, 0, 0);
       tint(255, sight0(5, 2)); image(c, 0, 0);
      
     if (my>709) {
      tint(255, sight11(5, 4)); image(e, 0, 0);
    }
     else {  tint(255, sight0(2, 4)); image(e, 0, 0);}
}
  }

        }
        if (i == 3) {

            tint(255, 255);
            image(im[i], 0, 0);

        }
        
//        fill(200,50,50);
//        ellipse(mx, my-100, 10, 10);
//        noStroke();
//        noFill();
    }
        else {        
        num[0] = 0;
        num[2] = 0;
        num[1] = 0;
        num[3] = 0;
        num[4]=0;}
  
  }
  
    @Override
    public void keyPressed() {
     //   time = millis();
        time =0;
        if (key==' '){
        if (i < 3) {
            i++;
        } else {
            i = 0;
        }
        if (i == 0) {
            a = loadImage(prj_path+"data/12.png");
            b = loadImage(prj_path+"data/11.png");
            c = loadImage(prj_path+"data/13.png");
            d = loadImage(prj_path+"data/121.png");
        }
        if (i == 1) {
            b = loadImage(prj_path+"data/24.png");
            a = loadImage(prj_path+"data/21.png");
            d = loadImage(prj_path+"data/22.png");
            c = loadImage(prj_path+"data/23.png");
        }  // b3 a0 c2 d1
        if(i==2)   {
            a = loadImage(prj_path+"data/31.png");
            b = loadImage(prj_path+"data/32.png");
            c = loadImage(prj_path+"data/33.png"); 
            d = loadImage(prj_path+"data/34.png");
            e=loadImage(prj_path+"data/35.png");}
        dev.sendNextTrial();
  // b3 a0 c2 d1
       }
    }

    boolean delay(){
      time++;
      if (time > 40)     
     {
     
   // time = millis();
    return true;
  }
  else return false;
    }
    
    float sight1(int step, int a) {
        if (num[a] < 255) {
            num[a] += step / 2;
        }
        if (exp(num[a] / 35) > 255) {
            return 255;
        } else {
            return exp(num[a] / 35);
        }
    }

    float sight11(int step, int a) {
        
          if (num[a]<10) num[a]+= step/2;
 else if (num[a]<255)  num[a]+=step;
  if (num[a]>255) num[a]=255; 
  return num[a];
    }

    float sight12(int step, int a) {
        if (num[a] < 255) {
            num[a] += step / 2.5;
        }
        return random(0, num[a] / 1.5f);
    }

    float sight0(int step, int a) {
        if (num[a] > 0) {
            num[a] -= step/1.2;
        }
        if (num[a] < 0) {
            num[a] = 0;
        }
        return num[a];
    }

    float sight02(int step, int a) {
        if (num[a] > 0) {
            num[a] -= step / 2;
        }
        if (num[a] < 0) {
            num[a] = 1;
        }
        return random(0, num[a] / 1.5f);
    }

    void check(int a, PImage img) {
     if (num[a]>1)   {
             
        //   println("dec");
          tint(255, sight0(5,a) ); 
          image(img, 0, 0);}
    }
    
    public void setWhiteColor() {
        mColor = 200;
    }

    public void setRedColor() {
        mColor = 50;
    }
    
}

public final class RunExperimentTopComponent extends TopComponent {
    
    private JFXPanel fxContainer;
    private ExperimentNode context;
    private VBox vb;
    private Experiment eObj;
    Parent root;
    BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    java.awt.Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
    RunExperimentTopComponent mThis;
    private int trialsCounter = 1;
    private String screenName = "";
    BufferedImage capture;
    public static MyPA mpa;
    IViewX dev = new IViewX();
    private final int LIMIT = 500;
    
    public static void makeItRed(){
        if(mpa != null){
            mpa.setRedColor();
        }
    }
    
    public static void makeItWhite(){
        if(mpa != null){
            mpa.setWhiteColor();
        }
    }
    

    public void storeBufferedImg() {
        Project project = (Project) context.getLookup().lookup(Project.class);
        String foderPathForScreens = "C:\\img\\";
        if (project != null) {
            foderPathForScreens = project.getProjectDirectory().getPath();
        }

        eObj = (Experiment) context.getLookup().lookup(Experiment.class);

        String userPrefix = "";
        if (eObj != null) {
            if (eObj.getParticipant() != null) {
                userPrefix = eObj.getParticipant().getFirstName() + eObj.getParticipant().getLastName();
            }
        }

        String fileName = foderPathForScreens + "/Screens/stImgForTrial" + userPrefix + "_" + trialsCounter + "_"
                + current.sObj.getComplexity() + "_";
        if (current.participantAnswer.equals(current.sObj.getCorrectAnswer())) {
            fileName += "AnsTRUE_";
        } else {
            fileName += "AnsFALSE_";
        }

        if (current.participantAnswer.equals("NAN")) {
            fileName += "SkipTRUE";
        } else {
            fileName += "SkipFALSE";
        }

        screenName = fileName + ".png";

        System.out.println(screenName);

        new SwingWorker<Void, Void>() {
            private boolean success;

            @Override
            protected Void doInBackground() throws Exception {

                if (ImageIO.write(capture, "png", new File(screenName))) {
                    success = true;
                }
                return null;
            }

            @Override
            protected void done() {
                if (success) {
                    // notify user it succeed
                    System.out.println("SuccessImg");
                } else {
                    // notify user it failed
                    System.out.println("FailedImg");
                }
            }
        }.execute();
    }

    public void screenCapture() {

        new SwingWorker<Void, Void>() {
            private boolean success;

            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(400);

                try {
                    Robot robot = new Robot();
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    java.awt.Rectangle screenRect = new java.awt.Rectangle(screenSize);
                    capture = robot.createScreenCapture(screenRect);
                } catch (AWTException ex) {
                    Exceptions.printStackTrace(ex);
                }
                return null;
            }

            @Override
            protected void done() {
                if (success) {
                    // notify user it succeed
                    System.out.println("SuccessTrial");
                } else {
                    // notify user it failed
                    System.out.println("FailedTrial");
                }
            }
        }.execute();

    }

    public RunExperimentTopComponent(ExperimentNode context) {
        initComponents();
//        startIViewXListener();
        setName(Bundle.CTL_RunExperimentTopComponent());
        setToolTipText(Bundle.HINT_RunExperimentTopComponent());
        mThis = this;
        this.context = context;
        
        dev.setSendIP("192.168.0.2");
        dev.setSendPort(4444);
        dev.setRecivePort(5555);
        dev.startTracker();
        dev.startParsFixations();
        
        dev.addFixationListener((Fixation fObj) -> {
            if(fObj.getDuration() > LIMIT){
                makeItRed();
            } else {
                makeItWhite();
            }
        });
        
        dev.addUpdateDeviceListener((UpdateDeviceEvent event) -> {
            if(mpa != null){
                mpa.mx = event.getGazeX();
                mpa.my = event.getGazeY();
            }
        });
        
        setLayout(new BorderLayout());
        //fxContainer = new JFXPanel();
        mpa = new MyPA();
        mpa.init();
        add(mpa, BorderLayout.CENTER);
        mpa.setEyeTracker(dev);
        
        //add(fxContainer, BorderLayout.CENTER);

//        Platform.setImplicitExit(false);
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    createScene();
//                } catch (Exception e) {
//                    System.out.println("Found an exception ************************************");
//                    Exceptions.printStackTrace(e);
//                }
//            }
//        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        isTreadRuning = false;
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    private void sendUPD() {
       dev.sendNextTrial();
       trialsCounter++;
    }

//    private void createScene() {
//
//        try {
//            root = FXMLLoader.load(getClass().getResource("Run.fxml"));
//        } catch (IOException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//
//        if (root == null) {
//            return;
//        }
//
//        vb = (VBox) root.lookup("#vb");
//        vb.setSpacing(30);
//        vb.setAlignment(Pos.CENTER);
//
//        Button runExpBtn = (Button) root.lookup("#runbutton");
//        runExpBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent t) {
//                Project project = (Project) context.getLookup().lookup(Project.class);
//                if (project != null) {
//                    StimuleList sList = (StimuleList) project.getLookup().lookup(StimuleList.class);
//                    eObj.setStimuli(sList.getAllStimuli());
//                    
//                }
//                runExperiment();
//            }
//        });
//        runExpBtn.setGraphic(new ImageView(IconManager.getFXIcon("flag.png", 24, 24)));
//
//        Label participantName = (Label) root.lookup("#participantname");
//        if (context != null) {
//            eObj = (Experiment) context.getLookup().lookup(Experiment.class);
//            if (eObj != null) {
//                if (eObj.getParticipant() != null) {
//                    if (eObj.isIsDone()) {
//                        participantName.setText("So, your experiment already done. \n\n");
//                        vb.getChildren().remove(runExpBtn);
//                        Scene scene = new Scene(root);
//                        fxContainer.setScene(scene);
//                        return;
//                    }
//                    participantName.setText("So, " + eObj.getParticipant().getFirstName() + " " + eObj.getParticipant().getLastName() + "...\n\n");
//                } else {
//                    participantName.setText("You have no participation in this experiment. \n Please, edit experiment and add participant.\n\n");
//                    vb.getChildren().remove(runExpBtn);
//                    Button editExp = new Button("Edit experiment");
//                    editExp.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    close();
//                                    TopComponent tce = WindowManager.getDefault().findTopComponent("ExperimentEditorTopComponent");
//                                    if (tce == null) {
//                                        return;
//                                    }
//                                    if (!tce.isOpened()) {
//                                        tce.open();
//                                    }
//                                    tce.requestActive();
//                                }
//                            });
//                        }
//                    });
//                    vb.getChildren().add(editExp);
//                }
//            }
//            Scene scene = new Scene(root);
//            fxContainer.setScene(scene);
//
//        } else {
//
//            SwingUtilities.invokeLater(new Runnable() {
//                @Override
//                public void run() {
//                    close();
//                }
//            });
//        }
//    }

//    private void runExperiment() {
//        if (vb == null) {
//            return;
//        }
//        eObj.setBeginTime(String.valueOf(System.currentTimeMillis()));
//        //TODO convert time to human readable        
//        stieList = eObj.getStimuleINE();
//        iterator = stieList.iterator();
//        nextStimule();
//        sendUPD();
//        screenCapture();
//    }


    Process process;
    ArrayList<Experiment.StimuleInExperiment> stieList;
    Iterator<Experiment.StimuleInExperiment> iterator;
    Experiment.StimuleInExperiment current;
    public static Ellipse smallCircle;
    boolean isTreadRuning = true;

//    private void nextStimule() {
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                vb.getChildren().clear();
//            }
//        });
//
//        if (iterator.hasNext()) {
//            current = iterator.next();
//            current.beginTime = String.valueOf(System.currentTimeMillis());
//            current.indexInTheSet = stieList.indexOf(current);
//            
//            System.out.println("   ");
//            System.out.println("maskType: " + current.maskType + ", stencilSize: " + current.stencilSize);
//            System.out.println("   ");
//
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    final Label task = new Label(current.sObj.getContent());
//                    task.setStyle("-fx-text-fill: black;"
//                            + "-fx-font: 50px \"Courier\" ;"
//                            + "-fx-font-weight: normal;"
//                            + "-fx-cursor: null;");
//                    task.setPrefHeight(300);
//                    final Button aswerBtn = new Button("Ok");
//                    aswerBtn.setScaleX(2);
//                    aswerBtn.setScaleY(2);
//                    Button nextBtn = new Button("And the Answer is...");
//                    
//                    final Label yourAnswerLabel = new Label("Your answer: ");
//                    yourAnswerLabel.setStyle("-fx-text-fill: black;"
//                            + "-fx-font: 20px \"Courier\" ;"
//                            + "-fx-font-weight: normal;"
//                            + "-fx-cursor: null;");
//                    
//                    final TextField answerField = new TextField();
//                    answerField.setPrefWidth(200);
//                    answerField.setMaxWidth(200);
//                    answerField.setScaleY(2);
//                    answerField.setScaleX(2);
//                    nextBtn.setScaleX(2);
//                    nextBtn.setScaleY(2);
//
//                    nextBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    current.endTime = String.valueOf(System.currentTimeMillis());
//                                    setCursor(java.awt.Cursor.getDefaultCursor());
//                                }
//                            });
//                            vb.getChildren().clear();
//                            vb.setAlignment(Pos.CENTER);
//                            vb.getChildren().add(yourAnswerLabel);
//                            vb.getChildren().add(answerField);
//                            vb.getChildren().add(aswerBtn);
//                            root.setCursor(Cursor.DEFAULT);
//                            sendUPD();
//                            //screenCapture();
//
//                        }
//                    });
//
//                    nextBtn.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    setCursor(java.awt.Cursor.getDefaultCursor());
//                                }
//                            });
//                        }
//                    });
//
//                    nextBtn.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    //setCursor(blankCursor);
//                                }
//                            });
//                        }
//                    });
//                    //OK
//                    aswerBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    current.participantAnswer = answerField.getText();
//                                    sendUPD();
//                                    storeBufferedImg();
//                                    nextStimule();
//                                    screenCapture();
//                                }
//                            });
//                        }
//                    });
//
//                    Button noAnswerBtn = new Button("I have NO Answer");
//                    noAnswerBtn.setScaleX(2);
//                    noAnswerBtn.setScaleY(2);
//
//                    noAnswerBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    current.endTime = String.valueOf(System.currentTimeMillis());
//                                    current.participantAnswer = "NAN";
//                                    sendUPD();
//                                    storeBufferedImg();
//                                    nextStimule();
//                                    screenCapture();
//                                }
//                            });
//                            vb.getChildren().clear();
//                        }
//                    });
//
//                    noAnswerBtn.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    setCursor(java.awt.Cursor.getDefaultCursor());
//                                }
//                            });
//                        }
//                    });
//
//                    noAnswerBtn.addEventFilter(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent t) {
//                            SwingUtilities.invokeLater(new Runnable() {
//                                @Override
//                                public void run() {
//                                    setCursor(blankCursor);
//                                }
//                            });
//                        }
//                    });
//
//
//                    vb.setAlignment(Pos.TOP_CENTER);
//                    Group g = new Group();
//                    g.getChildren().add(task);
//                    vb.getChildren().add(g);
//
//                    HBox hb = new HBox();
//                    hb.setPrefHeight(550);
//                    hb.getChildren().add(noAnswerBtn);
//                    hb.getChildren().add(nextBtn);
//                    hb.setSpacing(150);
//                    hb.setAlignment(Pos.CENTER);
//                    vb.getChildren().add(hb);
//
//                }
//            });
//
//        } else {
//            eObj.setIsDone(true);
//            serialize();
//            exportToCSFile();
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    vb.getChildren().clear();
//                    Label endField = new Label("Thank you!\n\n\n The end.");
//                    vb.setAlignment(Pos.CENTER);
//                    vb.getChildren().add(endField);
//                }
//            });
//
//            //expId, partId, questId, date, beginTime, endTime, duration, complexity, isAnswerCorrect
//        }
//    }

    private void serialize() {
        SerializeCookie sc = context.getLookup().lookup(SerializeCookie.class);
        if (sc != null) {
            sc.serialize();
        }
    }

    private void exportToCSFile() {
        ExportToCSFileCookie sc = context.getLookup().lookup(ExportToCSFileCookie.class);
        if (sc != null) {
            sc.serialize();
        }
    }
}
