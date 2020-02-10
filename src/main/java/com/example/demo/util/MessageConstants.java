package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class MessageConstants {

	public static final String DELETED_CANT_PERFORMED = "Unable to Delete the values";
	public static String getDeletedCantPerformed() {
		return DELETED_CANT_PERFORMED;
	}
	public static String getUpdatedCantPerformed() {
		return UPDATED_CANT_PERFORMED;
	}
	public static String getInsertedCantPerformed() {
		return INSERTED_CANT_PERFORMED;
	}
	public static String getShowCantPerformed() {
		return SHOW_CANT_PERFORMED;
	}
	public static final String UPDATED_CANT_PERFORMED = "Unable to update the values";
	public static final String INSERTED_CANT_PERFORMED = "Unable to insert the values";
	public static final String SHOW_CANT_PERFORMED = "Unable to view the records!!!";

	
	
}
