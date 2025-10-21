/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.math.BigDecimal;
import java.sql.Date;
/**
 *
 * @author kristhor
 */
public class Combustibles {
    private int idCombustible;
    private int idActivo;
    private Integer idUsuario;  
    private Date fecha;
    private String tipoCombustible;  
    private BigDecimal litros;
    private BigDecimal precioLitro;
    private BigDecimal montoTotal;
    private BigDecimal kilometraje;
    private String estacionServicio;
    private String observaciones;

    public Combustibles(int idCombustible, int idActivo, Integer idUsuario, Date fecha, String tipoCombustible, BigDecimal litros, BigDecimal precioLitro, BigDecimal montoTotal, BigDecimal kilometraje, String estacionServicio, String observaciones) {
        this.idCombustible = idCombustible;
        this.idActivo = idActivo;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.tipoCombustible = tipoCombustible;
        this.litros = litros;
        this.precioLitro = precioLitro;
        this.montoTotal = montoTotal;
        this.kilometraje = kilometraje;
        this.estacionServicio = estacionServicio;
        this.observaciones = observaciones;
    }

    public int getIdCombustible() {
        return idCombustible;
    }

    public void setIdCombustible(int idCombustible) {
        this.idCombustible = idCombustible;
    }

    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public BigDecimal getPrecioLitro() {
        return precioLitro;
    }

    public void setPrecioLitro(BigDecimal precioLitro) {
        this.precioLitro = precioLitro;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public BigDecimal getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(BigDecimal kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getEstacionServicio() {
        return estacionServicio;
    }

    public void setEstacionServicio(String estacionServicio) {
        this.estacionServicio = estacionServicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
