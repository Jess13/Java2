package Tests.Icons1;

/**
 * Created by Jess on 25.03.2017.
 */
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Icons1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("будущая программа ТОП"); //заголовок проги
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src\\main\\java\\Tests\\Icons1\\128.png"); //значок иконки в заголовке
        frame.setIconImage(image.getImage());
        //frame.setLocationRelativeTo(null);
//frame.setResizable(false); //позволяет изменять размер

        try { //создает фон программы
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\main\\java\\Tests\\Icons1\\knopka.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);

    }

}