public class Pistoleiro extends Inimigo{
    private String classe;
    private String nome;
    private int HP;
    private int ATTACK;
    private int DEFENCE;
    private int SPEED;
    private int AP;

    public Pistoleiro(String classe, String nome, int HP, int ATTACK, int DEFENCE, int SPEED,
              int AP) {
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
        return HP;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void Atacar(Espadachim espadachim) {
        System.out.println("Vex ataca " + espadachim.getNome());
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
            System.out.println(this.getNome() + " tomou " + effectiveDamage + " de dano. Resta " +
                    "HP: " + HP);
            if (HP == 0) {
                System.out.println(this.getNome() + " derrotado.\n");
            }
        } else {
            System.out.println(this.getClass().getSimpleName() + " possui defesa muito alta! Nenhum dano tomado.");
        }
    }

    public void Defender(){

    }

    public void EscolherHabilidade(){

    }

    public void UsarItem(){

    }


}
