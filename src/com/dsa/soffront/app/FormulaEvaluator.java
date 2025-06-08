package com.dsa.soffront.app;

public class FormulaEvaluator {
	static class Calculation {
		public String calculateField;
		public String formula;
	}

	public static void main(String[] args) {
		String jsonInput = "[{\"calculateField\":\"customFloat1\",\"formula\": \"10+15\"},"
				+ "{\"calculateField\":\"customFloat2\",\"formula\": \"customFloat1*10\"},"
				+ "{\"calculateField\":\"customFloat3\",\"formula\": \"customFloat2-18\"},"
				+ "{\"calculateField\":\"customFloat4\",\"formula\": \"customFloat3+customFloat2\"}]";

		//ObjectMapper
	}
}
