package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.Iterator;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if (taille < 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
       if (estVide())
            throw new PileVideException();
        return this.v.remove(this.v.lastElement());
    }

    public Object sommet() throws PileVideException {
         Iterator iterator = v.iterator(); 
        int centerIndex = this.v.size()/2;
        Object center = new Object();
        while(iterator.hasNext())  
        {  
            Object value = iterator.next();  
            if(this.v.indexOf(iterator.next()) == centerIndex){
                center = value; 
            }
        }
        return center;
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return this.v.size() - this.v.capacity();
    }

    public boolean estVide() {
        return this.v.isEmpty();
    }

    public boolean estPleine() {
        return this.v.size() != 0;
    }

    public String toString() {
         StringBuffer sb = new StringBuffer("[");
        Iterator iterator = v.iterator(); 
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
        if(this.v.size() == p.taille())
        {
            Iterator iterator1 = v.iterator(); 
            Iterator iterator2 = v.iterator(); 
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

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
