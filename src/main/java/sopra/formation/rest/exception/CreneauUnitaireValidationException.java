package sopra.formation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Le Créneau unitaire n'a pas pu être créé")
public class CreneauUnitaireValidationException extends RuntimeException {

}
