package question3;

import question1.PolygoneRegulier;

public class UneUtilisation {

    public static void main(String[] args) throws Exception {
        PileI p1 = new Pile2(10);
        PileI p2 = new Pile2(10);

        p1.empiler(new PolygoneRegulier(4, 100));
        p1.empiler(new PolygoneRegulier(5, 100));

        System.out.println(" la pile p1 = " + p1);

        p2.empiler(p1);
        System.out.println(" la pile p2 = " + p2);

        try {
            p1.empiler(new PolygoneRegulier(5,100));
            String s = (String)p1.depiler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}