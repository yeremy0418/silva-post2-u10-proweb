package com.tareas.gestion_tareas.e2e;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@Import(StaticUiController.class)
class TareasE2ETest {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless", "--no-sandbox");
        driver = new ChromeDriver(opts);
        driver.get("http://localhost:8080/tareas");
    }

    @Test
    void paginaTareas_cargaCorrectamente() {
        assertThat(driver.getTitle()).contains("Tareas");
    }

    @Test
    void crearTarea_incrementaLista() {
        TareasPage tareas = new TareasPage(driver);
        int antes = tareas.contarTareas();

        NuevaTareaPage nueva = tareas.irANuevaTarea();
        nueva.escribirTitulo("Aprender Selenium");
        nueva.escribirDescripcion("Completar el checkpoint 1");
        nueva.guardar();

        TareasPage tareasActualizada = new TareasPage(driver);
        int despues = tareasActualizada.contarTareas();

        assertThat(despues).isGreaterThan(antes);
        assertThat(driver.getTitle()).contains("Tareas");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
