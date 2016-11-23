/**
 * Created on 13-May-2005
 */
package test.hibernate21;

import java.io.Serializable;

/**
 * @hibernate.class table="PARTS" lazy="true"
 */
public class Part implements Serializable {

	private PartId partId;
	
	private String partName;

	/**
	 * @hibernate.id generator-class="assigned"
	 */
	public PartId getPartId() {
		return partId;
	}

	public void setPartId(PartId partId) {
		this.partId = partId;
	}

	/**
	 * @hibernate.property
	 * @hibernate.column name="part_id"
	 */
	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Part)) return false;
		Part other = (Part) obj;
		return this.partId.equals(other.partId);
	}

}
