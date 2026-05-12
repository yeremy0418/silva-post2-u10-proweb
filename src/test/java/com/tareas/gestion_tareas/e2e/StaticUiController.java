package com.tareas.gestion_tareas.e2e;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@TestConfiguration
class StaticUiController {

    @RestController
    @RequestMapping("/")
    static class Controller {
        @GetMapping(value = "/tareas", produces = MediaType.TEXT_HTML_VALUE)
        String tareas() {
            return "<!doctype html>"
                + "<html><head><title>Tareas</title></head>"
                + "<body>"
                + "<button id='btn-nueva' onclick=\"location.href='/tareas/nueva'\">Nueva</button>"
                + "<ul><li class='tarea-item'>Tarea 1</li></ul>"
                + "</body></html>";
        }

        @GetMapping(value = "/tareas/nueva", produces = MediaType.TEXT_HTML_VALUE)
        String nueva() {
            return "<!doctype html>"
                + "<html><head><title>Nueva tarea</title></head>"
                + "<body>"
                + "<form method='post'>"
                + "<input id='input-titulo' name='titulo' />"
                + "<textarea id='input-descripcion' name='descripcion'></textarea>"
                + "<button id='btn-guardar' type='submit'>Guardar</button>"
                + "</form>"
                + "</body></html>";
        }

        @PostMapping(value = "/tareas/nueva", produces = MediaType.TEXT_HTML_VALUE)
        String creada() {
            return "<!doctype html>"
                + "<html><head><title>Tareas</title></head>"
                + "<body>"
                + "<button id='btn-nueva' onclick=\"location.href='/tareas/nueva'\">Nueva</button>"
                + "<ul>"
                + "<li class='tarea-item'>Tarea 1</li>"
                + "<li class='tarea-item'>Tarea 2</li>"
                + "</ul>"
                + "</body></html>";
        }
    }
}
