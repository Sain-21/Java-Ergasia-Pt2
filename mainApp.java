import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;

class mainApp{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        functions.clear_console();

        ArrayList<aksiologoumenos> aksiologoumenoi = functions.readRatedPersons("ratedperson_list.txt");
        ArrayList<erotiseis> questionList = functions.readQuestionList("question_list.txt");
        ArrayList<apantiseis> answerList = functions.readAnswers("answer_list.txt", aksiologoumenoi, questionList);

        Scanner input = new Scanner(System.in);
        int choice = 0;
        functions.clear_console();

        System.out.println("                                          __ ");
        System.out.println("            _ _ _     _                  |  |");
        System.out.println("           | | | |___| |___ ___ _____ ___|  |");
        System.out.println("           | | | | -_| |  _| . |     | -_|__|");
        System.out.println("           |_____|___|_|___|___|_|_|_|___|__|");
        System.out.println("                                             ");
        System.out.println("          -Creators: 3230098, 3230016, 3230078-");
        System.out.println("                                             ");
        

        while (true) {

            functions.menuPrinter();
            
            try {
                choice = Integer.parseInt(input.nextLine());
            } 
            catch (Exception e) {
                System.out.print("[X] To Menu Dexete Mono Arithmous Ws Epipilogi!");
                functions.await();
                functions.clear_console();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    while (true) {
                        int kodikos = 0;
                        String onoma;
                        String eponimo;
                        String epilogi;

                        functions.clear_console();
                        System.out.println("               --Eisagogh Aksiologoumenwn-- ");
                        System.out.println("                                             ");
                        System.out.print("[>] Kodikos Aksiologoumenou(Arithmoi mono!): ");

                        try {
                            kodikos = Integer.parseInt(input.nextLine());

                            boolean foundDouplicate = false;
                            for(aksiologoumenos item: aksiologoumenoi)
                            {
                                if(kodikos == item.getCode())
                                {
                                    foundDouplicate = true;
                                    System.out.print("\n[!] Aytos o aksiologoumenos Yparxei Idi Parakalw Eisagete Neo Kodiko!");
                                    functions.await();
                                    break;
                                }
                            }
    
                            if (!foundDouplicate)
                            {
                                System.out.print("[>] Onoma Aksiologoumenou: ");
                                onoma = input.nextLine();
    
                                System.out.print("[>] Eponimo Aksiologoumenou: ");
                                eponimo = input.nextLine();
    
                                System.out.println("                                             ");
                                System.out.println("[?]: Prosthesi Akolothou Aksiologoumenou?[y/n]");
                                System.out.print("[>] Kodikos: " + kodikos + ", Onoma: " + onoma + ", Eponimo: " + eponimo + "\n> ");
                                epilogi = input.nextLine();
    
                                if (epilogi.equals("y")) {
                                    aksiologoumenoi.add(new aksiologoumenos(kodikos, onoma, eponimo));
                                    System.out.print("[!] O Neos Aksiologoimenos Apothikeutike Me Epitixia! ");
                                    functions.await();
                                    functions.clear_console();
                                    break;
                                }
                                else {
                                    System.out.print("[!] Epistrofi Sto Menu, O Neos Aksiologoumenos Den Apothikeutike!");
                                    functions.await();
                                    functions.clear_console();
                                    break;
                                }
                            }

                            else{
                                continue;
                            }

                        } catch (Exception e) {
                            System.out.print("[X] O Codikos Prepei Na Einai Austira Mono Arithmoi!");
                            functions.await();
                            functions.clear_console();
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        int kodikos = 0;
                        String erotisi;
                        String epilogi;

                        functions.clear_console();
                        System.out.println("             --Eisagogh Erwtisewn-- \n");
                        System.out.println("[>] Kodikos Erwtisis: ");
                        System.out.print("> ");

                        
                        try {
                            kodikos = Integer.parseInt(input.nextLine());
                            boolean foundDuplicate = false;
                            for(erotiseis item: questionList)
                            {
                                if(kodikos == item.getCode())
                                {
                                    foundDuplicate = true;
                                    System.out.print("\n[!] Ayth H Erotisi Yparxei Idi Parakalw Eisagete Neo Kodiko!");
                                    functions.await();
                                    break;
                                }
                            }

                            if (!foundDuplicate)
                            {
                                System.out.println("\n[>] Epelekse Typo Erwtisis: ");
                                System.out.println("[1] Keimeno Me kena ");
                                System.out.println("[2] Erwtisi Me Monaxa Mia Swsth Lexi ");
                                System.out.println("[3] Erwtisi Pollaplis Epilogis\n");
                                System.out.println("[>] Pata 0 h Otidipote Allo Gia Epistrofi Sto Main Menu");
                                System.out.print("> ");
                                
                                epilogi = input.nextLine();

                                if (epilogi.equals("1")) {
                                    functions.clear_console();
                                    System.out.println("             --Erwtisi Me Kena-- \n");
                                    System.out.println("[!] Odigies: Opou Einai Na Mpei Keno Valte '[?]' ");
                                    System.out.println("[>] Parakalo Eisagete To Keimeno.");
                                    System.out.print("> ");
                                
                                    erotisi = input.nextLine();
                                
                                    System.out.println("\n[?]: Prosthesi Akolouthis Erwtisis?[y/n]");
                                    System.out.println("[>] " + erotisi);
                                    System.out.print("> ");
                                
                                    epilogi = input.nextLine();
                                
                                    if (epilogi.equals("y")) {
                                        int numOfKena = 0;
                                        String nextApantisi;
                                    
                                        System.out.println("\n[!] Dimiourgia Apantishs Gia Thn Akolouthi Erwtisi: " + erotisi);
                                        System.out.println("[!] Odigies: Dwse Arithmo Kenwn Kai Epeita Pliktrologise Tis Apantiseis Me Thn Swsti Seira ");
                                        System.out.print("> ");
                                    

                                        try{
                                            numOfKena = Integer.parseInt(input.nextLine());
                                        }catch(Exception e){
                                            System.err.print("[X] Error Lathos Eisagogi Pliroforias! | " + e);
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }

                                        String[] erMeKena = new String[numOfKena];
                                        System.out.println("[!] Dwse Tis Apantiseis Me Tin Swsti Seira! | Aritmos Apantisewn: " + numOfKena);
                                    
                                        for(int i = 0; i < numOfKena; i++)
                                        {
                                            System.out.print("\n> ");
                                            nextApantisi = input.nextLine();
                                            erMeKena[i] = nextApantisi;
                                        }
                                    
                                        System.out.println("[?] Dimiourgia Akolouthis Erwtisis Me Tis Sigkekrimenes Apantiseis?[y/n]");
                                        System.out.println("[*] Erwtisi: " + erotisi);
                                        System.out.println("[*] Apantiseis: " + Arrays.toString(erMeKena));
                                        System.out.print("> ");
                                        epilogi = input.nextLine();
                                    
                                        if (epilogi.equals("y"))
                                        {
                                            questionList.add(new er_kena(kodikos, erotisi ,erMeKena,erMeKena));
                                            System.out.print("[!] H Erotisi Apothikeutike Me Epituxia!");
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }
                                        else
                                        {
                                            System.out.print("Epistrofi Sto Menu");
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }
                                    
                                    } 
                                    else
                                    {
                                        System.out.print("Epistrofi Sto Menu");
                                        functions.await();
                                        functions.clear_console();
                                        break;
                                    }
                                }
                            
                                else if (epilogi.equals("2")) {
                                    functions.clear_console();
                                    System.out.println("                --Erwtisi Monaxa Mia Swsth Lexi-- ");
                                    System.out.println("                                             ");
                                    System.out.println("[>] Parakalo Eisagete Thn Ekfonisi.");
                                    System.out.print("> ");
                                
                                    erotisi = input.nextLine();
                                
                                    System.out.println("                                             ");
                                    System.out.println("[?]: Prosthesi Akolouthis Erwtisis?[y/n]");
                                    System.out.println("[>] " + erotisi);
                                    System.out.print("> ");
                                
                                    epilogi = input.nextLine();
                                
                                    if (epilogi.equals("y")) {
                                        String[] finalApantisi = new String[1];
                                        String finalApant;
                                    
                                        System.out.println("\n[!] Dimiourgia Apantishs Gia Thn Akolouthi Erwtisi: " + erotisi);
                                        System.out.print("> ");
                                        finalApant = input.nextLine();
                                    
                                        System.out.println("[?] Dimiourgia Akolouthis Erwtisis Me Thn Sigkekrimeni Apantisi?[y/n]");
                                        System.out.println("[*] Erwtisi: " + erotisi);
                                        System.out.println("[*] Apantish: " + finalApant);
                                        System.out.print("> ");
                                        epilogi = input.nextLine();
                                    
                                        if (epilogi.equals("y"))
                                        {
                                            finalApantisi[0] = finalApant;
                                            questionList.add(new er_oneWord(kodikos, erotisi,finalApantisi,finalApantisi));
                                            System.out.print("[!] H Erotisi Apothikeutike Me Epituxia!");
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }
                                        else
                                        {
                                            System.out.print("Epistrofi Sto Menu");
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }
                                    
                                    } else{
                                        System.out.print("Epistrofi Sto Menu");
                                        functions.await();
                                        functions.clear_console();
                                        break;
                                    }
                                }
                            
                                else if (epilogi.equals("3")) {
                                    functions.clear_console();
                                    System.out.println("                --Erwtisi Pollaplis Epilogis-- ");
                                    System.out.println("                                             ");
                                    System.out.println("[>] Parakalo Eisagete Thn Ekfonisi.");
                                    System.out.print("> ");
                                
                                    erotisi = input.nextLine();
                                
                                    System.out.println("                                             ");
                                    System.out.println("[?]: Prosthesi Akolouthis Erwtisis?[y/n]");
                                    System.out.println("[>] " + erotisi);
                                    System.out.print("> ");
                                
                                    epilogi = input.nextLine();
                                
                                    if (epilogi.equals("y")) {
                                        int numCantidate = 0;
                                        int numRightCantidate = 0;
                                        String nextApantisi;
                                        int nextRightApantisi;
                                    
                                        System.out.println("\n[!] Dimiourgia Apantishs Gia Thn Akolouthi Erwtisi: " + erotisi);
                                        System.out.println("[!] Odigies: Dwse Arithmo Apantisewn Kai Epeita Arithmo Swntwn Apantisewn, \nMeta Pliktrologise Tis Ypopsifies Apantiseis ");
                                
                                        System.out.print("[>] Dwse Arithmo Apantisewn: ");
                                        numCantidate = Integer.parseInt(input.nextLine());
                                    
                                        System.out.print("[>] Dwse Arithmo Swstwn Apantisewn: ");
                                        numRightCantidate = Integer.parseInt(input.nextLine());
                                    
                                        String[] erMultCh = new String[numCantidate];
                                        String[] erMultCh_Right = new String[numRightCantidate];
                                    
                                        System.out.println("[!] Dwse Tis Apantiseis | Aritmos Apantisewn: " + numCantidate);
                                    
                                        for(int i = 0; i < numCantidate; i++)
                                        {
                                            System.out.print("\n> ");
                                            nextApantisi = input.nextLine();
                                            erMultCh[i] = nextApantisi;
                                        }
                                    
                                        System.out.println("[!] Telos Epelekse Poies/a Einai Oi/H Swsth/es Apantisi/eis");
                                        System.out.println("[!] Odigies: Apo Tin Parakato Lista Me apantiseis \n--  (PARADEIGMA)An H Swsti Apantisi Einai H 2 \n--  Tote Pliktrologise Ton Arithmo '2'");

                                        int cnt = 1;
                                        for(String item : erMultCh)
                                        {
                                            System.out.println("["+ cnt++ +"] " + item);
                                        }

                                        if(numRightCantidate>0)
                                        {
                                            System.out.println("\n[!] Oi Swstes Apantiseis Einai: " + numRightCantidate);
                                            for(int i = 0; i < numRightCantidate; i++)
                                            {
                                                System.out.print("\n> ");
                                                nextRightApantisi = Integer.parseInt(input.nextLine());
                                                erMultCh_Right[i] = erMultCh[nextRightApantisi-1];
                                            }
                                        
                                            System.out.println("[?] Dimiourgia Akolouthis Erwtisis Me Tis Sigkekrimenes Apantiseis?[y/n]");
                                            System.out.println("[*] Erwtisi: " + erotisi);
                                            System.out.println("[*] Swsth/es Apantish/eis: " + Arrays.toString(erMultCh_Right));
                                        
                                            System.out.print("> ");
                                            epilogi = input.nextLine();
                                        
                                            if (epilogi.equals("y"))
                                            {
                                                questionList.add(new er_multChoice(kodikos, erotisi,erMultCh,erMultCh_Right));
                                                System.out.print("[!] H Erotisi Apothikeutike Me Epituxia!");
                                                functions.await();
                                                functions.clear_console();
                                                break;
                                            }
                                            else
                                            {
                                                functions.clear_console();
                                                break;
                                            }
                                        }
                                        else{
                                            System.out.print("[X] Oi Swstes Apantiseis Prepei Na Einai Toulaxiston Mia!");
                                            functions.await();
                                            functions.clear_console();
                                        }
                                    
                                        }
                                        else{
                                            System.out.print("Epistrofi Sto Menu");
                                            functions.await();
                                            functions.clear_console();
                                            break;
                                        }
                                    }
                                
                                    else
                                    {
                                        System.out.print("Epistrofi Sto Menu");
                                        functions.await();
                                        functions.clear_console();
                                        break;
                                    }
                            } 
                        }

                        catch (Exception e) {
                            System.err.print("[X] " + e + "!");
                            functions.await();
                            functions.clear_console();
                        }
                    }
                break;

                case 3:
                    while(true){
                        functions.clear_console();

                        System.out.println("                   -Eisagogh Apantisewn-\n");

                        boolean foundAksiolog=false;
                        System.out.println("Aksiologoumenoi:");
                        for(aksiologoumenos item: aksiologoumenoi){
                            System.out.println(item.toString());
                        }


                        System.out.println("\n"+"[>] Epelekse Kodiko Aksiologoumenou Pou Tha Apantisei Mia Erotisi: ");
                        System.out.print("> ");

                        try{
                            int epilogi=Integer.parseInt(input.nextLine());


                            int pos1=0;
    
                            for(int i=0; i<aksiologoumenoi.size(); i++){   
                                if(aksiologoumenoi.get(i).getCode() == epilogi){
                                    foundAksiolog=true;
                                    pos1=i;
                                    break;
                                }
                            
                            }
    
                            if(foundAksiolog){
    
                                int er_code;
                                boolean foundErot = false;
    
                                System.out.println("\nErotiseis:");
    
                                for(erotiseis item: questionList){
                                    System.out.println(item.toString());
                                }
                            
                                System.out.println("\n[>] Epelekse Ton Kodiko Tis Erwtisis Pou Tha Apantiseis: \n");
    
                                System.out.print("> ");
                                er_code= Integer.parseInt(input.nextLine());
    
                                int pos2=0;
                                for(int i=0; i<questionList.size(); i++){
                                    if(questionList.get(i).getCode() == er_code){
                                        foundErot = true;
                                        pos2=i;
                                        break;
                                    }
                                }
    
                                if (foundErot)
                                {
                                    boolean aa=false; //already answered

                                    for(apantiseis item : answerList){
                                        if(item.getStudent().getCode() == epilogi && item.getErot().getCode() == er_code)
                                        {
                                            aa=true;
                                        }
                                    }

                                    if(!aa)
                                    {
                                        System.out.println(questionList.get(pos2).getEkfonisi());
                                    
                                        if(questionList.get(pos2) instanceof er_kena){
                                            System.out.println("[*] Apantiseis Me Mperdemenh Seira: "); 
                                            erotiseis.printApantiseis(questionList.get(pos2).getAnswer());
                                            System.out.println("Vale Tis Lexeis Stin Swsti Seira, ");
                                            System.out.println("Pliktrologontas Mia-Mia Tis Lexeis Stin Seira Pou Theorite Eseis Swsth.");
                                        
                                            int b=questionList.get(pos2).getAnswer().length;
                                            String[] listaAp= new String[b];
                                            String c;
                                            for(int i=0; i<b; i++){
                                                System.out.print("\n>");

                                                c=input.nextLine();
                                                listaAp[i]=c;
                                            }
                                        
                                            answerList.add(new ap_kena( aksiologoumenoi.get(pos1),questionList.get(pos2), listaAp));

                                            System.out.println("[!] H Apantisi Apothikeutike Me Epitixia!");
                                            System.out.print("[!] Epistrofi sto menu");
                                            functions.await();
                                            functions.clear_console();
                                        }
                                    
                                        else if(questionList.get(pos2) instanceof er_oneWord){
                                            System.out.print("Dwse Monolektiki Apantisi:  ");
                                            String[] app =new String[1];
                                            app[0]=input.nextLine();
                                        
                                            answerList.add(new ap_oneWord(aksiologoumenoi.get(pos1), questionList.get(pos2), app));

                                            System.out.println("[!] H Apantisi Apothikeutike Me Epitixia!");
                                            System.out.print("[!] Epistrofi sto menu");
                                            functions.await();
                                            functions.clear_console();
                                        }
                                    
                                        else{
                                            for(String item:(questionList.get(pos2).getAnswer()))
                                            {
                                                System.out.println("> "+item);
                                            }
                                            ArrayList<String> given=new ArrayList<String>();

                                            System.out.print("Dialexe Swstes epiloges H 0 Gia Na Teleiwseis: \n");
                                        
                                            String m;
                                            for(int i=0; i<questionList.get(pos2).getAnswer().length; i++)
                                            {
                                            
                                                System.out.print(">> ");
                                                m=input.nextLine();
                                            
                                                if (m.equals("0"))
                                                {
                                                    break;
                                                }
                                                else
                                                {
                                                    given.add(m);
                                                }
                                            }
                                            String[] app= new String[given.size()];
                                        
                                            for(int i=0; i<given.size(); i++){
                                                app[i]=given.get(i);
                                            }

                                            answerList.add(new ap_multiChoice(aksiologoumenoi.get(pos1), questionList.get(pos2), app));

                                            System.out.println("[!] H Apantisi Apothikeutike Me Epitixia!");
                                            System.out.print("[!] Epistrofi sto menu");
                                            functions.await();
                                            functions.clear_console();
                                        }

                                        break;
                                    }

                                    else{
                                        System.out.println("[!] H Erwtisi Pou Epilekses Einai Idi Apantimeni Apo Ayton ton Aksiologoumeno!");
                                        System.out.print("[!] Epistrofi sto menu");
                                        functions.await();
                                        functions.clear_console();
                                        break;
                                    }
                                }
                                
    
                                else{
                                    System.out.println("[!] H Erotisi Pou Ypovalate Den Yparxei Stin Lista!");
                                    System.out.println("[!]Dwse 0 Gia Epistrofi Sto Menu H Otidhpote Allo Gia Nea Prospatheia");
                                    System.out.print("> ");
                                    if(input.nextLine().equals("0")){break;}
                                    functions.clear_console();
                                }
                            
                            }
                            else
                            {
                                System.out.println("[!] O Aksiologoumenos Den Uparxei Sth Lista, Prospathise Jana!");
                                System.out.println("[!] Dwse 0 Gia Epistrofi Sto Menu H Otidhpote Allo Gia Nea Prospatheia");
                                System.out.print("> ");
                                if(input.nextLine().equals("0"))
                                {
                                    functions.clear_console();
                                    break;
                                }
                            }
                        }
                        catch(Exception e)
                        {
                            System.err.print("[X] " + e + "!");
                            functions.await();
                            functions.clear_console();
                        }
                    }
                    break;

                case 4:

                    functions.clear_console();
                    System.out.println("                               --Erotiseis-- \n");
                    for(erotiseis item:questionList){
                        System.out.println(item.toString());
                    }

                    System.out.println("\n[>] To exit, to Main menu press 0 or any other key.");
                    System.out.print("> ");
                    input.nextLine();
                    System.out.print("[!] Epistrofi Sto Menu");
                    functions.await();
                    functions.clear_console();
                    break;

                case 5:
                    functions.clear_console();
                    
                    while(true)
                    {
                        System.out.println("                  -Emfanisi Apantisewn Enos Aksiologoumenou-\n");
                        int code;
                        boolean found = false;

                        for(aksiologoumenos item: aksiologoumenoi){
                            System.out.println(item.toString());
                        }

                        System.out.println("\nEpeleje Ajiologoumeno Plhktrologontas Ton Kwdiko Toy");
                        System.out.print("> ");
                        try{
                            code = Integer.parseInt(input.nextLine());
                        
                            for(aksiologoumenos items : aksiologoumenoi){   
                                if(items.getCode() == code){
                                    System.out.println("\n"+items.toString());
                                    found = true;
                                    for(apantiseis item : answerList)
                                    {
                                        if(item.getStudent() == items)
                                        {
                                            System.out.println("[*] Erotisi: " + item.getErot().getEkfonisi() + "| Apantisi: " + Arrays.toString(item.getListaAp()));
                                        }
                                    }
                                }
                            }

                            if(!found)
                            {
                                System.out.print("[!] O Aksiologoumenos Den Uparxei Sth Lista, Prospathise Jana!");
                                functions.await();
                                break;
                            }

                            System.out.println("[!] Gia Epistofi Sto Main Menu Pata 0, Pata Otidipote Allo Gia Epaneisagogi Aksiologoumenou");
                            System.out.print("> ");
                            String epilogi = input.nextLine();

                            if(epilogi.equals("0"))
                            {
                                System.out.print("[!] Epistrofi sto menu");
                                functions.await();
                                break;
                            }
                            else{
                                functions.clear_console();
                                continue;
                            }
                        }
                        catch(Exception e){
                            System.err.print("[X] " + e + "!");
                            functions.await();
                            functions.clear_console();
                        }
                    }
                    functions.clear_console();
                    break;

                case 6:
                    functions.clear_console();

                    System.out.println("               -Emfanisi Plithous Swstwn Apantisewn Ana Aksiologoumenou-\n");

                    ArrayList<aksiologoumenos> copyAks=new ArrayList();

                    for(aksiologoumenos item:aksiologoumenoi){
                        copyAks.add(item);
                    }

                    int a = copyAks.size();
                    aksiologoumenos max;
                    while(a > 0){
                        max=(aksiologoumenos)copyAks.get(0);
                        for(aksiologoumenos item:copyAks){
                            if(item.getCorr()>max.getCorr()){
                                max=item;
                            }
                        }
                        System.out.println(max+" | Exei "+max.getCorr()+" Swstes Apantiseis");
                        copyAks.remove(max);
                        a--;
                    }
                    System.out.println("\n[!] Pathse Otidhpote Gia Epistrofi Sto Menu");
                    System.out.print("> ");
                    input.nextLine();
                    System.out.print("Epistrofi Sto Menu");
                    functions.await();
                    functions.clear_console();
                    break;

                case 7:

                    functions.clear_console();
                    System.out.println("             --Emfanisi Posostou Swstwn Apantisewn Gia Kathe Erwtisi-- \n");
                    
                    ArrayList<erotiseis> copyEr=new ArrayList();

                    for(erotiseis item:questionList){
                        copyEr.add(item);
                    }

                    int b = copyEr.size();
                    int d;
                    int f;
                    int g;
                    int h;
                    erotiseis max1;
                    while(b > 0){
                        max1=(erotiseis)copyEr.get(0);
                        d=max1.getAns();
                        f=max1.getCors();

                        if(d == 0)
                        {
                            max1.makePerc(f, 1);
                        }
                        else{
                            max1.makePerc(f, d);
                        }

                        for(erotiseis item:copyEr){
                            if(item instanceof er_kena && ((er_kena)item).getAns() != 0){
                                g=((er_kena)item).getCors();
                                h=((er_kena)item).getAns();
                                ((er_kena)item).makePerc(g , h);
                                item.getPerc();

                                if(item.getPerc()>max1.getPerc()){
                                    max1=item;
                                }
                            }
                            else if(item instanceof er_multChoice && ((er_multChoice)item).getAns() != 0){
                                g=((er_multChoice)item).getCors();
                                h=((er_multChoice)item).getAns();
                                ((er_multChoice)item).makePerc(g , h);
                                item.getPerc();

                                if(item.getPerc()>max1.getPerc()){
                                    max1=item;
                                }
                            }
                            else if(item instanceof er_oneWord && ((er_oneWord)item).getAns() != 0){
                                g=((er_oneWord)item).getCors();
                                h=((er_oneWord)item).getAns();
                                ((er_oneWord)item).makePerc(g , h);
                                item.getPerc();
                                if(item.getPerc()>max1.getPerc()){
                                max1=item;
                                }
                            }
                        }

                        DecimalFormat df = new DecimalFormat("#.00");

                        if(max1.getPerc() == 0)
                        {
                            System.out.println(">> "+max1+" <<   0.00 %");
                        }
                        else
                        {
                            System.out.println(">> "+max1+" <<   "+df.format(max1.getPerc())+" %");
                        }
                        
                        copyEr.remove(max1);
                        b--;
                    }
                    System.out.println("\n[!] Pathse Otidhpote Gia Epistrofi Sto Menu");
                    System.out.print("> ");
                    input.nextLine();
                    System.out.print("Epistrofi Sto Menu");
                    functions.await();
                    functions.clear_console();
                    break;

                case 8:

                    functions.clear_console();
                    System.out.println("             --Emfanisi Posostou Swstwn Apantisewn Gia Kathe Aksiologoumeno-- \n");
                    
                    ArrayList<aksiologoumenos> copyAksi=new ArrayList();

                    for(aksiologoumenos item:aksiologoumenoi){
                        copyAksi.add(item);
                    }

                    int q = copyAksi.size();
                    int w;
                    int e;
                    int r;
                    int t;
                    aksiologoumenos max2;
                    while(q > 0){
                        max2=(aksiologoumenos)copyAksi.get(0);
                        w=max2.getErot();
                        e=max2.getCorr();

                        if(w == 0)
                        {
                            max2.makePercAks(e, 1);
                        }
                        else{
                            max2.makePercAks(e, w);
                        }

                        for(aksiologoumenos item : copyAksi){
                            if(item.getErot() != 0){
                                r=item.getCorr();
                                t=item.getErot();
                                item.makePercAks(r , t);
                                item.getPercAks();

                                if(item.getPercAks()>max2.getPercAks()){
                                    max2=item;
                                }
                            }
                        }

                        DecimalFormat df = new DecimalFormat("#.00");

                        if(max2.getPercAks() == 0)
                        {
                            System.out.println(">> "+max2+" <<   0.00 %");
                        }
                        else
                        {
                            System.out.println(">> "+max2+" <<   "+df.format(max2.getPercAks())+" %");
                        }

                        copyAksi.remove(max2);
                        q--;
                    }
                    System.out.println("\n[!] Pathse Otidhpote Gia Epistrofi Sto Menu");
                    System.out.print("> ");
                    input.nextLine();
                    System.out.print("Epistrofi Sto Menu");
                    functions.await();
                    functions.clear_console();
                    break;

                default:
                    functions.clear_console();
                    break;
            }

            try 
            {
                functions.writeRatedPersons(aksiologoumenoi, "ratedperson_list.txt");
                functions.writeQuestions(questionList, "question_list.txt");
                functions.writeAnswers(answerList, "answer_list.txt");
            }
            catch(IOException e)
            {
                System.out.println("[X] H eggrafi twn arxeiwn apetixe!");
                System.out.println("[X] Provlimata: \n");
                e.printStackTrace();
            }
            

            if(choice == 0)
            {
                System.out.print("\nExiting");
                functions.await();
                functions.clear_console();
                break;
            }
        }
    }
}