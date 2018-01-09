package fr.cnp.examples.oidc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nchapon on 22/12/17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private long id;
    private String message;
}
