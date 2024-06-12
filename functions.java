import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void readRatedPersons(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Επεξεργασία της γραμμής
                    if (line.trim().equalsIgnoreCase("{")) {
                        RatedPerson person = new RatedPerson();
                        while (!(line = br.readLine().trim()).equalsIgnoreCase("}")) {
                            if (line.toUpperCase().startsWith("CODE")) {
                                person.setCode(line.split("\\s+")[1]);
                            } else if (line.toUpperCase().startsWith("SURNAME")) {
                                person.setSurname(line.split("\\s+")[1].replace("\"", ""));
                            } else if (line.toUpperCase().startsWith("FIRSTNAME")) {
                                person.setFirstname(line.split("\\s+")[1].replace("\"", ""));
                            }
                        }
                        ratedPersons.add(person);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    public static void readQuestions(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("{")) {
                    Question question = new Question();
                    while (!(line = br.readLine().trim()).equalsIgnoreCase("}")) {
                        if (line.toUpperCase().startsWith("TYPE")) {
                            question.setType(line.split("\\s+")[1]);
                        } else if (line.toUpperCase().startsWith("CODE")) {
                            question.setCode(line.split("\\s+")[1]);
                        } else if (line.toUpperCase().startsWith("DECSR")) {
                            question.setDescr(line.split("\\s+", 2)[1].replace("\"", ""));
                        } // Προσθέστε την επεξεργασία των υπόλοιπων χαρακτηριστικών
                    }
                    questions.add(question);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAnswers(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("{")) {
                    Answer answer = new Answer();
                    while (!(line = br.readLine().trim()).equalsIgnoreCase("}")) {
                        if (line.toUpperCase().startsWith("TYPE")) {
                            answer.setType(line.split("\\s+")[1]);
                        } else if (line.toUpperCase().startsWith("RATEDPERSON_CODE")) {
                            answer.setRatedPersonCode(line.split("\\s+")[1]);
                        } else if (line.toUpperCase().startsWith("QUESTION_CODE")) {
                            answer.setQuestionCode(line.split("\\s+")[1]);
                        } // Προσθέστε την επεξεργασία των υπόλοιπων χαρακτηριστικών
                    }
                    answers.add(answer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeQuestions(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("QUESTION_LIST\n{\n");
            for (Question q : questions) {
                bw.write("   QUESTION\n   {\n");
                bw.write("      TYPE " + q.getType() + "\n");
                bw.write("      CODE " + q.getCode() + "\n");
                bw.write("      DECSR \"" + q.getDescr() + "\"\n");
                // Προσθέστε την εγγραφή των υπόλοιπων χαρακτηριστικών
                bw.write("   }\n");
            }
            bw.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAnswers(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("ANSWER_LIST\n{\n");
            for (Answer a : answers) {
                bw.write("   ANSWER\n   {\n");
                bw.write("      TYPE " + a.getType() + "\n");
                bw.write("      RATEDPERSON_CODE " + a.getRatedPersonCode() + "\n");
                bw.write("      QUESTION_CODE " + a.getQuestionCode() + "\n");
                // Προσθέστε την εγγραφή των υπόλοιπων χαρακτηριστικών
                bw.write("   }\n");
            }
            bw.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}