package com.lebedev.entity;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Show.class)
public abstract class Show_ {

	public static volatile SingularAttribute<Show, LocalDateTime> timeStart;
	public static volatile SingularAttribute<Show, Movie> movie;
	public static volatile SingularAttribute<Show, Long> id;

	public static final String TIME_START = "timeStart";
	public static final String MOVIE = "movie";
	public static final String ID = "id";

}

