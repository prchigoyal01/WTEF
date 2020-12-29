
public class Main {

    public static void main(String[] args) {
        OpenInterval i1 = new OpenInterval(2, 3);
        CloseInterval i2 = new CloseInterval(6, 7);
    
        SemiOpenInterval i3 = new SemiOpenInterval(8, 10);
        
        System.out.println(i2.combine(i3));
        System.out.println(i2.combine(i1));
        System.out.println(i1.combine(i2));
        System.out.println(OpenInterval.validity());
    }
}
