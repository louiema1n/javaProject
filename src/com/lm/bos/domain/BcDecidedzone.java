package com.lm.bos.domain;
// Generated 2016-12-17 22:32:03 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * BcDecidedzone generated by hbm2java
 */
public class BcDecidedzone implements java.io.Serializable {

	private String id;
	private BcStaff bcStaff;
	private String name;
	private Set<BcSubarea> bcSubareas = new HashSet<BcSubarea>(0);

	public BcDecidedzone() {
	}

	public BcDecidedzone(String id) {
		this.id = id;
	}

	public BcDecidedzone(String id, BcStaff bcStaff, String name, Set<BcSubarea> bcSubareas) {
		this.id = id;
		this.bcStaff = bcStaff;
		this.name = name;
		this.bcSubareas = bcSubareas;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BcSubarea> getBcSubareas() {
		return this.bcSubareas;
	}

	public void setBcSubareas(Set<BcSubarea> bcSubareas) {
		this.bcSubareas = bcSubareas;
	}

}
