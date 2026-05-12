package com.tareas.gestion_tareas.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NuevaTareaPage {
    private final WebDriver driver;
    private final By inputTitulo = By.id("input-titulo");
    private final By inputDescripcion = By.id("input-descripcion");
    private final By btnGuardar = By.id("btn-guardar");

    public NuevaTareaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirTitulo(String titulo) {
        driver.findElement(inputTitulo).clear();
        driver.findElement(inputTitulo).sendKeys(titulo);
    }

    public void escribirDescripcion(String descripcion) {
        driver.findElement(inputDescripcion).clear();
        driver.findElement(inputDescripcion).sendKeys(descripcion);
    }

    public void guardar() {
        driver.findElement(btnGuardar).click();
    }
}
