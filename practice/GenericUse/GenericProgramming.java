package practice.GenericUse;

public class GenericProgramming {
    public static void main(String[] args) {
/*
        Store store = new Store(); // Raw use of parameterized class 'Store' is not recommended, it will not impact the code and will work fine
        store.put("Hello"); // This will work fine
        System.out.println(store.get());
        store.put(1); // This will also work fine
        System.out.println(store.get());
*/

        Store<String> store = new Store<>();
        store.put("Hello"); // This will work fine
        System.out.println(store.get());
//        store.put(1); // Give compile time error: incompatible types: int cannot be converted to String
        System.out.println(store.get());


        GenericMethod met = new GenericMethod();
        met.showItem(1);
        met.showItem("Hello");
        met.showItem(1.0);
        met.returnItem(1);
        met.returnItem("Hello");

        System.out.println(met.add(1, 2));
        System.out.println(met.add(1.0, 2.0));
    }
}

class Store<T> {

    /*
        private Object item;

        public Object get() {
            return item;
        }

        public void put(Object obj) {
            item = obj;
        }
     */

    private T item;

    public T get() {
        return item;
    }

    public void put(T obj) {
        item = obj;
    }
}

class GenericMethod {

    public <T> void showItem(T item) {
        System.out.println("Item: " + item);
    }

    public <T> T returnItem(T item) {
        System.out.println("Returned Item: " + item);
        return item;
    }

    public <T extends Number> T add(T t1, T t2) {
        if (t1 instanceof Integer) {
            return (T) Integer.valueOf(t1.intValue() + t2.intValue());
        } else if (t1 instanceof Double) {
            return (T) Double.valueOf(t1.doubleValue() + t2.doubleValue());
        } else if (t1 instanceof Float) {
            return (T) Float.valueOf(t1.floatValue() + t2.floatValue());
        } else if (t1 instanceof Long) {
            return (T) Long.valueOf(t1.longValue() + t2.longValue());
        } else if (t1 instanceof Short) {
            return (T) Short.valueOf((short) (t1.shortValue() + t2.shortValue()));
        } else if (t1 instanceof Byte) {
            return (T) Byte.valueOf((byte) (t1.byteValue() + t2.byteValue()));
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}
