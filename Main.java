package map;


import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> map_Car = new HashMap<String, Car>();

        map_Car.put( "А001АА163", new Car("Solaris") );
        map_Car.put( "В524КМ777", new Car("Rio") );
        map_Car.put( "У358СМ58", new Car("Vesta") );
        map_Car.put( "Р567АА63", new Car("Granta") );
        map_Car.put( "А123РР73", new Car("Priora") );
        map_Car.put( "О444РА763", new Car("Corolla") );

        System.out.print("1 - Поиск по региону, 2 - Поиск по модели :");
        int report = Integer.parseInt(bufferedReader.readLine());

        if (report == 1){
            System.out.print("Введите номер региона для поиска: ");
            String region = bufferedReader.readLine();
            findRegion(map_Car,region);
        }
        else if (report == 2){
            System.out.print("Введите название модели для поиска (латинские буквы): ");
            String model = bufferedReader.readLine();
            findModel(map_Car,model);
        }
        else{
            System.out.println("Необходимо ввести 1 или 2");
        }


    }
    public static void findRegion(Map map, String region){
        Iterator<Map.Entry<String, Car>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Car> pair = it.next();
            if (pair.getKey().endsWith(region)) {
                System.out.println(pair.getKey() + " " + pair.getValue().getModel());
            }
        }

    }
    public static void findModel(Map map, String model){

        Iterator<Map.Entry<String, Car>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Car> pair = it.next();
            String mod = pair.getValue().getModel().toLowerCase();
            if (model.toLowerCase().equals(mod)){
                System.out.println(pair.getKey() + " " + pair.getValue().getModel());
            }

        }



    }
}
