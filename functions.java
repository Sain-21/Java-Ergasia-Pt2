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
        Scanner input = new Scanner(System.in);

        try
        {   
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
                    if (code != null && name != null && surname != null) 
                    {
                        ratedPersons.add(new aksiologoumenos(Integer.parseInt(code), name, surname));
                    }
                    else
                    {
                        System.out.println("[!] Ypirkse Provlima Me Tin Anagnosi Enos Aksiologoumenou!");
                        System.out.println("[!] Parakalw Elenkste To Arxeio: " + filename);
                        System.out.println("[!] To Programa Tha Sinexisei Tin Leipourgeia Tou Kanonika, Patiste Otidipote Gia Tin Sinexeia.");
                        input.nextLine();
                        continue;
                    }
                }
            }
            reader.close();
            return ratedPersons;
        }
        catch(IOException e)
        {
            System.out.println("[X] Ypirkse Provlima Stin Anagnosi tou arxeiou: " + filename);
            System.out.println("[X] Perisoteres Plirofories Sxetika Me To Thema: \n");
            e.printStackTrace();
            System. exit(0);
            return null;
        }
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

                else if(typeEnum.equals("WORD"))
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

                else if(typeEnum.equals("FILL"))
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
    public static ArrayList<apantiseis> readAnswers(String filename,ArrayList<aksiologoumenos> aksiologoumenoi,ArrayList<erotiseis> questionList) throws IOException{

        ArrayList<apantiseis> readAnswers = new ArrayList<apantiseis>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) 
        {
            line = line.trim();
            if (line.equals("{")) 
            {
                ArrayList<String> given = new ArrayList<String>();
                aksiologoumenos stud = null;
                erotiseis ques = null;

                while (!(line = reader.readLine().trim()).equals("}")) 
                {
                    String[] parts = line.split("\\s+", 2);
                    if (parts.length == 2)
                    {
                        String tag = parts[0].toUpperCase();
                        String value = parts[1].replaceAll("\"", "");
                        
                        switch (tag) 
                        {
                            case "RATEDPERSON_CODE":
                                for(aksiologoumenos item : aksiologoumenoi){
                                    if(item.getCode() == Integer.parseInt(value)){
                                        stud=item;
                                    }
                                }
                                break;

                            case "QUES_CODE":
                                for(erotiseis item : questionList){
                                    if(item.getCode() == Integer.parseInt(value)){
                                        ques=item;
                                    }
                                }
                                break;
                            case "GIVEN":
                                given.addAll(Arrays.asList(value.split(",")));
                                break;
                            default:
                                continue;
                        }
                    }
                }

                if (ques instanceof er_kena)
                {
                    String[] givenListHolder = new String[given.size()];

                    if(stud != null && ques != null && given != null)
                    {
                        for(int i = 0; i < given.size(); i++)
                        {
                            givenListHolder[i] = given.get(i);
                        }

                        readAnswers.add(new ap_kena(stud, ques, givenListHolder));
                    }
                }

                if (ques instanceof er_oneWord)
                {
                    String[] givenListHolder = new String[given.size()];

                    if(stud != null && ques != null && given != null)
                    {
                        for(int i = 0; i < given.size(); i++)
                        {
                            givenListHolder[i] = given.get(i);
                        }

                        readAnswers.add(new ap_oneWord(stud, ques, givenListHolder));
                    }
                }

                if (ques instanceof er_multChoice)
                {
                    String[] givenListHolder = new String[given.size()];

                    if(stud != null && ques != null && given != null)
                    {
                        for(int i = 0; i < given.size(); i++)
                        {
                            givenListHolder[i] = given.get(i);
                        }

                        readAnswers.add(new ap_multiChoice(stud, ques, givenListHolder));
                    }
                }
            }
        }
        reader.close();
        return readAnswers;
    }
    
    //write aksiologoumenoi
    public static void writeRatedPersons(ArrayList<aksiologoumenos> ratedPersons, String filename) throws IOException 
    {
        if (ratedPersons.isEmpty()) {
            System.out.println("The ratedPersons list is empty!");
        }

        else
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("RATED_PERSON_LIST\n{\n");
            for (aksiologoumenos item : ratedPersons)
            {
                writer.write("   RATED_PERSON\n   {\n");
                writer.write("      CODE " + item.getCode() + "\n");
                writer.write("      NAME " + item.getName() + "\n");
                writer.write("      SURNAME " + item.getSurname() + "\n");
                writer.write("   }\n");
            }
            writer.write("}\n");
            writer.close();
        }
    }
    
    //write questions
    public static void writeQuestions(ArrayList<erotiseis> questions, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("QUESTION_LIST\n{\n");

        for (erotiseis item : questions) {
            String replacement= "";
            if(item instanceof er_multChoice)
            {
                writer.write("    QUESTION\n    {\n");
                writer.write("        TYPE MC\n");
                writer.write("        CODE " + item.getCode() + "\n");
                writer.write("        DECSR \"" + item.getEkfonisi() + "\"\n");

                replacement = "\"" + String.join(",", item.getAnswer()) + "\"";
                writer.write("        ANSWERS " + replacement + "\n");

                replacement = "\"" + String.join(",", item.getRightAnswers()) + "\"";
                writer.write("        RIGHT_ANSWERS " + replacement + "\n");
                writer.write("    }\n");
            }
            
            if(item instanceof er_kena)
            {
                writer.write("    QUESTION\n    {\n");
                writer.write("        TYPE FILL\n");
                writer.write("        CODE " + item.getCode() + "\n");
                writer.write("        DECSR \"" + item.getEkfonisi() + "\"\n");

                replacement = "\"" + String.join(",", item.getAnswer()) + "\"";
                writer.write("        ANSWERS " + replacement + "\n");
                writer.write("    }\n");
            }

            if(item instanceof er_oneWord)
            {
                writer.write("    QUESTION\n    {\n");
                writer.write("        TYPE WORD\n");
                writer.write("        CODE " + item.getCode() + "\n");
                writer.write("        DECSR \"" + item.getEkfonisi() + "\"\n");

                replacement = "\"" + String.join(",", item.getAnswer()) + "\"";
                writer.write("        ANSWERS " + replacement + "\n");

                replacement = "\"" + String.join(",", item.getRightAnswers()) + "\"";
                writer.write("        RIGHT_ANSWERS " + replacement + "\n");
                writer.write("    }\n");
            }
        }
        writer.write("}\n");
        writer.close();
    }

    //write answers
    public static void writeAnswers(ArrayList<apantiseis> answerList, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("ANSWER_LIST\n{\n");

        for (apantiseis item : answerList) {
            String replacement= "";

            writer.write("    ANSWER\n    {\n");
            writer.write("        RATEDPERSON_CODE " + item.getStudent().getCode() + "\n");
            writer.write("        QUES_CODE " + item.getErot().getCode() + "\n");

            replacement = "\"" + String.join(",", item.getListaAp()) + "\"";
            writer.write("        GIVEN " + replacement + "\n");

            writer.write("    }\n"); 
        }
        writer.write("}\n");
        writer.close();
    }
}