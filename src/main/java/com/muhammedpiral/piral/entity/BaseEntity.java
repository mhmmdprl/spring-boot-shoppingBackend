package com.muhammedpiral.piral.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "UUID", unique = true)
	private UUID uuid;

	@Column(name = "DELETED")
	private Character deleted = '0';

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = false, updatable = false)
	private Date createdDate;

	@Column(name = "CREATED_BY", nullable = false, updatable = false)
	private Long createdBy = 1L;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;

	@Column(name = "UPDATED_BY", insertable = false)
	private Long updatedBy;

	protected BaseEntity() {
		this.uuid = UUID.randomUUID();
	}
}
