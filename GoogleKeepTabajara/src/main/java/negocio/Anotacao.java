/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author iapereira
 */
public class Anotacao {
    private UUID id;
    private String titulo;
    private String texto;
    private LocalDate dataHora;

    public Anotacao(){
        this.id = UUID.randomUUID();
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Anotacao{" + "id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", dataHora=" + dataHora + '}';
    }
    
    
    
}
