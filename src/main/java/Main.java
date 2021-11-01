import functions.*;
import functions.basic.Cos;
import functions.basic.Exp;
import functions.basic.Log;
import functions.basic.Sin;
import functions.meta.Composition;

import java.io.*;

public class Main {
    public static void main(String[] args){
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(0,10,10);
        for (int i = 0; i < arrayTabulatedFunction.getPointsCount(); i++) {
            arrayTabulatedFunction.setPointY(i, Math.log(arrayTabulatedFunction.getPointX(i)));
        }

        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(0,10,10);
        for (int i = 0; i < linkedListTabulatedFunction.getPointsCount(); i++) {
            linkedListTabulatedFunction.setPointY(i, Math.sin(linkedListTabulatedFunction.getPointX(i)));
        }

        System.out.println(arrayTabulatedFunction);
        System.out.println(linkedListTabulatedFunction);

        System.out.println(arrayTabulatedFunction.equals(linkedListTabulatedFunction));

        ArrayTabulatedFunction arrayTabulatedFunction2 = new ArrayTabulatedFunction(0,10,10);
        for (int i = 0; i < arrayTabulatedFunction2.getPointsCount(); i++) {
            arrayTabulatedFunction2.setPointY(i, Math.log(arrayTabulatedFunction2.getPointX(i)));
        }
        System.out.println(arrayTabulatedFunction.equals(arrayTabulatedFunction2));
        System.out.println(arrayTabulatedFunction.hashCode());
        System.out.println(arrayTabulatedFunction2.hashCode());

        arrayTabulatedFunction.setPointY(2, 5);
        System.out.println(arrayTabulatedFunction.hashCode());

        LinkedListTabulatedFunction linkedListTabulatedFunction2 = null;
        try {
            linkedListTabulatedFunction2 = (LinkedListTabulatedFunction) linkedListTabulatedFunction.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        linkedListTabulatedFunction2.setPointY(2, 228);
        System.out.println(linkedListTabulatedFunction2);
        System.out.println(linkedListTabulatedFunction);
    }
}