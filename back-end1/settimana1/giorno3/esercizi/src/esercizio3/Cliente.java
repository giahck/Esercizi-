package esercizio3;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {

    String codiceCliente;
    String nome;
    String cognome;
    String email;
    LocalDate dataIscrizione;

    public Cliente(String codiceCliente, String nome, String cognome, String email, LocalDate dataIscrizione) {
        this.codiceCliente = codiceCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }

}
