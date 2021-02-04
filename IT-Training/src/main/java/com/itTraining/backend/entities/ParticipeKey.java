package com.itTraining.backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipeKey implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Column(name = "sessions_id")
	Long sessionsId;

	@Column(name = "apprenants_id")
	Long apprenantsId;
	
	public Long getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Long sessionsId) {
		this.sessionsId = sessionsId;
	}

	public Long getApprenantsId() {
		return apprenantsId;
	}

	public void setApprenantsId(Long apprenantsId) {
		this.apprenantsId = apprenantsId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apprenantsId == null) ? 0 : apprenantsId.hashCode());
		result = prime * result + ((sessionsId == null) ? 0 : sessionsId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipeKey other = (ParticipeKey) obj;
		if (apprenantsId == null) {
			if (other.apprenantsId != null)
				return false;
		} else if (!apprenantsId.equals(other.apprenantsId))
			return false;
		if (sessionsId == null) {
			if (other.sessionsId != null)
				return false;
		} else if (!sessionsId.equals(other.sessionsId))
			return false;
		return true;
	}


}
