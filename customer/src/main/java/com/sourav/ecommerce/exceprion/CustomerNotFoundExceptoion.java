package com.sourav.ecommerce.exceprion;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerNotFoundExceptoion extends RuntimeException {
		
	private final String msg;
}
