package jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EqualsAndHashCode
public class AbstractEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue
	private Long id;

}