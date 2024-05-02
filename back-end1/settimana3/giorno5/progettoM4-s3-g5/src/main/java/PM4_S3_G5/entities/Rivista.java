package PM4_S3_G5.entities;

import PM4_S3_G5.tipoEnum.Periodicita;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "rivista")
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(String titolo, LocalDate dataPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, dataPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista() {
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Rivista [periodicita=" + periodicita + "]";
    }
}
