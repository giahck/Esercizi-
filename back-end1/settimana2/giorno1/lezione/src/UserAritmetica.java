import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAritmetica {
    static Logger logger= LoggerFactory.getLogger("logger1");

    public static void main(String[] args){
        logger.warn("sto lanciando l'applicazione");
        //trace/Debug/info/warn/error
        logger.error("sto terminando l'applicazione");
    }
}
