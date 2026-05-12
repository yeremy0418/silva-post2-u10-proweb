package com.tareas.gestion_tareas.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By inputUsuario = By.id("input-usuario");
    private final By inputClave = By.id("input-clave");
    private final By btnIngresar = By.id("btn-ingresar");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirUsuario(String usuario) {
        driver.findElement(inputUsuario).clear();
        driver.findElement(inputUsuario).sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        driver.findElement(inputClave).clear();
        driver.findElement(inputClave).sendKeys(clave);
    }

    public void ingresar() {
        driver.findElement(btnIngresar).click();
    }
}
