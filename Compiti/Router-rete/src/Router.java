import java.util.List;

public class Router {

    private static int numero;
    private String ssid;
    private String ipAddress;
    private boolean acceso = false;
    private List<Router> collegamenti;


    public Router(){
        ssid = "Router" + numero;
        numero++;
    }

    public void setSsid(String ssid){
        if(!(ssid.length()>3 && ssid.length()<20)) throw new IllegalArgumentException("SSID non accettabile");
        this.ssid = ssid;
    }

    public void setIpAddress(String ipAddress) {
        String controllo = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
                "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

        if(!ipAddress.matches(controllo)) throw new IllegalArgumentException("Indirizzo IP non valido");
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getSsid() {
        return ssid;
    }

    public void accendiSpegni(){
        acceso = !acceso;
    }

    public void collega(Router r){
        collegamenti.add(r);
    }

    public void mandaMessaggio(String mess, String ipAddress){
        for(Router r: collegamenti){
            if(r.getIpAddress().equals(ipAddress)){
                r.riceviMessaggio(mess);
            }
        }
    }

    public void riceviMessaggio(String mess){

    }

}
