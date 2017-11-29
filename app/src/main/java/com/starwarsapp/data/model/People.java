package com.starwarsapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class People implements Serializable, Parcelable {

    public String name;

    @SerializedName("birth_year")
    public String birthYear;

    public String gender;

    @SerializedName("hair_color")
    public String hairColor;

    public String height;

    @SerializedName("homeworld")
    public String homeWorldUrl;

    public String mass;

    @SerializedName("skin_color")
    public String skinColor;

    @SerializedName("films")
    public List<String> filmsUrls;

    @SerializedName("species")
    public List<String> speciesUrls;

    @SerializedName("starships")
    public List<String> starshipsUrls;

    @SerializedName("vehicles")
    public List<String> vehiclesUrls;

    public boolean isFavourite;

    public float birthFloat;

    public People(String name, String birthYear, String gender, String hairColor,
                  String height, String homeWorldUrl, String mass, String skinColor,
                  List<String> filmsUrls, List<String> speciesUrls,
                  List<String> starshipsUrls, List<String> vehiclesUrls, boolean isFavourite) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.homeWorldUrl = homeWorldUrl;
        this.mass = mass;
        this.skinColor = skinColor;
        this.filmsUrls = filmsUrls;
        this.speciesUrls = speciesUrls;
        this.starshipsUrls = starshipsUrls;
        this.vehiclesUrls = vehiclesUrls;
        this.isFavourite = isFavourite;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHomeWorldUrl() {
        return homeWorldUrl;
    }

    public void setHomeWorldUrl(String homeWorldUrl) {
        this.homeWorldUrl = homeWorldUrl;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public List<String> getFilmsUrls() {
        return filmsUrls;
    }

    public void setFilmsUrls(List<String> filmsUrls) {
        this.filmsUrls = filmsUrls;
    }

    public List<String> getSpeciesUrls() {
        return speciesUrls;
    }

    public void setSpeciesUrls(List<String> speciesUrls) {
        this.speciesUrls = speciesUrls;
    }

    public List<String> getStarshipsUrls() {
        return starshipsUrls;
    }

    public void setStarshipsUrls(List<String> starshipsUrls) {
        this.starshipsUrls = starshipsUrls;
    }

    public List<String> getVehiclesUrls() {
        return vehiclesUrls;
    }

    public void setVehiclesUrls(List<String> vehiclesUrls) {
        this.vehiclesUrls = vehiclesUrls;
    }

    public float getBirthFloat() {
        return birthFloat;
    }

    public void setBirthFloat(float birthFloat) {
        this.birthFloat = birthFloat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(birthYear);
        dest.writeString(gender);
        dest.writeString(hairColor);
        dest.writeString(height);
        dest.writeString(homeWorldUrl);
        dest.writeString(mass);
        dest.writeString(skinColor);
        dest.writeByte((byte) (isFavourite ? 1 : 0));
        dest.writeStringList(vehiclesUrls);
        dest.writeStringList(filmsUrls);
        dest.writeStringList(speciesUrls);

    }

    public People(Parcel parcel) {
        this.name = parcel.readString();
        this.birthYear = parcel.readString();
        this.gender = parcel.readString();
        this.hairColor = parcel.readString();
        this.height = parcel.readString();
        this.homeWorldUrl = parcel.readString();
        this.mass = parcel.readString();
        this.skinColor = parcel.readString();
        this.isFavourite = parcel.readByte() != 0;
        this.vehiclesUrls = new ArrayList<>();
        parcel.readStringList(this.vehiclesUrls);
        this.filmsUrls = new ArrayList<>();
        parcel.readStringList(this.filmsUrls);
        this.speciesUrls = new ArrayList<>();
        parcel.readStringList(this.speciesUrls);

    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {

        @Override
        public People createFromParcel(Parcel source) {
            return new People(source);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };
}
