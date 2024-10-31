public abstract class Inimigo {
    protected String classe;
    protected String nome;
    protected int HP;
    protected int ATTACK;
    protected int DEFENCE;
    protected int SPEED;
    protected int AP;

    public int getHP() {
        return HP;
    }

    public boolean estaVivo() {
        return HP > 0;
    }

    public abstract void Atacar(Espadachim espadachim);

    public void tomarDano(int dano) {
        int effectiveDamage = dano - DEFENCE;
        if (effectiveDamage > 0) {
            HP -= effectiveDamage;
            System.out.println(this.getClass().getSimpleName() + " tomou " + effectiveDamage + " de dano. Resta " +
                    "HP: " + HP);
        } else {
            System.out.println(this.getClass().getSimpleName() + " possui defesa muito alta! Nenhum dano tomado.");
        }
    }
}
