package nav.twitter;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class FilterRecords {
    public static void main(String args[] ) throws Exception {
        /*Scanner input = new Scanner(System.in);
        String[] ranges = input.nextLine().split(",");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM");
        Date from = fmt.parse(ranges[0].trim()), to = fmt.parse(ranges[1].trim());
        input.nextLine();
        TreeMap<String, String> map = new TreeMap<>(Collections.reverseOrder());
        while(input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            String date = line[0].trim().substring(0, line[0].trim().lastIndexOf("-"));
            Date current = fmt.parse(date);
            if(line.length!=3 || line[1].trim().equals("") || line[2].trim().equals("") || line[2].trim().equals("0"))
                continue;
            if(from.compareTo(current) <= 0 && to.compareTo(current) > 0) {
                if(map.containsKey(line[0].trim()))
                    map.put(line[0].trim(), map.get(line[0].trim())+ ", " + line[1].trim() + ", " + line[2].trim());
                else
                    map.put(line[0].trim(), line[1].trim() + ", " + line[2].trim());
            }

        }
        /*Set set = map.entrySet();
        Iterator i = set.iterator();
        Date prev = null, curr;boolean flag = true;
        StringBuilder out = new StringBuilder();
        TreeMap<String, Integer> map1 = null;
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            curr = fmt.parse(me.getKey().toString().substring(0, me.getKey().toString().lastIndexOf("-")));
            if(flag) {
                prev= curr;
                flag = !flag;
            }
            if(curr.compareTo(prev) != 0) {
                System.out.print(fmt.format(prev)+ ", ");
                System.out.println(printMap(map1));
                map1.clear();
            }
            String[] str = me.getValue().toString().split(",");
            if(map1 == null || map1.isEmpty()) {
                map1 = new TreeMap<>();
                for(int j=0;j<str.length;j+=2)
                    map1.put(str[j].trim(), Integer.parseInt(str[j+1].trim()));
            }
            else {
                for(int j=0;j<str.length;j+=2) {
                    if(map1.containsKey(str[j].trim()))
                        map1.put(str[j].trim(), map1.get(str[j].trim()) + Integer.parseInt(str[j+1].trim()));
                    else
                        map1.put(str[j].trim(), Integer.parseInt(str[j+1].trim()));
                }
            }
            prev = curr;
        }
        System.out.print( fmt.format(prev)+ ", ");
        System.out.println(printMap(map1));
        map1.clear();*/
    }

   /* static String printMap(Map map) {
        Set set = map.entrySet();
        Iterator i = set.iterator();
        StringBuilder out = new StringBuilder();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            out.append(me.getKey()+", "+me.getValue());
            if(i.hasNext())
                out.append(", ");
        }
        return out.toString();
    }*/
}
