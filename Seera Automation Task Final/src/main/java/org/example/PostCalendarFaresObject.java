package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;

@Getter
public class PostCalendarFaresObject {
    @JsonProperty("next")
    private JsonNode nextNode;
    @JsonProperty("request")
    private JsonNode requestNode;
}