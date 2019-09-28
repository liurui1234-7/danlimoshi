package fruitGardener;
import fruit.*;
public class Grapefactory implements FruitGardener{
     public Fruit factory(){
     return new Grape();
}
}