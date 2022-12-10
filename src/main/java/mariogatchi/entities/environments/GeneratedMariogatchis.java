package mariogatchi.entities.environments;

import mariogatchi.entities.Mariogatchi;

import java.util.*;

/**
 * A Mariogatchi Iterator: a list of Mariogatchis
 */
public class GeneratedMariogatchis implements Iterable<Mariogatchi> {
    /**
     * This Mariogatchi Book is a list of Mariogatchis.
     */
    private final List<Mariogatchi> generatedMariogatchis = new ArrayList<>();

    /**
     * Adds a new mariogatchi to the list of Mariogatchis.
     *
     * @param mariogatchi the Mariogatchi
     */
    public void addMariogatchi(Mariogatchi mariogatchi){
        generatedMariogatchis.add(mariogatchi);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Mariogatchi m : generatedMariogatchis) {
            res.append(m);
        }
        return res.toString();
    }

    /**
     * Returns an iterator for this Mariogatchi book.
     *
     * @return an iterator for this Mariogatchi book.
     */
    @Override
    public Iterator<Mariogatchi> iterator(){
        return new generatedMariogatchisIterator();
    }

    /**
     * An Iterator for GeneratedMariogatchis Mariogatchis.
     */
    private class generatedMariogatchisIterator implements Iterator<Mariogatchi>{

        /**
         * The index of the next Mariogatchi to return.
         */
        private int current = 0;

        /**
         * Returns whether there is another Mariogatchi to return.
         *
         * @return whether there is another Mariogatchi to return.
         */

        @Override
        public boolean hasNext(){
            return current < generatedMariogatchis.size();
        }

        /**
         * Returns the next Mariogatchi.
         *
         * @return the next Mariogatchi.
         */
        @Override
        public Mariogatchi next(){
            Mariogatchi res;
            try {
                res = generatedMariogatchis.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return res;
        }

        /**
         * Removes the Mariogatchi just returned.
         */
        @Override
        public void remove(){
            generatedMariogatchis.remove(current - 1);
        }
    }


}
