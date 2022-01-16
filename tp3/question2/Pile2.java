package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.stk.setSize(taille);
        this.capacite = 0;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
         if (estPleine())
            throw new PilePleineException();
        this.stk.add(o);
        this.capacite++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.capacite--;
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        Iterator iterator = stk.iterator(); 
        int centerIndex = this.capacite/2;
        Object center = new Object();
        while(iterator.hasNext())  
        {  
            Object value = iterator.next();  
            if(this.stk.search(iterator.next()) == centerIndex){
                center = value; 
            }
        }
        return center;
    }

    public boolean estVide() {
        return this.stk.empty();
    }

    public boolean estPleine() {
        return this.stk.size() == this.capacite;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Iterator iterator = stk.iterator(); 
        while(iterator.hasNext())  
        {  
            Object value = iterator.next();  
            sb.append(value);
            if (value != null){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        Pile2 p = (Pile2)o;
        if(this.capacite == p.capacite)
        {
            Iterator iterator1 = stk.iterator(); 
            Iterator iterator2 = p.stk.iterator(); 
            while(iterator1.hasNext())  
            {  
                Object value1 = iterator1.next();  
                Object value2 = iterator2.next(); 
                if(value1 != value2){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return this.capacite;
    }

    public int capacite() {
        return stk.size() - capacite;
    }

}
