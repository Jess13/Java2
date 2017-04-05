//Задание2
/*2. * Написать консольный вариант клиент\серверного приложения, в котором пользователь
        может писать сообщения, как на клиентской стороне, так и на серверной.
        Т.е. если на клиентской стороне написать "Привет", нажать Enter,
        то сообщение должно передаться на сервер и там отпечататься в консоли.
        Если сделать то же самое на серверной стороне, сообщение, соответственно,
        передаётся клиенту и печатается у него в консоли. Есть одна особенность,
        которую нужно учитывать: клиент или сервер может написать несколько сообщений подряд,
        такую ситуацию необходимо корректно обработать.*/

package ru.geekbrains.java2.dz.dz6.OsmolovskiyAlexandr;
import java.io.*;
import java.net.*;

public class Server1 {

    public static void main(String[] args) throws IOException {
        /*System.out.println ("Welcome to Server side");
        BufferedReader din = null;
        PrintWriter dout = null;

        ServerSocket servers = null;
        Socket fromclient = null;
*/
        // create server socket
        try {
            ServerSocket ss = new ServerSocket (1201);
            Socket s = ss.accept ();
            DataInputStream din = new DataInputStream (s.getInputStream ());
            DataOutputStream dout = new DataOutputStream (s.getOutputStream ());
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            String msgin = "", msgout = "";

            while (!msgin.equals ("end")) {
                msgin = din.readUTF ();
                System.out.println (msgin); //print client msg
                msgout = br.readLine ();
                dout.writeUTF (msgout);
                dout.flush ();
            }

            s.close ();
        } catch (Exception e) {
        }



    }
}

/*

  while ((input = din.readLine()) != null){
      if (input.equalsIgnoreCase("exit")) break;
     //if (fuser.equalsIgnoreCase("exit")) break;
      out.println("S ::: "+input);
      System.out.println(input);
    }
  while ((input = inu.readLine()) != null) {
     if (fuser.equalsIgnoreCase("exit")) break;
     out.println("S ::: "+input);
     System.out.println(input);
     }
*/



//(input = in.readLine()) != null||

      /*while ((fuser = inu.readLine())!=null) {
          if (input.equalsIgnoreCase("exit")) break;
          out.println("Proba"+fuser);
          output = inu.readLine();
          System.out.println(output);
      }*/

