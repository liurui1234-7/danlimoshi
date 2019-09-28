import fruit.*;
import fruitGardener.*;
public class gongchangfangfa{
    public static void main(String[] args){
   FruitGardener f=new Applefactory();
    Fruit apple=f.factory();
     apple.grow();

}
}