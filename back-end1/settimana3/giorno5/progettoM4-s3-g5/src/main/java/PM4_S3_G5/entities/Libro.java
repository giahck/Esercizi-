package PM4_S3_G5.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Libro extends Catalogo {
    private String autore;
    private String genere;

    public Libro(String titolo, LocalDate dataPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, dataPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public Libro() {
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() + " [autore=" + autore + ", genere=" + genere + "]";
    }
}
