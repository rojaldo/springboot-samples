package com.example.examples.forms;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerForm {
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    String name;

    @Size(min = 1, max = 255, message = "Tagline must be between 1 and 255 characters")
    String tagline;

    @Size(min = 0, max = 255, message = "First brewed must be between 0 and 255 characters")
    String firstBrewed;

    @Size(min = 0, max = 255, message = "Description must be between 0 and 255 characters")
    String description;

    @Size(min = 0, max = 255, message = "Image URL must be between 0 and 255 characters")
    @URL(message = "Image URL must be valid")
    String imageUrl;

    @Min(value = 0, message = "ABV must be greater than or equal to 0")
    @Max(value = 100, message = "ABV must be less than or equal to 100")
    double abv;

    @Min(value = 0, message = "IBU must be greater than or equal to 0")
    double ibu;

    @Min(value = 0, message = "EBC must be greater than or equal to 0")
    double ebc;

    public BeerForm() {
    }

    public BeerForm(String name, String tagline, String firstBrewed, String description, String imageUrl, double abv,
            double ibu, double ebc) {
        this.setName(name);
        this.setTagline(tagline);
        this.setFirstBrewed(firstBrewed);
        this.setDescription(description);
        this.setImageUrl(imageUrl);
        this.setAbv(abv);
        this.setIbu(ibu);
        this.setEbc(ebc);
    }

    

}
