import java.util.*;
import java.io.*;

public class functions {

    static void clear_console() {
        for (int i = 0; i < 80 * 2; i++)
            System.out.println("\b");
    }
    
    static void menuPrinter()
    {
        System.out.println("                      --Main Menu-- ");
        System.out.println("                                             ");
        System.out.println("[1] Eisagogh Aksiologoumenou");
        System.out.println("[2] Eisagogh Erotisewn");
        System.out.println("[3] Eisagogh Apantisewn");
        System.out.println("[4] Emfanisi Erwtisewn");
        System.out.println("[5] Emfanisi Apantisewn Enos Aksiologoumenou");
        System.out.println("[6] Emfanisi Plithous Swstwn Apantisewn Ana Aksiologoumenou");
        System.out.println("[7] Ypologismos Posostou Swstwn Apantisewn Gia Kathe Erwtisi");
        System.out.println("[8] Emfanisi Posostou Swstwn Apantisewn Ana Aksiologoumeno");
        System.out.println("                                             ");
        System.out.println("[>] To exit press 0.");
        System.out.print("> ");
    }

    static void await() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(850);
        }
    }

    public ArrayList conv(String[] lista){
        ArrayList newList=new ArrayList();
        for(int i=0; i<lista.length; i++){
            newList.add(lista[i]);
        }
        return newList;
    }

    static boolean search(String[] list1, String[] list2){
        boolean x=false;
        int a=0;
        for(String item:list2){
            for(String item2:list1){
                if(item.equals(item2)){
                    a++;
                    break;
                }
            }
        }
        if(a==list2.length){
            x=true;
        }
        return x;
    }

    public static ArrayList<aksiologoumenos> readRatedPersons(String filename) throws IOException 
    {
        ArrayList<aksiologoumenos> ratedPersons = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) 
        {
            line = line.trim();
            if (line.equals("{")) 
            {
                String code = null, name = null, surname = null;
                
                while (!(line = reader.readLine().trim()).equals("}")) 
                {
                    String[] parts = line.split("\\s+", 2);
                    if (parts.length == 2)
                    {
                        String tag = parts[0].toUpperCase();
                        String value = parts[1].replaceAll("\"", "");
                        switch (tag) 
                        {
                            case "CODE":
                                code = value;
                                break;
                            case "NAME":
                                name = value;
                                break;
                            case "SURNAME":
                                surname = value;
                                break;
                            default:
                                continue;
                        }
                    }
                }
                if (code != null && name != null && surname != null) {
                    ratedPersons.add(new aksiologoumenos(Integer.parseInt(code), name, surname));
                }
            }
        }
        reader.close();
        return ratedPersons;
    }

    //readquestions
    //readanswers
    
    //write aksiologoumenoi
    //write questions
    //write answers
}