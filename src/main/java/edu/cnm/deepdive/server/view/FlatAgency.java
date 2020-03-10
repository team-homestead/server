package edu.cnm.deepdive.server.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.NonNull;

/**
 * Interface for Json/Spring created.
 */
@JsonPropertyOrder({"id", "agency_type", "href"})
public interface FlatAgency {

@NonNull
UUID getId();

@NonNull
URI getHref();

}

