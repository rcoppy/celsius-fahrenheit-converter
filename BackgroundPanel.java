// Based on a code example copy-pasted from http://www.coderanch.com/how-to/java/BackgroundImageOnJPanel

import javax.imageio.ImageIO.*; 
import javax.swing.*;
import java.awt.*; 

class BackgroundPanel extends JPanel
{
  Image image;
  public BackgroundPanel(String filepath)
  {
    try
    {
      image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource(filepath), filepath));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g); 
    if (image != null)
      g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
  }
}