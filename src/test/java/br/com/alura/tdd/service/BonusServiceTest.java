package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("25000")));

        Assert.assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("2500")));

        Assert.assertEquals(new BigDecimal("250.00"), bonus);
        System.out.println(bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente1000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Alexandre", LocalDate.now(), new BigDecimal("10000")));

        Assert.assertEquals(new BigDecimal("1000.00"), bonus);
        System.out.println(bonus);
    }
}