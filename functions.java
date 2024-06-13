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

    //read rated persons
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
                else{

                }
            }
        }
        reader.close();
        return ratedPersons;
    }

    //readquestions
    public static ArrayList<erotiseis> readQuestionList(String filename) throws IOException
    {
        ArrayList<erotiseis> readQuestions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) 
        {
            line = line.trim();
            if (line.equals("{")) 
            {
                String code = null, description = null;
                ArrayList<String> ansList = new ArrayList<String>();
                ArrayList<String> rightAnsList = new ArrayList<String>();
                String typeEnum = "";

                while (!(line = reader.readLine().trim()).equals("}")) 
                {
                    String[] parts = line.split("\\s+", 2);
                    if (parts.length == 2)
                    {
                        String tag = parts[0].toUpperCase();
                        String value = parts[1].replaceAll("\"", "");
                        
                        switch (tag) 
                        {
                            case "TYPE":
                                if(value.equals("MC"))
                                {
                                    typeEnum = value;
                                }

                                if(value.equals("WORD"))
                                {
                                    typeEnum = value;
                                }

                                if(value.equals("FILL"))
                                {
                                    typeEnum = value;
                                }
                                break;

                            case "CODE":
                                code = value;
                                break;
                            case "DECSR":
                                description = value;
                                break;
                            case "ANSWERS":
                                ansList.addAll(Arrays.asList(value.split(",")));
                                break;
                                
                            case "RIGHT_ANSWERS":
                                rightAnsList.addAll(Arrays.asList(value.split(",")));
                                break;
                            
                            default:
                                continue;
                        }
                    }
                }

                if(typeEnum.equals("MC"))
                {
                    String[] ansListHolder = new String[ansList.size()];
                    String[] rightAnsListHolder = new String[rightAnsList.size()];

                    if(code != null && description != null && ansList != null && rightAnsList != null){
                        for(int i = 0; i < ansList.size(); i++)
                        {
                            ansListHolder[i] = ansList.get(i);
                        }

                        for(int i = 0; i < rightAnsList.size(); i++)
                        {
                            rightAnsListHolder[i] = rightAnsList.get(i);
                        }

                        readQuestions.add(new er_multChoice(Integer.parseInt(code), description, ansListHolder, rightAnsListHolder)) ;
                    }
                }

                if(typeEnum.equals("WORD"))
                {
                    String[] ansListHolder = new String[ansList.size()];
                    String[] rightAnsListHolder = new String[rightAnsList.size()];

                    if(code != null && description != null && ansList != null && rightAnsList != null)
                    {
                        for(int i = 0; i < ansList.size(); i++)
                        {
                            ansListHolder[i] = ansList.get(i);
                        }

                        for(int i = 0; i < rightAnsList.size(); i++)
                        {
                            rightAnsListHolder[i] = rightAnsList.get(i);
                        }

                        readQuestions.add(new er_oneWord(Integer.parseInt(code), description, ansListHolder, rightAnsListHolder)) ;
                    }
                }

                if(typeEnum.equals("FILL"))
                {
                    String[] ansListHolder = new String[ansList.size()];
                    String[] rightAnsListHolder = new String[rightAnsList.size()];

                    if(code != null && description != null && ansList != null)
                    {
                        for(int i = 0; i < ansList.size(); i++)
                        {
                            ansListHolder[i] = ansList.get(i);
                        }

                        for(int i = 0; i < rightAnsList.size(); i++)
                        {
                            rightAnsListHolder[i] = rightAnsList.get(i);
                        }

                        readQuestions.add(new er_kena(Integer.parseInt(code), description, ansListHolder,ansListHolder));
                    }
                }
            }
        }
        reader.close();
        return readQuestions;
    }

    //readanswers
    
    //write aksiologoumenoi
    //write questions
    //write answers
}