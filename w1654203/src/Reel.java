import java.util.Random;

public class Reel {

    public Symbol[] spin(){

        Symbol symbol1 = new Symbol();
        Symbol symbol2= new Symbol();
        Symbol symbol3 = new Symbol();
        Symbol symbol4 = new Symbol();
        Symbol symbol5 = new Symbol();
        Symbol symbol6 = new Symbol();

        symbol1.setImage("img/bell.png");
        symbol2.setImage("img/cherry.png");
        symbol3.setImage("img/lemon.png");
        symbol4.setImage("img/plum.png");
        symbol5.setImage("img/redseven.png");
        symbol6.setImage("img/watermelon.png");

        symbol1.setValue(6);
        symbol2.setValue(2);
        symbol3.setValue(3);
        symbol4.setValue(4);
        symbol5.setValue(7);
        symbol6.setValue(5);

        Symbol[] imagelist1 = {symbol1,symbol2,symbol3,symbol4,symbol5,symbol6} ;

        Random rnd = new Random();


        for(int i=imagelist1.length-1;i>=0;i--){

            int index= rnd.nextInt(i+1);
            Symbol a = imagelist1[index];
            imagelist1[index]=imagelist1[i];
            imagelist1[i] =  a;

        }

        return imagelist1;

    }


}
