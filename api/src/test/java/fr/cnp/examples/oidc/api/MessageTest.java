package fr.cnp.examples.oidc.api;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nchapon on 22/12/17.
 */

public class MessageTest {


    @Test
    public void creation() {
        // Test Lombok plugin
        Message m = new Message(1L,"public");
        assertThat(m.getId()).isEqualTo(1L);
        assertThat(m.getMessage()).isEqualTo("public");

    }
}
