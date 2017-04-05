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

class Client1 {
    public static void main(String[] args) {
        try {
            Socket s=new Socket ("127.0.0.1",1201);//server ip and port
            DataInputStream din=new DataInputStream (s.getInputStream ());
            DataOutputStream dout= new DataOutputStream (s.getOutputStream ());

            BufferedReader br= new BufferedReader (new InputStreamReader (System.in) );
            String msgin="",msgout="";
            while(!msgin.equals ("end")){
                msgout=br.readLine ();
                dout.writeUTF (msgout);
                msgin=din.readUTF ();
                System.out.println (msgin); //print server msg
            }
        } catch (Exception e) {
            //handle exceptions
        }
    }
}