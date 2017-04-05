package ru.geekbrains.java2.dz.dz1.ShagidullinIldar;

import org.omg.CORBA.StringHolder;

public class Figure {
    protected String type;

    public Figure(String type) {
        this.type = type;
    }


    public void cantMove(){
        System.out.println(type + " cant move");
    }

}