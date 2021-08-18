public class Vartotojas {
    String vardas;
    String pavarde;
    Integer asmensKodas;

    public Vartotojas(String vardas, String pavarde, Integer asmensKodas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.asmensKodas = asmensKodas;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Integer getAsmensKodas() {
        return asmensKodas;
    }

    public void setAsmensKodas(Integer asmensKodas) {
        this.asmensKodas = asmensKodas;
    }

    @Override
    public String toString() {
        return "Vartotojas{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", asmensKodas=" + asmensKodas +
                '}';
    }
}
