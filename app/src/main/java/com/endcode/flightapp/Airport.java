package com.endcode.flightapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Airport implements Parcelable {
    private String iata;
    private String icao;
    private String time;
    private String city_code;
    private String country_code;
    private String airport;
    private String latitude;
    private String longitude;
    private String elevation_ft;
    private String region_name;
    private String city;
    private String county;
    private String state;
    private String type;
    private String continent;
    private String iso_region;
    private String scheduled_service;
    private String wikipediaLink;
    private String home;
    private String woeid;
    private String phone;
    private String email;
    private String runwayLength;
    private String flightradar24Link;
    private String radarboxLink;
    private String flightawareLink;

    protected Airport(Parcel in) {
        iata = in.readString();
        icao = in.readString();
        time = in.readString();
        city_code = in.readString();
        country_code = in.readString();
        airport = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        elevation_ft = in.readString();
        region_name = in.readString();
        city = in.readString();
        county = in.readString();
        state = in.readString();
        type = in.readString();
        continent = in.readString();
        iso_region = in.readString();
        scheduled_service = in.readString();
        wikipediaLink = in.readString();
        home = in.readString();
        woeid = in.readString();
        phone = in.readString();
        email = in.readString();
        runwayLength = in.readString();
        flightradar24Link = in.readString();
        radarboxLink = in.readString();
        flightawareLink = in.readString();
    }

    public static final Creator<Airport> CREATOR = new Creator<Airport>() {
        @Override
        public Airport createFromParcel(Parcel in) {
            return new Airport(in);
        }

        @Override
        public Airport[] newArray(int size) {
            return new Airport[size];
        }
    };

    public Airport(String iata, String icao, String time, String cityCode, String countryCode, String airport, String latitude, String longitude, String elevationFt, String regionName, String city, String county, String state, String type, String continent, String isoRegion, String scheduledService, String wikipediaLink, String home, String woeid, String phone, String email, String runwayLength, String flightradar24Url, String radarboxUrl, String flightawareUrl) {
        this.iata = iata;
        this.icao = icao;
        this.time = time;
        this.city_code = cityCode;
        this.country_code = countryCode;
        this.airport = airport;
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation_ft = elevationFt;
        this.region_name = regionName;
        this.city = city;
        this.county = county;
        this.state = state;
        this.type = type;
        this.continent = continent;
        this.iso_region = isoRegion;
        this.scheduled_service = scheduledService;
        this.wikipediaLink = wikipediaLink;
        this.home = home;
        this.woeid = woeid;
        this.phone = phone;
        this.email = email;
        this.runwayLength = runwayLength;
        this.flightradar24Link = flightradar24Url;
        this.radarboxLink = radarboxUrl;
        this.flightawareLink = flightawareUrl;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iata);
        dest.writeString(icao);
        dest.writeString(time);
        dest.writeString(city_code);
        dest.writeString(country_code);
        dest.writeString(airport);
        dest.writeString(latitude);
        dest.writeString(longitude);
        dest.writeString(elevation_ft);
        dest.writeString(region_name);
        dest.writeString(city);
        dest.writeString(county);
        dest.writeString(state);
        dest.writeString(type);
        dest.writeString(continent);
        dest.writeString(iso_region);
        dest.writeString(scheduled_service);
        dest.writeString(wikipediaLink);
        dest.writeString(home);
        dest.writeString(woeid);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(runwayLength);
        dest.writeString(flightradar24Link);
        dest.writeString(radarboxLink);
        dest.writeString(flightawareLink);
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevationFt() {
        return elevation_ft;
    }

    public void setElevation_ft(String elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    public String getRegionName() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIsoRegion() {
        return iso_region;
    }

    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    public String getScheduledService() {
        return scheduled_service;
    }

    public void setScheduled_service(String scheduled_service) {
        this.scheduled_service = scheduled_service;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(String runway_length) {
        this.runwayLength = runway_length;
    }

    public String getFlightradar24Link() {
        return flightradar24Link;
    }

    public void setFlightradar24Link(String flightradar24Link) {
        this.flightradar24Link = flightradar24Link;
    }

    public String getRadarboxLink() {
        return radarboxLink;
    }

    public void setRadarboxLink(String radarboxLink) {
        this.radarboxLink = radarboxLink;
    }

    public String getFlightawareLink() {
        return flightawareLink;
    }

    public void setFlightawareLink(String flightawareLink) {
        this.flightawareLink = flightawareLink;
    }
}
