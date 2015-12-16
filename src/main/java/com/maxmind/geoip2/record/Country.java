package com.maxmind.geoip2.record;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Contains data for the country record associated with an IP address.
 * </p>
 * <p>
 * This record is returned by all the end points.
 * </p>
 */
public class Country extends AbstractNamedRecord {

    private final Integer confidence;
    private final String isoCode;

    public Country(@JsonProperty("names") HashMap<String, String> names, @JsonProperty("geoname_id") Integer geoNameId,
                   @JsonProperty("iso_code") String isoCode, @JsonProperty("confidence") Integer confidence, @JacksonInject("locales") List<String> locales) {
        super(names, geoNameId, locales);
        this.confidence = confidence;
        this.isoCode = isoCode;
    }

    /**
     * @return A value from 0-100 indicating MaxMind's confidence that the
     * country is correct. This attribute is only available from the
     * Insights end point.
     */
    public Integer getConfidence() {
        return this.confidence;
    }

    /**
     * @return The <a
     * href="http://en.wikipedia.org/wiki/ISO_3166-1">two-character ISO
     * 3166-1 alpha code</a> for the country. This attribute is returned
     * by all end points.
     */
    @JsonProperty("iso_code")
    public String getIsoCode() {
        return this.isoCode;
    }

    public static Country empty() {
        return new Country(null, null, null, null, null);
    }

}
