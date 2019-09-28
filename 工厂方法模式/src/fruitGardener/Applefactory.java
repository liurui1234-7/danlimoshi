package fruitGardener;
import fruit.*;
public class Applefactory implements FruitGardener{
    public Fruit factory(){
     return new Apple();
}
}