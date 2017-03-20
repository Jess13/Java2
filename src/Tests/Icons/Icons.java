package Tests.Icons;

/**
 * Created by Jess on 18.03.2017.
 */
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Icons {

    public static void main(String[] args) {
        JFrame frame = new JFrame("будущая программа ТОП"); //заголовок проги
        ImageIcon image = new ImageIcon("src\\Tests\\Icons\\128.png"); //значок иконки в заголовке
        frame.setIconImage(image.getImage());
//frame.setResizable(false); //позволяет изменять размер

        try { //создает фон программы
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\Tests\\Icons\\knopka.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);

    }

}
