package sopra.formation.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Le Créneau praticien n'a pu être créé")
public class CreneauPraticienValidationException extends RuntimeException {

}
