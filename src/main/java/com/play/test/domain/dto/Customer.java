package com.play.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.play.test.infrastructure.configuration.time.JsonJodaDateTimeDeserializer;
import com.play.test.infrastructure.configuration.time.JsonJodaDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    private Long id;
    private String name;

    @JsonProperty("duetime")
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    @JsonDeserialize(using = JsonJodaDateTimeDeserializer.class)
    private DateTime dueTime;

    @JsonProperty("jointime")
    @JsonSerialize(using = JsonJodaDateTimeSerializer.class)
    @JsonDeserialize(using = JsonJodaDateTimeDeserializer.class)
    private DateTime joinTime;

}
