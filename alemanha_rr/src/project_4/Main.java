package project_4;

public class Main {

    public static void main(String[] args) {

        // TODO : To create a new "Konto" Object, we have to first create a new "Inhaber" Object. Any way to circumvent this?
        Inhaber thomas = new Inhaber("Thomas", "Schmidt", "456215");
        Konto thomaskonto = new SparbuchKonto(123456, thomas, 100);
        Inhaber sabine = new Inhaber("Sabine", "Wolf", "978942");
        Konto sabinekonto = new SparbuchKonto(987654, sabine, 650);
        Inhaber michael = new Inhaber("Michael","Jackson","1337");
        Konto michaelkonto = new GiroKonto(6969,michael,5);
//
//        System.out.println(thomaskonto.getBalance());
//        thomaskonto.calculateInterest();
//        System.out.println(thomaskonto.getBalance());
//
//
//        int arraySize = 5;
//        Konto[] konten = new Konto[arraySize];
//
//        konten[0] = thomaskonto;
//        konten[3] = sabinekonto;
//        konten[2] = michaelkonto;
//        System.out.println(Arrays.deepToString(konten));

        AccountManager am = new AccountManager(2);
//        System.out.println(am);
        am.addKonto(thomaskonto);
        am.addKonto(sabinekonto);
        am.addKonto(michaelkonto);
        System.out.println(am);
        System.out.println("---------------------------");
        am.removeKonto(123456);
        System.out.println(am);

//        am.removeKonto(987654);


//        System.out.println(Arrays.deepToString(konten));
        //////////////////////TESTING STUFF///////////////////////////////////
        //int remove_index = toIntExact(konten[i].getKontonummer());
        //  System.out.println(remove_index);
                    /*
         if (kontonummerSearch == konten[remove_index].getKontonummer()){
            System.out.println(remove_index);
        }
        else {
            System.out.println("this aint it chief");
        }
        System.out.println();

       // String printarray = ("Original Array: " + Arrays.toString(konten[0]));
        System.out.println(Arrays.deepToString(konten));

                    */

    }


}

