import java.io.*;
import java.awt.*;
import javax.swing.*;

/**
 * @author Dennis Heidsiek
 */
public class ImageToPdfGui {

  protected static JLabel createLabel(String title, FileDrop.Listener listener) {
    JLabel label = new JLabel(String.format(
        "<html><centering><h1>%s</h1>Just drag and drop<br/>your files at this text!</centering></html>",
        title));
      
    label.setFont(new Font("Dialog", Font.PLAIN, 24));
    new FileDrop(System.out, label, BorderFactory.createRaisedBevelBorder(), listener);
    return label;
  }
  
  public static void main(String... arg) throws Exception {
    
    JFrame frame = new JFrame("img2pdf");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(1, 2));
    
    frame.add(createLabel("Create single PDF files",
      new FileDrop.Listener(){
        public void filesDropped(File[] files) {
          for(File f : files) {
            try {
              System.out.format("%s%n", f.getCanonicalPath());
            } catch(IOException e) {}
          }
        }
      }
    ));
    
    frame.add(createLabel("Create only one PDF file",
      new FileDrop.Listener(){
        public void filesDropped(File[] files) {
          for(File f : files) {
            try {
              System.out.format("%s%n", f.getCanonicalPath());
            } catch(IOException e) {}
          }
        }
      }
    ));
    
    frame.setSize(600,220);
    frame.setVisible(true);
  }
  
}