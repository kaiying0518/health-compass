package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.dto.HealthRecordForm;
import com.example.demo.dto.TriageResult;
import com.example.demo.entity.HealthRecord;
import com.example.demo.repository.HealthRecordRepository;

@Service
public class TriageService {

	private final HealthRecordRepository healthRecordRepository;

	public TriageService(HealthRecordRepository healthRecordRepository) {
		this.healthRecordRepository = healthRecordRepository;
	}

	public TriageResult evaluate(HealthRecordForm form) {

		boolean dangerSign = Boolean.TRUE.equals(form.getDangerSign());
		Double temperature = form.getTemperature();
		Integer heartRate = form.getHeartRate();
		Integer oxygenLevel = form.getOxygenLevel();
		TriageResult triageResult;
		// 高リスク
		if (dangerSign || (oxygenLevel != null && oxygenLevel < 93)) {
			triageResult = new TriageResult(
					"HIGH",
					"少し心配な状態の可能性があります。ひとりで抱え込まず、早めに医療機関に相談してみてください。",
					"可能であれば、できるだけ早く病院や救急外来へ連絡してください。");
		}

		// 中リスク
		else if ((temperature != null && temperature >= 38.5) || (heartRate != null && heartRate >= 110)) {

			triageResult = new TriageResult(
					"MEDIUM",
					"少し体に負担がかかっている可能性があります。無理をせず、様子を見ながら受診も検討してみてください。",
					"時間のあるときに、内科や発熱外来での相談をおすすめします。");
		}

		// 低リスク
		else {
			triageResult = new TriageResult(
					"LOW",
					"今のところ大きな心配はなさそうです。まずはゆっくり休んで、体調の変化を見てみてください。",
					"もし違和感が続いたり不安があれば、無理せず医療機関に相談してください。");

		}
		HealthRecord record = new HealthRecord();
		record.setSymptom(form.getSymptomNote());
		record.setDangerFlag(form.getDangerSign());
		record.setResult(triageResult.getLevel());
		record.setCreatedAt(LocalDateTime.now());

		healthRecordRepository.save(record);

		return triageResult;
	}
}
