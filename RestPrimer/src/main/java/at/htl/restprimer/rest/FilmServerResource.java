package at.htl.restprimer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("films")
public class FilmServerResource {

    @GET
    public String time() {
        return "Top 3 imdb films: Der Pate, Die Verurteilten, Schindlers Liste";
    }
}
