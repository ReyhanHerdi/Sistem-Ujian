/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DAFFA
 */
public class Peserta {

    /**
     * @return the id_peserta
     */
    public Integer getId_peserta() {
        return id_peserta;
    }

    /**
     * @param id_peserta the id_peserta to set
     */
    public void setId_peserta(Integer id_peserta) {
        this.id_peserta = id_peserta;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nama_peserta
     */
    public String getNama_peserta() {
        return nama_peserta;
    }

    /**
     * @param nama_peserta the nama_peserta to set
     */
    public void setNama_peserta(String nama_peserta) {
        this.nama_peserta = nama_peserta;
    }

    /**
     * @return the tgl_lahir
     */
    public String getTgl_lahir() {
        return tgl_lahir;
    }

    /**
     * @param tgl_lahir the tgl_lahir to set
     */
    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    /**
     * @return the no_telp
     */
    public String getNo_telp() {
        return no_telp;
    }

    /**
     * @param no_telp the no_telp to set
     */
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the jenis_kelamin
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     * @param jenis_kelamin the jenis_kelamin to set
     */
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the skor_mtk
     */
    public Integer getSkor_mtk() {
        return skor_mtk;
    }

    /**
     * @param skor_mtk the skor_mtk to set
     */
    public void setSkor_mtk(Integer skor_mtk) {
        this.skor_mtk = skor_mtk;
    }
    
    /**
     * @return the skor_bind
     */
    public Integer getSkor_bind() {
        return skor_bind;
    }
    
    /**
     * @param skor_bind the skor_bind to set
     */
    public void setSkor_bind(Integer skor_bind) {
        this.skor_bind = skor_bind;
    }

    private Integer id_peserta;
    private String email;
    private String nama_peserta;
    private String tgl_lahir;
    private String no_telp;
    private String kelas;
    private String jenis_kelamin;
    private String password;
    private Integer skor_mtk;
    private Integer skor_bind;

}
