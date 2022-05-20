package com.pnap.bmc_sdk.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Reserve specific server request object.
 * @author DCAutomation
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ReserveServerRequestDTO implements Serializable {
	
	private static final long serialVersionUID = -6225682730190635149L;
	
	/**
	 * Server pricing model
	 * Currently this field should be set to ONE_MONTH_RESERVATION, TWELVE_MONTHS_RESERVATION, TWENTY_FOUR_MONTHS_RESERVATION or THIRTY_SIX_MONTHS_RESERVATION.
	 */
	private String pricingModel;

	public String getPricingModel() {
		return pricingModel;
	}

	public void setPricingModel(String pricingModel) {
		this.pricingModel = pricingModel;
	}

	/**
	 * Default constructor
	 */
	public ReserveServerRequestDTO() {
		
	}

	/**
	 * Params constructor
	 * @param pricingModel
	 */
	public ReserveServerRequestDTO(String pricingModel) {
		this.pricingModel = pricingModel;
	}

	@Override
	public String toString() {
		return "ReserveServerRequestDTO [pricingModel=" + pricingModel + "]";
	}
	
}
