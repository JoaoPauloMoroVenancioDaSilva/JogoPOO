public class Esqueleto extends Inimigo{ //Inimigo comum no país do "Velho-Oeste"
    private String classe;
    private String nome;
    private int HP;
    private int ATTACK;
    private int DEFENCE;
    private int SPEED;
    private int AP;

    public Esqueleto(String classe, String nome, int HP, int ATTACK, int DEFENCE, int SPEED, int AP) {
        this.classe = classe;
        this.nome = nome;
        this.HP = HP;
        this.ATTACK = ATTACK;
        this.DEFENCE = DEFENCE;
        this.SPEED = SPEED;
        this.AP = AP;
    }

    public void imprimirAtributos(){
        System.out.println("Nome: " + nome + ", HP: " + HP + ", ATTACK: " + ATTACK + ", DEFENCE: " + DEFENCE);
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getATTACK() {
        return ATTACK;
    }

    public void setATTACK(int ATTACK) {
        this.ATTACK = ATTACK;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public int getDEFENCE() {
        return DEFENCE;
    }

    public void setDEFENCE(int DEFENCE) {
        this.DEFENCE = DEFENCE;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }


    public void Atacar(Espadachim espadachim) {
        System.out.println("Esqueleto ataca " + espadachim.getNome());
        espadachim.tomarDano(ATTACK);
    }

    public boolean estaVivo() {
        return HP > 0;
    }

    public void tomarDano(int dano) {
        int effectiveDamage = dano - DEFENCE;
        if (effectiveDamage > 0) {
            HP -= effectiveDamage;
            if (HP < 0) {
                HP = 0;
            }
            System.out.println(this.getClass().getSimpleName() + " tomou " + effectiveDamage + " de dano. Resta " +
                    "HP: " + HP);
            if (HP == 0) {
                System.out.println(this.getNome() + " derrotado.\n");
            }
        } else {
            System.out.println(this.getClass().getSimpleName() + " possui defesa muito alta! Nenhum dano tomado.");
        }
    }
}
