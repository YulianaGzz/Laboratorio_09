public class AccionInvalidaException extends RpgException 
{
    public AccionInvalidaException(String accion, String razon) 
    {
        super("Accion invalida '" + accion + "': " + razon);
    }
}