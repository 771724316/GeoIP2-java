package com.maxmind.geoip2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxmind.geoip2.record.Continent;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.MaxMind;
import com.maxmind.geoip2.record.RepresentedCountry;
import com.maxmind.geoip2.record.Traits;

abstract class AbstractCountryResponse extends AbstractResponse {

    private final Continent continent;
    private final Country country;
    private final Country registeredCountry;
    private final MaxMind maxmind;
    private final RepresentedCountry representedCountry;
    private final Traits traits;

    AbstractCountryResponse(Continent continent, Country country, Country registeredCountry, MaxMind maxmind, RepresentedCountry representedCountry, Traits traits) {
        this.continent = continent != null ? continent : Continent.empty();
        this.country = country != null ? country : Country.empty();
        this.registeredCountry = registeredCountry != null ? registeredCountry : Country.empty();
        this.maxmind = maxmind != null ? maxmind : MaxMind.empty();
        this.representedCountry = representedCountry != null ? representedCountry : RepresentedCountry.empty();
        this.traits = traits != null ? traits : Traits.empty();
    }

    /**
     * @return MaxMind record containing data related to your account.
     */
    @JsonProperty("maxmind")
    public MaxMind getMaxMind() {
        return this.maxmind;
    }

    /**
     * @return Registered country record for the requested IP address. This
     * record represents the country where the ISP has registered a
     * given IP block and may differ from the user's country.
     */
    @JsonProperty("registered_country")
    public Country getRegisteredCountry() {
        return this.registeredCountry;
    }

    /**
     * @return Continent record for the requested IP address.
     */
    public Continent getContinent() {
        return this.continent;
    }

    /**
     * @return Country record for the requested IP address. This object
     * represents the country where MaxMind believes the end user is
     * located.
     */
    public Country getCountry() {
        return this.country;
    }

    /**
     * @return Represented country record for the requested IP address. The
     * represented country is used for things like military bases. It is
     * only present when the represented country differs from the
     * country.
     */
    @JsonProperty("represented_country")
    public RepresentedCountry getRepresentedCountry() {
        return this.representedCountry;
    }

    /**
     * @return Record for the traits of the requested IP address.
     */
    public Traits getTraits() {
        return this.traits;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Country ["
                + (this.getContinent() != null ? "getContinent()="
                + this.getContinent() + ", " : "")
                + (this.getCountry() != null ? "getCountry()="
                + this.getCountry() + ", " : "")
                + (this.getRegisteredCountry() != null ? "getRegisteredCountry()="
                + this.getRegisteredCountry() + ", "
                : "")
                + (this.getRepresentedCountry() != null ? "getRepresentedCountry()="
                + this.getRepresentedCountry() + ", "
                : "")
                + (this.getTraits() != null ? "getTraits()=" + this.getTraits()
                : "") + "]";
    }
}
