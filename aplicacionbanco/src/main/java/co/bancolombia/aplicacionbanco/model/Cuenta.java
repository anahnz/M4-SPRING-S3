package co.bancolombia.aplicacionbanco.model;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Cuenta {
    @NotNull(message = "Debe ingresar el número de cuenta")
    @NotEmpty(message = "La cuenta no puede estar vacia")
    private String numCuenta;
    private BigDecimal saldo;


    public Cuenta(){}
    public Cuenta(String numCuenta){
        this.numCuenta = numCuenta;
        this.saldo = BigDecimal.valueOf(0);
    }

    public Cuenta(String numCuenta, BigDecimal saldo) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal monto) {
        this.saldo = this.saldo.add(monto);
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public boolean retirar(BigDecimal monto) {
        if (this.saldo.compareTo(monto) >= 0) {
            this.saldo = this.saldo.subtract(monto);
            return true;
        }
        return false;
    }
}


