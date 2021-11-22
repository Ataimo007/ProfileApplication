package com.godcodes.SpringApplicationGradle.models;

import javax.persistence.*;
import java.util.Arrays;

@MappedSuperclass
public class Model<T extends Model>
{
//    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence" )

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    public void update(T update)
    {
        Arrays.stream(update.getClass().getDeclaredFields()).filter(field -> {
            try {
                return field.getDeclaredAnnotation(Transient.class) == null && field.get(update) != null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        }).forEach(field -> {
            try {
                field.set(this, field.get(update));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
