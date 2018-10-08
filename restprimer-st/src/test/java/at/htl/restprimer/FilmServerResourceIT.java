package at.htl.restprimer;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;


public class FilmServerResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8085/restprimer/rs/films");
    }

    @Test
    public void fetchFilms() {
        Response response = this.tut.request(MediaType.TEXT_PLAIN_TYPE).get();

        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        assertThat(payload, startsWith("Top 3 imdb")); //bessere Fehlermeldung!!!
    }


}
