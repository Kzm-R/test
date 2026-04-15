import java.util.Scanner;
import java.util.ArrayList;

class Product {
    String [] names = new String[2];
    int count;
    public Product(String name1, String name2){
        this.names = new String[2];
        this.names[0] = name1;
        this.names[1] = name2;
        this.count = 1;
    }
    public void increment(){
        this.count++;
    }
    public String getName(){return this.names[0] + " " + this.names[1];}
    public int getCount(){return this.count;}
}
public class task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Product>list = new ArrayList<>();
        int N = sc.nextInt();
        boolean found = false;
        for (int i=0;i<N;i++){
            int M = sc.nextInt();
            String [] name = new String[M];
            for(int j=0;j<M;j++){
                name[j] = sc.next();
            }
            for(int j=0;j<M;j++){
                for(int k=j+1;k<M;k++){
                        String product1 = name[j];
                        String product2 = name[k];
                        if(product1.compareTo(product2) > 0){
                            String tmp = product1;
                            product1 = product2;
                            product2 = tmp; 
                        }

                        found = false;
                        for(int l=0;l<list.size();l++){
                            Product p = list.get(l);
                            if(p.getName().equals(product1 + " " + product2)){
                                p.increment();
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            list.add(new Product(product1,product2));
                        }
                }
            }
        }

        list.sort((a, b) -> {
        if (b.count != a.count) {
            return b.count - a.count;
        }
        return a.getName().compareTo(b.getName());
        });

        for(Product p : list){
            System.out.println(p.count + " " + p.names[0] + " " + p.names[1]);
        }
    }
}