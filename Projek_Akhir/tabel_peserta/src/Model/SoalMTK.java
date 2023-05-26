/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DAFFA
 */
public class SoalMTK {

    /**
     * @return the id_soal
     */
    public Integer getId_soal() {
        return id_soal;
    }

    /**
     * @param id_soal the id_soal to set
     */
    public void setId_soal(Integer id_soal) {
        this.id_soal = id_soal;
    }

    /**
     * @return the pertanyaan
     */
    public String getPertanyaan() {
        return pertanyaan;
    }

    /**
     * @param pertanyaan the pertanyaan to set
     */
    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    /**
     * @return the jawaban
     */
    public String getJawaban() {
        return jawaban;
    }

    /**
     * @param jawaban the jawaban to set
     */
    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    private Integer id_soal;
    private String pertanyaan;
    private String jawaban;

}
