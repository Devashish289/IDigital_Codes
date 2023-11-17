package com.cog.stockapi.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StockId implements Serializable {

	@Override
	public String toString() {
		return "StockId [supplierId=" + supplierId + ", cropId=" + cropId + "]";
	}
	public StockId()  {
		// TODO Auto-generated constructor stub
	}
	private String supplierId;
	private String cropId;
	
	public StockId(String supplierId, String cropId) {
		super();
		this.supplierId = supplierId;
		this.cropId = cropId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getCropId() {
		return cropId;
	}
	public void setCropId(String cropId) {
		this.cropId = cropId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cropId == null) ? 0 : cropId.hashCode());
		result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
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
		StockId other = (StockId) obj;
		if (cropId == null) {
			if (other.cropId != null)
				return false;
		} else if (!cropId.equals(other.cropId))
			return false;
		if (supplierId == null) {
			if (other.supplierId != null)
				return false;
		} else if (!supplierId.equals(other.supplierId))
			return false;
		return true;
	}
	
	

}
