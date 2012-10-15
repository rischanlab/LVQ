import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;
 
public class Image2Array {
    public static void main(String[] args) throws IOException {
		
		File file = new File("ga-one.jpg");// file object to get the file, the second argument is the name of the image file
        final BufferedImage image1 = ImageIO.read(file);
	
      // URL url = new URL("http://localhost/lvq/ra-one.jpg");
      // final BufferedImage image1 = ImageIO.read(url);
       final BufferedImage image2 = To1Bit(image1);
 
        EventQueue.invokeLater(new Runnable(){
            public void run() {
				JPanel cp = new JPanel();
				cp.add(new JLabel(new ImageIcon(image1)));
              //  cp.add(new JLabel(new ImageIcon(image2)));
                JFrame f = new JFrame("Image2Array");
				f.setContentPane(cp);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
 
    static BufferedImage To1Bit(BufferedImage src) {
        BufferedImage tgt = new BufferedImage(src.getWidth(), src.getHeight(),
            BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = tgt.createGraphics();
        g.drawRenderedImage(src, null);
        g.dispose();
        dump(tgt);
        return tgt;
    }
 
    static void dump(BufferedImage im) {
        for(int y=0; y<im.getHeight(); ++y) {
            for(int x=0; x<im.getWidth(); ++x) {
                Color color = new Color(im.getRGB(x, y));
                char clr = '?';
                if (color.equals(Color.BLACK))
                    clr = '1';
                else if (color.equals(Color.WHITE))
                    clr = '0';
                System.out.print(clr);
            }
            System.out.print("");
        }
    }
}