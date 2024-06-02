package epicode.ese;

public class UserData {
    private String nomeCompleto;
    private int eta;

    public void setData(DataSource ds){
        nomeCompleto = ds.getNomeCompleto();
        eta = ds.getEta();
    }
}
