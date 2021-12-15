package pl.sdacademy.projekt.task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 2, message = "wartość musi mieć co najmniej {min} 2 znaki")
    private String imię;
    private String nazwisko;
    @Min(message = "wiek musi być > 18", value = 18)
    private int wiek;
    @Email(message = "dany element musi zawierać poprawny adres e-mail")
    private String email;
    private String kierunek;
    @ManyToMany(mappedBy = "studentNauczyciela")
    List<Nauczyciel> nauczycielStudenta;

    public Student() {
    }

    public Student(String imię, String nazwisko, int wiek, String email, String kierunek) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.email = email;
        this.kierunek = kierunek;
    }

    public void setNauczycielStudenta(List<Nauczyciel> nauczycielUcznia) {
        this.nauczycielStudenta = nauczycielUcznia;

    }
}