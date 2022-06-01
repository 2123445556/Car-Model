import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Car {

    private String brand;
    private String color;
    private String location;
    private double price;
    private String packge;
    private Object image;
    // Constructor that has the parameters for the image, brand, color, location, type of package, and price of the car.
    public Car(Object a, String b, String y, String c, String l, double p){
        image = a;
        brand = b;
        color = c;
        location = l;
        packge = y;
        price = p;

    }
    // This empty constructor is mainly used to overload the other constructor.
    public Car(){

    }

    // Getters methods for the properties of the car and image.
    public String getColor(){return color;}

    public String getBrand(){return brand;}

    public String getPackage(){return packge;}

    public String getLocation(){return location;}

    public double getPrice(){return price;}

    public Object getImage(){return image;}


}
