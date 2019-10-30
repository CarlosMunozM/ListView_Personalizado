package com.example.listviewpersonalizado;

public class Noticias {
    String titulo;
    String subtitulo;
    String subtitulo2;

    public Noticias(String titulo, String subtitulo) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public Noticias(String titulo, String subtitulo, String subtitulo2) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.subtitulo2 = subtitulo2;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getSubtitulo()
    {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo)
    {
        this.subtitulo = subtitulo;
    }

    public String getSubtitulo2() {
        return subtitulo2;
    }

    public void setSubtitulo2(String subtitulo2) {
        this.subtitulo2 = subtitulo2;
    }
}
