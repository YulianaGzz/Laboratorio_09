public class PersonajeDerrotadoException extends RpgException 
{
    private String nombrePersonaje;
    public PersonajeDerrotadoException(String nombrePersonaje) 
    {
        super("El personaje '" + nombrePersonaje + "' esta derrotado y no puede realizar esta accion.");
        this.nombrePersonaje = nombrePersonaje;
    }
    public String getNombrePersonaje() 
    {
        return nombrePersonaje;
    }
}
