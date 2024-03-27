package org.example.accuweather.weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DateTime",
        "EpochDateTime",
        "WeatherIcon",
        "IconPhrase",
        "HasPrecipitation",
        "IsDaylight",
        "Temperature",
        "PrecipitationProbability",
        "MobileLink",
        "Link"
})

public class HourlyForecast {

    @JsonProperty("DateTime")
    private String dateTime;
    @JsonProperty("EpochDateTime")
    private Integer epochDateTime;
    @JsonProperty("WeatherIcon")
    private int weatherIcon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
    @JsonProperty("IsDaylight")
    private boolean isDaylight;
    @JsonProperty("Temperature")
    private HourlyTemperature temperature;
    @JsonProperty("PrecipitationProbability")
    private int precipitationProbability;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getEpochDateTime() {
        return epochDateTime;
    }

    public void setEpochDateTime(Integer epochDateTime) {
        this.epochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return isDaylight;
    }

    public void setDaylight(boolean daylight) {
        isDaylight = daylight;
    }

    public HourlyTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(HourlyTemperature temperature) {
        this.temperature = temperature;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
