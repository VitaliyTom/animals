package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;


@Entity
@Table(name = "animals")
public class Animal implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private long animalId;

    @Column(name = "ANIMAL_NAME")
    private String animalName;

    @Column(name = "ID_CATEGORY")
    private int idCategory;

    @Column(name = "ANIMAL_PICTURE")
    private byte[] animalPicture;

    @Column(name = "ANIMAL_SOUND")
    private byte[] animalSound;



    public Animal() {
    }

    public Animal(String animalName, int idCategory, byte[] animalPicture, byte[] animalSound) {
        this.animalName = animalName;
        this.idCategory = idCategory;
        this.animalPicture = animalPicture;
        this.animalSound = animalSound;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", idCategory=" + idCategory +
                ", animalPicture=" + Arrays.toString(animalPicture) +
                ", animalSound=" + Arrays.toString(animalSound) +
                '}';
    }

}

