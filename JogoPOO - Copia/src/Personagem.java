public abstract class Personagem {
    protected String classe;
    protected String nome;
    protected int HP;
    protected int ATTACK;
    protected double DEFENCE;
    protected int SPEED;
    protected int AP;
    protected boolean defendendo;

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATTACK() {
        return ATTACK;
    }

    public void setATTACK(int ATTACK) {
        this.ATTACK = ATTACK;
    }

    public double getDEFENCE() {
        return DEFENCE;
    }

    public void setDEFENCE(int DEFENCE) {
        this.DEFENCE = DEFENCE;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public abstract void Atacar(Esqueleto esqueleto);

    public abstract void Defender();

    public abstract void EscolherHabilidade();

    public abstract void UsarItem();

    public boolean estaDefendendo(Personagem personagem) {
        if (defendendo) {

        } else {

        }
        return true;
    }

    public void tomarDano(int dano) {
        double effectiveDamage = dano - DEFENCE;
        if (effectiveDamage > 0) {
            HP -= effectiveDamage;
            System.out.println(this.getClass().getSimpleName() + " tomou " + effectiveDamage + " de dano. Resta " +
                    "HP: " + HP);
        } else {
            System.out.println(this.getClass().getSimpleName() + " possui defesa muito alta! Nenhum dano tomado.");
        }
    }
}
