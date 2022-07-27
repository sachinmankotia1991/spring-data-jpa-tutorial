package com.sachin.demo.entity;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"guardianName", "guardianEmail", "guardianMobile"})

public class Guardian {

	private String guardianName;

	private String guardianEmail;

	private String guardianMobile;

}
