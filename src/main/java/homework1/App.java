package homework1;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        //check ToString
        Person a = new Person();
        System.out.println(a);

        //check equals
        Person b = new Person("b", "c", 20);
        System.out.println(b);
        System.out.println(a.equals(b));

        Person c = new Person();
        System.out.println(a.equals(c));

        //check hashCode
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        //check JSON
        Gson gsonA = new Gson();

        //Serialize
        String jsonString = gsonA.toJson(a);
        System.out.println(jsonString);

        //Deserialize
        Person d = gsonA.fromJson(jsonString, Person.class);
        System.out.println(d);
    }
}
