package com.lib.gl.skyscraper;

import java.util.List;

public class MainBuilder {

	public static void main(String[] args) {
		Skyscraper obj = new Skyscraper();
		List floorSizes = obj.getDesignDetails();
		obj.assembleBuilding(floorSizes);
	}
}
