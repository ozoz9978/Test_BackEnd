package com.kdigital.test2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Fitness {
	private String name;
	private String gender;
	private double height;
	private double weight;
	private double stdWeight;
	private double bmi;
	private String bmiResult;
	
	public Fitness(String name, String gender, double height, double weight) {
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		
		calcStdWeight();
		calcBMI();
	}

	public void setHeight(double height) {
		this.height = height;
		calcStdWeight();
		calcBMI();
	}

	public void setWeight(double weight) {
		this.weight = weight;
		calcStdWeight();
		calcBMI();
	}

	private void calcStdWeight() {
		double temp = height / 100;   // m로 환산된 키

		if(gender.equals("남")) {  // 기본자료형만 ==으로 비교
			stdWeight = temp * temp * 22;	
		} else {
			stdWeight = temp * temp * 21;	
		}
	}
	
	private void calcBMI() {
		double temp = height / 100;   // m로 환산된 키
		
		bmi = weight / (temp * temp);
		calcBmiResult();
	}

	private void calcBmiResult() {
		// BMI 결과 처리
		if(bmi >= 35) 		bmiResult = "고도 비만";
		else if(bmi >= 30) 	bmiResult = "중(重)도 비만 (2단계 비만)";
		else if(bmi >= 25) 	bmiResult = "경도 비만 (1단계 비만)";
		else if(bmi >= 23) 	bmiResult = "과체중";
		else if(bmi >= 18.5)bmiResult = "정상";
		else 				bmiResult = "저체중";
	}
	
	@Override
	public String toString() {
		String data = String.format("%s %s %.2fcm %.2fKg 표준체중: %.2f BMI: %.2f %s%n",
				name, gender, height, weight, stdWeight, bmi, bmiResult);
		return data;
	}
}
