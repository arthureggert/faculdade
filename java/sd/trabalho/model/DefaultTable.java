package br.com.ahe.sd.trabalho.model;


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@MappedSuperclass
public abstract class DefaultTable implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
    @Getter
    @GeneratedValue
    private Long id;
}
