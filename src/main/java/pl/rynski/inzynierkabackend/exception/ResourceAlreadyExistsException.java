package pl.rynski.inzynierkabackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ResourceAlreadyExistsException extends RuntimeException  {
    public ResourceAlreadyExistsException(String resourceName, String fieldValue) {
        super(String.format("%s o nazwie %s już istnieje.", resourceName, fieldValue));
    }
}
