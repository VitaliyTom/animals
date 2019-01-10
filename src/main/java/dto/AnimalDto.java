
package dto;

import entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class AnimalDto {


    private long animalId;
    private String animalName;
    private Category categoryAnimal;
    private byte[] animalPicture;
    private byte[] animalSound;


    public AnimalDto() {
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public byte[] getAnimalPicture() {
        return animalPicture;
    }

    public void setAnimalPicture(byte[] animalPicture) {
        this.animalPicture = animalPicture;
    }

    public byte[] getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(byte[] animalSound) {
        this.animalSound = animalSound;
    }

    public Category getCategoryAnimal() {
        return categoryAnimal;
    }

    public void setCategoryAnimal(Category categoryAnimal) {
        this.categoryAnimal = categoryAnimal;
    }
}