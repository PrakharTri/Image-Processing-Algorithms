package hoffmann_non.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Hoffmann_nonBinary {
    
        public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Float> tmap=new TreeMap<Character, Float>();
        Map<Character,Float> tmap0=new TreeMap<Character,Float>();
        Set<String> testset=new TreeSet<String>();
        List<String> testlist=new ArrayList<String>();
        Map<Character, String> testcodemap=new TreeMap<Character,String>();
        System.out.println("Enter the word or write no. of characters for providing userdefined probablity");
        String s=br.readLine();
            int totlen;
        try{
            int x=Integer.parseInt(s);
            totlen=x;
            System.out.println("Enter the Character followed by its probability in the next line");
            for(int i=0;i<x;++i)
            {
                s=br.readLine();
                char sch=s.charAt(0);
                s=br.readLine();
                float sf=Float.parseFloat(s);
                tmap.put(sch,sf);                       //probability of each character in the word
                testset.add(sf+" "+sch);                // appending character after its probability in treeset
                testcodemap.put(sch,"");                // mapping empty string to each character ------ -
                for(char ch0 : tmap.keySet())
                    tmap0.put(ch0,tmap.get(ch0));    
            }
        }
        catch(Exception e){
        char[] ch=s.toCharArray();
            totlen=ch.length;
        Arrays.sort(ch);
        for(char ch0:ch)
        tmap.put(ch0,0f);          //initializing no. of each character as 0
        for(char ch0:ch)
        {
            tmap.put(ch0,tmap.get(ch0)+1f);     //incrementing the no. of character
            testcodemap.put(ch0,"");
        }
        for(char ch0:ch)
        {
            tmap0.put(ch0,tmap.get(ch0)/(float)ch.length);      //probability of each character in the word
            testset.add(tmap0.get(ch0)+" "+ch0);                // appending character after its probability in treeset
        }
        }
        long startTime0 = System.nanoTime();
        long startTime = System.currentTimeMillis();
        for(String st:testset)
        {   
        testlist.add(st);                                       //copying values of treeset into an arraylist
        }
        Collections.reverse(testlist);   
        int count00=0;
        while(testlist.size()>2)
        {
            ++count00;
            String c0=testlist.get(testlist.size()-1);
            String c1=testlist.get(testlist.size()-2);
            String c2=testlist.get(testlist.size()-3);
            int c0in=c0.indexOf(" ");
            int c1in=c1.indexOf(" ");
            int c2in=c1.indexOf(" ");
            float f0=Float.parseFloat(c0.substring(0,c0in));
            float f1=Float.parseFloat(c1.substring(0,c1in));
            float f2=Float.parseFloat(c2.substring(0,c2in));
            f0+=f1+f2;
            String s0=c0.substring(c0in);
            String s1=c1.substring(c1in);
            String s2=c2.substring(c2in);
            StringBuilder sb=new StringBuilder();
            char testchar=' ';
            int count=0;
            for(char c:s2.toCharArray())
            {
                if(c=='2'||c=='1'||c=='0')
                {
                    sb.append("0"+c);
                    if(count==0)
                    testcodemap.put(testchar,"0"+testcodemap.get(testchar));
                    count++;
                }
                else
                {
                    sb.append(c);
                    testchar=c;
                    count=0;
                }
            }
            if(sb.toString().equals(s2)){
            sb.append("0");
            testcodemap.put(testchar,"0"+testcodemap.get(testchar));}
            s2=sb.toString();
            sb=new StringBuilder();
            testchar=' ';
            count=0;
            for(char c:s1.toCharArray())
            {
                if(c=='2'||c=='1'||c=='0')
                {
                    sb.append("1"+c);
                    if(count==0)
                    testcodemap.put(testchar,"1"+testcodemap.get(testchar));
                    count++;
                }
                else{
                sb.append(c+"");
                testchar=c;
                count=0;}
            }
            if(sb.toString().equals(s1)){
            sb.append(1+"");
            testcodemap.put(testchar,"1"+testcodemap.get(testchar));}
            s1=sb.toString();
            sb=new StringBuilder();
            testchar=' ';
            count=0;
            for(char c:s0.toCharArray())
            {
                if(c=='2'||c=='1'||c=='0')
                {
                    sb.append("0"+c);
                    if(count==0)
                    testcodemap.put(testchar,"0"+testcodemap.get(testchar));
                    count++;
                }
                else{
                sb.append(c+"");
                testchar=c;
                count=0;}
            }
            if(sb.toString().equals(s0)){
            sb.append(2+"");
            testcodemap.put(testchar,"2"+testcodemap.get(testchar));}
            s0=sb.toString();
            testlist.remove(testlist.size()-1);
            testlist.remove(testlist.size()-1);
            testlist.remove(testlist.size()-1);
            testlist.add(f0+" "+s0+""+s1+""+s2);
            testset.clear();
            for(String fst:testlist)
            {
                testset.add(fst);
            }
            testlist.clear();
            for(String fst:testset)
            {
                testlist.add(fst);
            }
            Collections.reverse(testlist);
//            System.out.println(testlist.size());
//            System.out.println(testlist);
//            System.out.println();
        }
        switch(testlist.size())
        {
            case 1:
//                System.out.println("1st case");
                String c0=testlist.get(testlist.size()-1);
                int c0in=c0.indexOf(" ");
                float f0=Float.parseFloat(c0.substring(0,c0in));
//              f0+=f1+f2;
                String s0=c0.substring(c0in);
                StringBuilder sb=new StringBuilder();
                char testchar=' ';
                int count=0;
                for(char c:s0.toCharArray())
                {
                    if(c=='2'||c=='1'||c=='0')
                    {
                        sb.append("2"+c);
                        if(count==0)
                        testcodemap.put(testchar,"2"+testcodemap.get(testchar));
                        count++;
                    }
                    else
                    {
                        sb.append(c);
                        testchar=c;
                        count=0;
                    }
                }
                if(sb.toString().equals(s0)){
                sb.append("2");
                testcodemap.put(testchar,"2"+testcodemap.get(testchar));}
                s0=sb.toString();
            
                testlist.remove(testlist.size()-1);
                testlist.add(f0+" "+s0);
            
                break;
            case 2:
//                System.out.println("2nd case");
                c0=testlist.get(testlist.size()-2);
                String c1=testlist.get(testlist.size()-1);
                c0in=c0.indexOf(" ");
                int c1in=c1.indexOf(" ");
                f0=Float.parseFloat(c0.substring(0,c0in));
                float f1=Float.parseFloat(c0.substring(0,c1in));
                f0+=f1;
                s0=c0.substring(c0in);
                String s1=c1.substring(c1in);
                sb=new StringBuilder();
                testchar=' ';
                count=0;
                for(char c:s0.toCharArray())
                {

                    if(c=='2'||c=='1'||c=='0')
                    {
                        sb.append("1"+c);
                        if(count==0)
                        testcodemap.put(testchar,"1"+testcodemap.get(testchar));
                        count++;
                    }
                    else
                    {
                        sb.append(c);
                        testchar=c;
                        count=0;
                    }
                }
                if(sb.toString().equals(s0)){
                sb.append("1");
                testcodemap.put(testchar,"1"+testcodemap.get(testchar));}
                s0=sb.toString();
                sb=new StringBuilder();
                testchar=' ';
                count=0;
                for(char c:s1.toCharArray())
                {
                    if(c=='2'||c=='1'||c=='0')
                    {
                        sb.append("2"+c);
                        if(count==0)
                        testcodemap.put(testchar,"2"+testcodemap.get(testchar));
                        count++;
                    }
                    else
                    {
                        sb.append(c);
                        testchar=c;
                        count=0;
                    }
                }
                if(sb.toString().equals(s1)){
                sb.append("2");
                testcodemap.put(testchar,"2"+testcodemap.get(testchar));}
                s1=sb.toString();
                
            
                testlist.remove(testlist.size()-1);
                testlist.remove(testlist.size()-1);
                testlist.add(f0+" "+s0+""+s1);
//                System.out.println("_______"+testlist);           //debug statement
                
                break;
            default:
//                System.out.println("default case");
        }
        long stopTime = System.currentTimeMillis();
        long stopTime0=System.nanoTime();
        System.out.println("****");
        System.out.println(testcodemap.keySet());
        System.out.println(testcodemap.values());
        System.out.println("****");
        System.out.println("Hoffmann Non Binary codes for different characters :");
        for(char ch0:testcodemap.keySet())
        {
            System.out.println(ch0+" => "+testcodemap.get(ch0));
        }
            float avlen=0f;
        NumberFormat df=new DecimalFormat("#.####");
        for(char ch0: testcodemap.keySet())
            avlen+=tmap0.get(ch0)*1f*testcodemap.get(ch0).length();             //prob * code length
        double eff=0;
        for(char ch0: testcodemap.keySet())
            eff+=(1D*tmap0.get(ch0)*Math.log(tmap0.get(ch0)))/(1D*Math.log(2)*totlen);
        eff/=1D*avlen;
        System.out.println("Average Code Length = "+df.format(avlen)+"\nEfficiency of Compression = "+df.format(Math.abs(eff)));
        
        long elapsedTime = stopTime - startTime;
        long elapsedTime0 = stopTime0 - startTime0;
//        System.out.println("Compression TIME="+elapsedTime+"ms");       //Elapsed Time in ms
        System.out.println("Compression TIME="+elapsedTime0+"ns");         //Elapsed Time in ns

        
    }
    
}

