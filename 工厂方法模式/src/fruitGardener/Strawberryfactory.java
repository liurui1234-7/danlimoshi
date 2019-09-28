package fruitGardener;
import fruit.*;
public class Strawberryfactory implements FruitGardener{
     public Fruit factory(){
     return new Strawberry();
}
}