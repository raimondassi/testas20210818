import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Vartotojas> vartotojai = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("programa veiks kol nepaspausi c");
        String baigiam = scanner.next();
        while (!baigiam.equals("c")) {
            System.out.println("iveskite varda");
            String vardas = scanner.next();
            System.out.println("iveskite pavarde");
            String pavarde = scanner.next();
            System.out.println("iveskite asmens koda");
            Integer asmensKodas = scanner.nextInt();
            if (main.arNaujasVartotojas(asmensKodas)) {
                main.irasomeVartotojus(vardas, pavarde, asmensKodas);
            } else {
                System.out.println("vartotojas egzistuoja");
            }
            System.out.println("vedam toliau ar baigiam su c?");
            baigiam = scanner.next();
        }
        main.viskaSurasomeIFaila(main.vartotojai);
        System.out.println("vartotoju failas sukurtas");
        System.out.println("jei nori atspausdinti vartotojus spausk s");
        String spausdinam = scanner.next();
        if (spausdinam.equals("s")) {
            spausdinameSarasa(main.vartotojai);
        }
    }
//su failu butu geriau, bet nespejau
//    private static void spausdinameSarasa(File vartotojuFailas) {
//    }

    private static void spausdinameSarasa(List<Vartotojas> vartotojai) {
        for (Vartotojas vartotojas : vartotojai) {
            System.out.println(vartotojas.toString());
        }
    }

    public void irasomeVartotojus(String vardas, String pavarde, Integer asmensKodas) {
        vartotojai.add(new Vartotojas(vardas, pavarde, asmensKodas));
    }

    public void viskaSurasomeIFaila(List<Vartotojas> vartotojai) {
        File vartotojuFailas = pasikuriameVartotojuFaila();
        try {
            mapper.writeValue(vartotojuFailas, vartotojai);
        } catch (IOException e) {
            System.out.println("klaida: vartotojai i faila nesurasyti" + e);
        }
    }

    private File pasikuriameVartotojuFaila() {
        File vartotojuFailas = new File("VisiVartotojai.json");
        if (!vartotojuFailas.exists()) {
            try {
                vartotojuFailas.createNewFile();
            } catch (IOException e) {
                System.out.println("vartotoju failas nesukurtas" + e);
            }
        }
        return vartotojuFailas;
    }

    private Boolean arNaujasVartotojas(Integer asmensKodas) {
        Boolean arNaujas = true;
        for (Vartotojas vartotojas : vartotojai) {
            if (vartotojas.getAsmensKodas().equals(asmensKodas)) {
                arNaujas = false;
            }
        }
        return arNaujas;
    }
}
