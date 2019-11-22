package org.cloudfun.design.pattern.behavior;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/11/19
 */
public class IteratorPattern {

    interface Iterator {
        boolean hasNext();

        Object getNext();
    }

    interface Container {
        Iterator getIterator();
    }


    static class NameIterator implements Iterator {

        Object[] array;

        NameIterator(Object[] array) {
            this.array = array;
        }

        int index;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            if (getIndex() < array.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object getNext() {
            if (hasNext()) {
                return array[index++];
            }
            return null;
        }
    }


    static class NameIteratorRepository implements Container {

        String[] data = {"tom", "yasuo", "jerry", "lover"};

        @Override
        public Iterator getIterator() {
            return new NameIterator(data);
        }
    }

    public static void main(String[] args) {

        NameIteratorRepository repository = new NameIteratorRepository();


        for (Iterator iterator = repository.getIterator(); iterator.hasNext();) {
            System.out.println(iterator.getNext());
        }


    }


}
