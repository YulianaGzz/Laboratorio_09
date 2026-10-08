public abstract class Personaje 
{
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo = true;

    public Personaje(String nombre, int nivel, int puntosVida) 
    {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
    }

    public abstract void atacar() throws RpgException;
    public abstract int calcularDanio();

    public void recibirDanio(int danio) throws AccionInvalidaException 
    {
        if (danio < 0) 
            {
                throw new AccionInvalidaException("recibirDanio", "El dano no puede ser negativo: " + danio);
            }
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio + " de dano. Vida: " + puntosVida);
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
    public abstract void defender();

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntosVida() { return puntosVida; }

    public boolean isEstaVivo() { return estaVivo; }

}
