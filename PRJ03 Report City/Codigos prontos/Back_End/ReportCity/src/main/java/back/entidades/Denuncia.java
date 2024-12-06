/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

import java.sql.Date ;
import org.postgresql.geometric.PGpoint ;
/**
 *
 * @author nicho
 */
public class Denuncia {
    private String tipo ;
    private String id ;
    private int idPrivate ;
    private String titulo ;
    private String descricao ;
    private PGpoint locacao ;
    private Date created ;
    private Date updated ;
    private String feedback ;
    private String imagem ;
    private Cidadao cidadao ;
    private Status Status ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCoordenadaX() {
        return locacao.x;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.locacao.x = coordenadaX;
    }

    public double getCoordenadaY() {
        return locacao.y;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.locacao.y = coordenadaY;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdPrivate() {
        return idPrivate;
    }

    public void setIdPrivate(int idPrivate) {
        this.idPrivate = idPrivate;
    }
    
    @Override
    public String toString() {
        return "Denuncia{" + "tipo=" + tipo + ", id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", coordenadaX=" + locacao.x + ", coordenadaY=" + locacao.y + ", created=" + created + ", updated=" + updated + ", feedback=" + feedback + ", imagem=" + imagem + ", cidadao=" + cidadao + ", Status=" + Status + '}';
    }

    /*
    Para carregar uma imagem no Java, um jeito simples é usar BufferedImage, que é uma classe que armazena a imagem e suas informações (pixels, tamanho, etc). Você pode modificar uma imagem carregada num BufferedImage aplicando algoritmos sobre os pixels dela.

    Para exibiri uma imagem, você pode usar um JLabel do Swing, um Label no JavaFX ou desenhá-la diretamente sobre um canvas usando Java2D.

    Para salvar uma imagem (possivelmente alterada), você pode usar ImageIo.write 43, que recebe um File com o caminho, um bufferedimage e o formato (jpeg, png, …).

    Para copiar, você pode copiar diretamente pelo sistema operacional, ou basta usar o ImageIO.write para salvar com um nome diferente.*/

    
}
